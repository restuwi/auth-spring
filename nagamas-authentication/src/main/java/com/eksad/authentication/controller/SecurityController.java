package com.eksad.authentication.controller;

import com.eksad.authentication.dto.*;
import com.eksad.authentication.service.AuthenticationService;
import com.eksad.authentication.service.JwtService;
import com.eksad.authentication.dto.GenericResponseDTO;
import com.eksad.authentication.common.StringUtil;
import com.eksad.authentication.service.UserDetailsServiceImp;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/security")
public class SecurityController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final UserDetailsServiceImp userDetailsServiceImp;

    public SecurityController(AuthenticationService authenticationService, JwtService jwtService, UserDetailsServiceImp userDetailsServiceImp) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.userDetailsServiceImp = userDetailsServiceImp;
    }

    @GetMapping("/loginInfo")
    public ResponseEntity loginInfo(@RequestHeader(value="Authorization") String authorization) throws Exception {
        String token = authorization.split(" ")[1];
        LoginInfoResponseDto response=new LoginInfoResponseDto();
        String username = jwtService.extractUsername(token);
        String dealerId = jwtService.extractClaim(token, claims -> claims.get("dealerId", String.class));
        String dealerGroupId = jwtService.extractClaim(token, claims -> claims.get("dealerGroupId", String.class));
        String empId = jwtService.extractClaim(token, claims -> claims.get("empId", String.class));
        Long userId = jwtService.extractClaim(token, claims -> claims.get("userId", Long.class ));
        String isRemember = jwtService.extractClaim(token, claims -> claims.get("remember", String.class));
        response.setUsername(username);
        response.setDealerId(dealerId);
        response.setDealerGroupId(dealerGroupId);
        response.setEmpId(empId);
        response.setUserId(userId);
        if (StringUtil.isNullOrEmpty(isRemember)) {
            response.setIsRemember(false);
        } else {
            response.setIsRemember((isRemember == "true"));
        }
        GenericResponseDTO<LoginInfoResponseDto>
                genericResponse = new GenericResponseDTO().successResponse(response);
        return ResponseEntity.ok(genericResponse);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> test(){
        System.out.println("test admin");
        return ResponseEntity.ok("this is admin");
    }

    @GetMapping("/refreshToken")
    public ResponseEntity doRefreshToken(@RequestHeader(value="Authorization") String authorization) throws Exception {
        String token = authorization.split(" ")[1];
        JsonObject jsonRequest=new JsonObject();
        jsonRequest.put("username", jwtService.extractClaim(token, claims -> claims.get("username", String.class)));
        jsonRequest.put("dealerId", jwtService.extractClaim(token, claims -> claims.get("dealerId", String.class)));
        jsonRequest.put("dealerGroupId", jwtService.extractClaim(token, claims -> claims.get("dealerGroupId", String.class)));
        jsonRequest.put("empId", jwtService.extractClaim(token, claims -> claims.get("empId", String.class)));
        jsonRequest.put("userId", jwtService.extractClaim(token, claims -> claims.get("userId", Long.class)));
        jsonRequest.put("remember", jwtService.extractClaim(token, claims -> claims.get("remember", String.class)));
        GenericResponseDTO<UserTokenResponseDto>
                response = authenticationService.refreshToken(jsonRequest.encode());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity doLogout(@RequestHeader(value="Authorization") String authorization, @RequestBody UserLogoutRequestDto request) throws Exception {
        String token = authorization.split(" ")[1];
        JsonObject jsonRequest=JsonObject.mapFrom(request);
        jsonRequest.put("idUser", jwtService.extractClaim(token, claims -> claims.get("userId", Long.class)));
        jsonRequest.put("empId", jwtService.extractClaim(token, claims -> claims.get("empId", String.class)));
        GenericResponseDTO<UserLogoutResponseDto>
                response = authenticationService.logoutService(jsonRequest.encode());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validate-token")
    public ResponseEntity<Void> validateToken(@RequestHeader("Authorization") String token) {
        try {
            if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            String username = jwtService.extractUsername(token);
            UserDetails userDetail = userDetailsServiceImp.loadUserByUsername(username);

            boolean isValid = jwtService.isValid(token, userDetail);
            return isValid ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
