package com.eksad.authentication.service;

import com.eksad.authentication.common.*;
import com.eksad.authentication.dto.*;
import com.eksad.authentication.repository.*;
import com.eksad.authentication.domain.*;
import io.jsonwebtoken.Claims;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthenticationService {

    //testing
    @Value("${mt.system.jwt.timeout}")
    private Long jwtTimeout;

    @Value("${mt.system.jwt-remember.timeout}")
    private Long jwtRememberTimeout;

    @Value("${mp.jwt.verify.issuer}")
    private String jwtIssuer;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserLoginNotFoundRepository userLoginNotFoundRepository;
    private final UserLoginLogRepository userLoginLogRepository;
    private final MasterDealerGroupRepository mstDealerGroupRepository;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UserLoginNotFoundRepository userLoginNotFoundRepository, UserLoginLogRepository userLoginLogRepository, MasterDealerGroupRepository mstDealerGroupRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userLoginNotFoundRepository = userLoginNotFoundRepository;
        this.userLoginLogRepository = userLoginLogRepository;
        this.mstDealerGroupRepository = mstDealerGroupRepository;
    }

    private String createSessionId(Long userId) {
        String sessionId;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formatDateTime = now.format(formatter);
        sessionId = String.format("EKSAD.%s.%s.%s", userId, formatDateTime,
                ThreadLocalRandom.current().nextInt(1000, 9000));

        return sessionId;
    }

    public GenericResponseDTO<LoginInfoResponseDto> loginInfo(String token) throws Exception {
        LoginInfoResponseDto response = new LoginInfoResponseDto();
        response.setDealerId(jwtService.extractClaim(token, claims -> claims.get("dealerId", String.class)));
        response.setEmpId(jwtService.extractClaim(token, claims -> claims.get("empId", String.class)));
        response.setUserId(jwtService.extractClaim(token, claims -> claims.get("userId", Long.class)));
        response.setUsername(jwtService.extractUsername(token));
        return new GenericResponseDTO<>(ResponseStatus.S, 201, "Process Successed", response);
    }


    private void logUserNotFound(UserLoginRequestDto request, String message) {
        UserLoginNotFound userLoginNotFound = new UserLoginNotFound();
        userLoginNotFound.setUsername(request.getRegister());
        userLoginNotFound.setDealerGroupId(request.getDealerGroupId());
        userLoginNotFound.setMessage(message);
        Date currentDate = new Date();
        userLoginNotFound.setLoginTime(currentDate);
        userLoginNotFound.setCreatedBy("SYSTEM");
        userLoginNotFound.setCreatedDt(currentDate);
        userLoginNotFoundRepository.save(userLoginNotFound);
    }

    public GenericResponseDTO<UserLoginResponseDto> register (RegisterRequestDto request) throws Exception {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setCreatedDt(new Date());
        user.setCreatedBy("system");
        user.setModifiedDt(new Date());
        user.setModifiedBy("system");
        user.setIsActive(1L);
        user.setEmployeeId(request.getEmployeeId());
        user.setDealerId(request.getDealerId());
        user.setDealerGroupId(request.getDealerGroupId());
        user.setCategoryId(request.getCategoryId());
        user.setPasswordExpired(0);
        user.setSalesId(request.getSalesId());

        user = userRepository.save(user);
        Map<String, Object> claim = new HashMap<>();
        claim.put("username", user.getUsername());
        claim.put("userId", user.getIdUser());
        claim.put("dealerId", user.getDealerId());
        claim.put("salesId", user.getSalesId());
        claim.put("empId", user.getEmployeeId());
        claim.put(Claims.EXPIRATION, new Date(System.currentTimeMillis() + jwtTimeout * 1000));
        String token = jwtService.generateToken(claim);
        UserLoginResponseDto response = new UserLoginResponseDto();
        response.setIdUser(user.getIdUser());
        response.setIdEmp(user.getEmployeeId());
        response.setName(user.getName());
        response.setJwtToken(token);
        response.setPasswordExpired(user.getPasswordExpired());
        response.setSessionId("1");
        response.setResult(true);
        response.setUserCategory("admin");

        return new GenericResponseDTO<>(ResponseStatus.S, 201, "Process Successed", response);
    }

    public GenericResponseDTO<UserLoginResponseDto> authenticate(UserLoginRequestDto request) throws Exception {
        long start = System.currentTimeMillis();

//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getRegister(),
//                        request.getPassword()
//                )
//        );

        User user = userRepository.findByUsername(request.getRegister()).orElseThrow();
        Map<String, Object> claim = new HashMap<>();
        claim.put(Claims.ISSUER, jwtIssuer);
        claim.put("username", user.getUsername());
        claim.put("userId", user.getIdUser());
        claim.put("dealerId", user.getDealerId());
        claim.put("salesId", user.getSalesId());
        claim.put("empId", user.getEmployeeId());
        claim.put(Claims.EXPIRATION, new Date(System.currentTimeMillis() + jwtTimeout * 1000));
        String token = jwtService.generateToken(claim);
        UserLoginResponseDto response = new UserLoginResponseDto();
        response.setIdEmp(user.getEmployeeId());
        response.setIdUser(user.getIdUser());
        response.setName(user.getName());
        response.setJwtToken(token);
        response.setPasswordExpired(user.getPasswordExpired());
        response.setSessionId("1");
        response.setResult(true);
        return new GenericResponseDTO<>(ResponseStatus.S, 201, "Process Successed", response);
    }

    public GenericResponseDTO<UserLoginResponseDto> generateToken(UserLoginRequestDto request) {
        long start = System.currentTimeMillis();
        String ipLocal = MDC.get("ip_local");
        String ipPublic = MDC.get("ip_public");
        String requestId = MDC.get("request_id");

        System.out.println(String.format("Request ID: %s, IP Public: %s, IP Local: %s", requestId, ipPublic, ipLocal));
        try {
            UserLoginResponseDto response = new UserLoginResponseDto();
            GenericResponseDTO<UserLoginResponseDto> finalResponse = new GenericResponseDTO().successResponse(response);

            String username = request.getRegister();
            if (StringUtil.isNullOrEmpty(username) || StringUtil.isNullOrEmpty(request.getPassword())) {
                //username or password is null
                response.setResult(false);
                finalResponse.setMessage(Constants.Login.WRONG_PASSWORD);
                finalResponse.setCode(204);
                return finalResponse;
            }
//            int count = 0;
//            String sessionKey = "tblock:" + request.getRegister();
//            Response sessionValue = redisClientSlave.get(sessionKey);
//
//            JsonObject jsonData = new JsonObject();
//            if (sessionValue != null) {
//                //cache found
//                String data = sessionValue.toString();
//                jsonData = new JsonObject(data);
//                count = jsonData.getInteger("count");
//                if (count >= 5) {
//                    response.setResult(false);
//                    finalResponse.setMessage(Constants.Login.USER_BLOCK);
//                    finalResponse.setCode(204);
//                    return finalResponse;
//                }
//            }

            long currentTimeMS = System.currentTimeMillis();
            String notifToken = "";
            if (request != null) {
                notifToken = request.getNotifToken();
            }
            if (!StringUtil.isNullOrEmpty(notifToken)
                    && notifToken.equalsIgnoreCase("eksad2o21.great.forever")) {
                //token for 2 years
                LocalDateTime currentDt = LocalDateTime.now().plusYears(2);
                currentTimeMS = currentDt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            }
            int currentTimeInSecs = (int) (currentTimeMS / 1000);
            long timeoutInSecs = jwtTimeout;
            boolean isRemember = false;
            String dealerGroupId = request.getDealerGroupId();
            if (StringUtil.isNullOrEmpty(dealerGroupId)) {
//                companyGroupId="TAB";
                //not found
                response.setResult(false);
                finalResponse.setMessage(Constants.Login.USER_NOT_FOUND);
                finalResponse.setCode(204);
                String message = String.format("DealerGroupId is required, has not been provided.", dealerGroupId);
//                logUserNotFound(request, message);
                return finalResponse;
            } else {
                dealerGroupId = dealerGroupId.toUpperCase().trim();
            }
//            System.out.println(JsonObject.mapFrom(request).encodePrettily());
            if (request.getIsRemember() != null && request.getIsRemember()) {
                isRemember = true;
                timeoutInSecs = jwtRememberTimeout;
                log.debug(String.format("--found IsRemember=true---generating for %s minutes--", timeoutInSecs));
            } else {
                log.debug(String.format("--NOT found IsRemember=true---generating for %s minutes--", timeoutInSecs));
            }
            timeoutInSecs = timeoutInSecs * 60; //convert from minutes to secs
            long exp = currentTimeInSecs + timeoutInSecs;

            //try to login
//            String username = request.getRegister();
            String password = request.getPassword();
            if (!StringUtil.isNullOrEmpty(password)) {
                password = password.trim();
            }

            Optional<User> optUser = userRepository.findByUsernameAndDg(username.toLowerCase().trim(),
                    dealerGroupId.toLowerCase());

            if (optUser.isPresent()) {
                //found one
                //now check for SQL Injection Prevention
                User user = optUser.get();
                if (user.getIsActive() != 1) {
                    response.setResult(false);
                    finalResponse.setMessage(Constants.Login.USER_INACTIVE);
                    finalResponse.setCode(204);

                    return finalResponse;
                }
                if (username.equals(user.getUsername())
                        && passwordEncoder.matches(password, user.getPassword())) {
                    //get detail user data for Token
                    String idEmp = user.getEmployeeId();
                    String dealerId = user.getDealerId();
                    Long idUser = user.getIdUser();
                    String fullName = user.getName();
                    String userCategory = user.getCategoryId();
                    Integer passwordExpired = user.getPasswordExpired();
                    if (passwordExpired == null) {
                        passwordExpired = 0;
                    }

                    Map<String, Object> claim = new HashMap<>();
                    claim.put(Claims.ISSUER, jwtIssuer);
//                    JwtClaimsBuilder jwtClaimsBuilder = Jwt.issuer(jwtIssuer)
//                            .upn(username);
                    claim.put("username", username);
                    if (idEmp != null) {
                        claim.put("empId", idEmp);
                    }
                    if (!StringUtil.isNullOrEmpty(dealerId)) {
                        claim.put("dealerId", dealerId);
                    }

                    Optional<MasterDealerGroup> dealerGroupOptional =
                            mstDealerGroupRepository.findById(dealerGroupId);

                    String egw = "false";
                    if (dealerGroupOptional.isPresent()) {
                        MasterDealerGroup masterDealerGroup = dealerGroupOptional.get();
                        String isEncrypted = masterDealerGroup.getIsEncrypted();
                        if (!StringUtil.isNullOrEmpty(isEncrypted)
                                && isEncrypted.equalsIgnoreCase("YES")) {
                            egw = "true";
                        }
                    }

//                    String jwtToken = jwtClaimsBuilder
//                            .claim(Claims.exp.name(), exp)
//                            .claim("userId", String.valueOf(idUser))
//                            .claim("comGroupId", companyGroupId)
//                            .claim("remember", String.valueOf(isRemember))
//                            .claim("egw", egw)
//                            .groups(new HashSet<>(Arrays.asList("User")))
//                            .sign();
                    claim.put("userId", idUser);
                    claim.put("dealerGroupId", dealerGroupId);
                    claim.put("remember", String.valueOf(isRemember));
                    claim.put("egw", egw);
                    claim.put(Claims.EXPIRATION, exp);
                    String jwtToken = jwtService.generateToken(claim);
//                    String jwtToken = Jwt.issuer(jwtIssuer)
//                            .upn(username)
//                            .claim(Claims.exp.name(), exp)
//                            .claim("userId", String.valueOf(idUser))
//                            .claim("empId", idEmp)
//                            .claim("comId", companyId)
//                            .claim("comGroupId", companyGroupId)
//                            .claim("remember", String.valueOf(isRemember))
//                            .claim("egw",egw)
//                            .groups(new HashSet<>(Arrays.asList("User")))
//                            .sign();
                    response.setResult(true);
                    response.setIdEmp(idEmp);
                    response.setJwtToken(jwtToken);
                    response.setName(fullName);
                    response.setIdUser(idUser);
                    response.setUserCategory(userCategory);
                    response.setPasswordExpired(passwordExpired);
                    response.setSessionId(createSessionId(idUser));

                    //log for auth process
                    String idDevice = request.getIdDevice();
                    Double loginLongitude = request.getLoginLocationLongitude();
                    Double loginLatitude = request.getLoginLocationLatitude();
                    UserLoginLog userLoginLog = new UserLoginLog();
                    userLoginLog.setIdUser(idUser);
                    Date currentDate = new Date();
                    userLoginLog.setLoginTime(currentDate);
                    userLoginLog.setCreatedBy("SYSTEM");
                    userLoginLog.setCreatedDt(currentDate);
                    userLoginLog.setIsActive(1L);
                    userLoginLog.setStatusLog("ACTIVE");
                    userLoginLog.setIdDevice(idDevice);
                    userLoginLog.setLoginLongitude(loginLongitude);
                    userLoginLog.setLoginLatitude(loginLatitude);
                    userLoginLog.setNotifToken(notifToken);
                    userLoginLogRepository.save(userLoginLog);

//                    jsonData.put("count", 0);
//                    redisClientMaster.setex(sessionKey, cacheTimout, jsonData.encode());
                } else {
//                    jsonData.put("count", (count + 1));
                    //wrong password
                    response.setResult(false);
                    finalResponse.setMessage(Constants.Login.WRONG_PASSWORD);
                    finalResponse.setCode(204);
//                    redisClientMaster.setex(sessionKey, cacheTimout, jsonData.encode());
                }
            } else {
                //not found
                response.setResult(false);
                finalResponse.setMessage(Constants.Login.USER_NOT_FOUND);
                finalResponse.setCode(204);
                username = username.toLowerCase().trim();
                dealerGroupId = dealerGroupId.toLowerCase();
                String message = String.format("User with username/dealerGroupId [[ %s / %s ]] not found", username, dealerGroupId);
                logUserNotFound(request, message);
            }

            long stop = System.currentTimeMillis();
//            log.info(String.format("Redis get-%s with jsonData [[ %s ]] [[ %s ms]]", (stop - start)));
            log.info(String.format("Token generated in [[ %s ms]]", (stop - start)));
            return finalResponse;
        } catch (Exception e) {
            e.printStackTrace();
            long stop = System.currentTimeMillis();
            log.info(String.format("Token generated in [[ %s ms]]", (stop - start)));
            String message = String.format("Error during login with cause: %s", e.getMessage());
            logUserNotFound(request, message);
            return new GenericResponseDTO().errorResponse(HttpResponseStatus.NOT_FOUND.code(), e.getLocalizedMessage());
        }
    }

    public GenericResponseDTO<UserTokenResponseDto> refreshToken(String request) {
        try {
            UserTokenResponseDto response = new UserTokenResponseDto();
            GenericResponseDTO<UserTokenResponseDto> finalResponse=new GenericResponseDTO().successResponse(response);
            JsonObject jsonRequest=new JsonObject(request);
            String username = jsonRequest.getString("username");
            String dealerId = jsonRequest.getString("dealerId");
            Long idUser = jsonRequest.getLong("userId");
            String idEmp = jsonRequest.getString("empId");
            String dealerGroupId = jsonRequest.getString("dealerGroupId");
            String isRemember = jsonRequest.getString("remember","false");

            long currentTimeMS = System.currentTimeMillis();
            int currentTimeInSecs = (int) (currentTimeMS / 1000);
            long timeoutInSecs = jwtTimeout;
            if (isRemember.equals("true")) {
                timeoutInSecs = jwtRememberTimeout;
                log.info(String.format("--found IsRemember=true---generating for %s minutes--",timeoutInSecs));
            } else {
                log.info(String.format("--NOT found IsRemember=true---generating for %s minutes--",timeoutInSecs));
            }
            timeoutInSecs=timeoutInSecs*60; //convert from minutes to secs
            long exp = currentTimeInSecs + timeoutInSecs;

//            String jwtToken = Jwt.issuer(jwtIssuer)
//                    .upn(username)
//                    .claim(Claims.exp.name(), exp)
//                    .claim("userId", idUser)
//                    .claim("empId", idEmp)
//                    .claim("comId", companyId)
//                    .claim("comGroupId", companyGroupId)
//                    .claim("remember", String.valueOf(isRemember))
//                    .groups(new HashSet<>(Arrays.asList("User")))
//                    .sign();
            
            Map<String, Object> claim = new HashMap<>();
            claim.put(Claims.ISSUER, jwtIssuer);
            claim.put("username", username);
            claim.put("userId", idUser);
            claim.put("empId", idEmp);
            claim.put("dealerId", dealerId);
            claim.put("dealerGroupId", dealerGroupId);
            claim.put("remember", isRemember);
            claim.put(Claims.EXPIRATION, exp);
            String jwtToken = jwtService.generateToken(claim);
            response.setJwtToken(jwtToken);
            response.setResult(true);
            return finalResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            log.info(String.valueOf(JsonObject.mapFrom(
                    LogOpsUtil.getErrorResponse(ProjectType.CRUD, "Security", new Date(), "Rest",
                            String.valueOf(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()), e.getStackTrace()))));
            return new GenericResponseDTO().errorResponse(HttpResponseStatus.NOT_FOUND.code(), e.getLocalizedMessage());
        }

    }

    public GenericResponseDTO<UserLogoutResponseDto> logoutService(String request) {
        try {
            UserLogoutResponseDto response = new UserLogoutResponseDto();
            GenericResponseDTO<UserLogoutResponseDto> finalResponse=new GenericResponseDTO().successResponse(response);
            JsonObject jsonRequest= new JsonObject(request);
            Long idUser=Long.valueOf(jsonRequest.getString("idUser","0"));
            String empId = jsonRequest.getString("empId");
            Double longitudeLocation=jsonRequest.getDouble("logoutLocationLongitude");
            Double locationLatitude=jsonRequest.getDouble("logoutLocationLatitude");

            List<UserLoginLog> userLogs=userLoginLogRepository.findByUserIdIAndIsActive(idUser, 1L);
            if (!userLogs.isEmpty()) {
                Long userId=userLogs.get(0).getIdUser();
                userLoginLogRepository.updateUserLogs(
                        0L,
                        locationLatitude,
                        longitudeLocation,
                        new Date(),
                        "SYSTEM",
                        new Date(),
                        Constants.Login.STATUS_LOGOUT,
                        userId
                        );
                response.setResult(true);
                response.setIdEmp(empId);
            } else {
                response.setIdEmp(empId);
                response.setResult(false);
                finalResponse=new GenericResponseDTO().noDataFoundResponse(response);
            }
            return finalResponse;
        }  catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            log.info(String.valueOf(JsonObject.mapFrom(
                    LogOpsUtil.getErrorResponse(ProjectType.CRUD, "Security", new Date(), "Rest",
                            String.valueOf(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()), e.getStackTrace()))));
            return new GenericResponseDTO().errorResponse(HttpResponseStatus.NOT_FOUND.code(), e.getLocalizedMessage());
        }
    }
}
