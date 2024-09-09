package com.eksad.authentication.controller;

import com.eksad.authentication.dto.*;
import com.eksad.authentication.repository.*;
import com.eksad.authentication.service.*;
import com.eksad.authentication.domain.*;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final AuthorizationService authorizationService;
    private final ViewUserAuthorizationRepository viewUserAuthorizationRepository;
    private final ViewDealerUnitCategoryRepository viewDealerUnitCategoryRepository;

    public AuthenticationController(UserRepository userRepository, AuthenticationService authenticationService, AuthorizationService authorizationService, ViewUserAuthorizationRepository viewUserAuthorizationRepository, ViewDealerUnitCategoryRepository viewDealerUnitCategoryRepository) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
        this.authorizationService = authorizationService;
        this.viewUserAuthorizationRepository = viewUserAuthorizationRepository;
        this.viewDealerUnitCategoryRepository = viewDealerUnitCategoryRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<GenericResponseDTO<UserLoginResponseDto>> register (
            @RequestBody RegisterRequestDto request) throws Exception {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    ResponseEntity<GenericResponseDTO<UserLoginResponseDto>> login (
            @RequestBody UserLoginRequestDto request){
        return ResponseEntity.ok(authenticationService.generateToken(request));
    }


    @PostMapping("/loginFull")
    public ResponseEntity doLoginFull(@RequestBody UserLoginRequestDto request){
        logger.info("Request Login Full : " + JsonObject.mapFrom(request).encodePrettily());
        GenericResponseDTO<UserLoginFullResponseDto> finalResponse;
        GenericResponseDTO<UserLoginResponseDto>
                response = authenticationService.generateToken(request);
//        System.out.println(String.format("------auth---%s---------%s---------%s"
//                ,JsonObject.mapFrom(response).encodePrettily()
//                ,response.getStatus().name().equals("S")
//                ,response.getCode()==201
//                ));
        if (response.getStatus().name().equals("S") && response.getCode() == 201) {
//            System.out.println("------collecting access menu----");
            Long userIdLong = response.getData().getIdUser();
            String name = response.getData().getName();
            GenericResponseDTO<List<MenuAccessResponseDto>>
                    responseMenuAccess = authorizationService.getMenuAccessService(userIdLong, name);
            JsonObject jsonAuth = JsonObject.mapFrom(response.getData());
            UserLoginFullResponseDto tempResponse = jsonAuth.mapTo(UserLoginFullResponseDto.class);
            tempResponse.setListMenu(responseMenuAccess.getData());
//            System.out.println(JsonObject.mapFrom(tempResponse).encodePrettily());
            finalResponse = new GenericResponseDTO().successResponse(tempResponse);
        } else {
            JsonObject jsonAuth = JsonObject.mapFrom(response.getData());
            UserLoginFullResponseDto tempResponse = jsonAuth.mapTo(UserLoginFullResponseDto.class);
            finalResponse = new GenericResponseDTO().successResponse(tempResponse);
            finalResponse.setStatus(response.getStatus());
            finalResponse.setCode(response.getCode());
            finalResponse.setMessage(response.getMessage());
            finalResponse.setData(tempResponse);
        }
        return ResponseEntity.ok(finalResponse);
    }

    @PostMapping("/v2/loginFull")
    public ResponseEntity<GenericResponseDTO<UserLoginFullResponseDto>> doLoginFullV2(@RequestBody UserLoginRequestDto request){
        logger.info("Request Login Full : " + JsonObject.mapFrom(request).encodePrettily());
        GenericResponseDTO<UserLoginFullResponseDto> finalResponse;
        GenericResponseDTO<UserLoginResponseDto> response = authenticationService.generateToken(request);

        if (response.getStatus().name().equals("S") && response.getCode() == 201) {
            Long userIdLong = response.getData().getIdUser();
            GenericResponseDTO<List<MenuAccessResponseDto>> responseMenuAccess = authorizationService.getMenuAccessServiceV2(userIdLong);

            // Mapping response data to UserLoginFullResponseDto
            UserLoginFullResponseDto tempResponse = new UserLoginFullResponseDto();
            BeanUtils.copyProperties(response.getData(), tempResponse);
            tempResponse.setListMenu(responseMenuAccess.getData());

            finalResponse = new GenericResponseDTO<UserLoginFullResponseDto>().successResponse(tempResponse);
        } else {
            UserLoginFullResponseDto tempResponse = new UserLoginFullResponseDto();
            BeanUtils.copyProperties(response.getData(), tempResponse);

            finalResponse = new GenericResponseDTO<UserLoginFullResponseDto>()
                    .successResponse(tempResponse);
            finalResponse.setStatus(response.getStatus());
            finalResponse.setCode(response.getCode());
            finalResponse.setMessage(response.getMessage());
            finalResponse.setData(tempResponse);
        }
        return ResponseEntity.ok(finalResponse);
    }


    @PostMapping("/loginFullAccess")
    public ResponseEntity doLoginFullAccess(@RequestBody UserLoginFullAccessRequestDTO request){
        long startExec = System.currentTimeMillis();
        GenericResponseDTO<UserLoginFullAccessResponseDTO> finalResponse;
        logger.info("Request Login : " + JsonObject.mapFrom(request).encodePrettily());
        JsonObject jsonReq = JsonObject.mapFrom(request);
        UserLoginRequestDto jsonReqDTO = jsonReq.mapTo(UserLoginRequestDto.class);
        GenericResponseDTO<UserLoginResponseDto>
                response = authenticationService.generateToken(jsonReqDTO);

        if (response.getStatus().name().equals("S") && response.getCode() == 201) {
            JsonObject jsonAuth = JsonObject.mapFrom(response.getData());
            UserLoginFullAccessResponseDTO tempResponse = jsonAuth.mapTo(UserLoginFullAccessResponseDTO.class);
            List<ViewUserAuthorization> dummyAuthorizationsRestu = Arrays.asList(
                    new ViewUserAuthorization("A001", "1", "G001", "ADMIN", "M001", "MAIN - MASTERDATA", true, true, true, true),
                    new ViewUserAuthorization("A002", "1", "G001", "ADMIN", "M004001", "SUB - User Management", true, true, true, true),
                    new ViewUserAuthorization("A003", "1", "G001", "ADMIN", "M005001", "SUB - Bank Management", true, true, true, true),
                    new ViewUserAuthorization("A004", "1", "G001", "ADMIN", "M006001", "SUB - Master Jasa", true, true, true, true),
                    new ViewUserAuthorization("A005", "1", "G001", "ADMIN", "M007001", "SUB - Master Warehouse", true, true, true, true),
                    new ViewUserAuthorization("A006", "1", "G001", "ADMIN", "M008001", "SUB - Master Varian", true, true, true, true),
                    new ViewUserAuthorization("A007", "1", "G001", "ADMIN", "M009001", "SUB - Master Pit", true, true, true, true),
                    new ViewUserAuthorization("A008", "1", "G001", "ADMIN", "M010001", "SUB - Master Voucher", true, true, true, true),
                    new ViewUserAuthorization("A009", "1", "G001", "ADMIN", "M011001", "SUB - Master Supplier", true, true, true, true),
                    new ViewUserAuthorization("A010", "1", "G001", "ADMIN", "M012001", "SUB - Master Unit", true, true, true, true),
                    new ViewUserAuthorization("A011", "1", "G001", "ADMIN", "M013001", "SUB - Master Parameter", true, true, true, true),
                    new ViewUserAuthorization("A058", "1", "G001", "ADMIN", "M058001", "SUB - Master Notification", true, true, true, true),
                    new ViewUserAuthorization("A012", "1", "G001", "ADMIN", "M014001", "SUB - Master Wilayah", true, true, true, true),
                    new ViewUserAuthorization("A013", "1", "G001", "ADMIN", "M015001", "SUB - Master Cabang", true, true, true, true),
                    new ViewUserAuthorization("A014", "1", "G001", "ADMIN", "M016001", "SUB - Master Items", true, true, true, true),
                    new ViewUserAuthorization("A015", "1", "G001", "ADMIN", "M017001", "SUB - Master Parts", true, true, true, true),
                    new ViewUserAuthorization("A016", "1", "G001", "ADMIN", "M018001", "SUB - Master KSU", true, true, true, true),
                    new ViewUserAuthorization("A017", "1", "G001", "ADMIN", "M019001", "SUB - Master Role Access", true, true, true, true),
                    new ViewUserAuthorization("A018", "1", "G001", "ADMIN", "M020001", "SUB - Master Leasing", true, true, true, true),
                    new ViewUserAuthorization("A019", "1", "G001", "ADMIN", "M021001", "SUB - Master Pricelist", true, true, true, true),
                    new ViewUserAuthorization("A020", "1", "G001", "ADMIN", "M022001", "SUB - Master Discount", true, true, true, true),
                    new ViewUserAuthorization("A021", "1", "G001", "ADMIN", "M023001", "SUB - Master Package", true, true, true, true),
                    new ViewUserAuthorization("A022", "1", "G001", "ADMIN", "M024001", "SUB - Master Poin", true, true, true, true),
                    new ViewUserAuthorization("A023", "1", "G001", "ADMIN", "M025001", "SUB - Samsat", true, true, true, true),
                    new ViewUserAuthorization("A024", "1", "G001", "ADMIN", "M026001", "SUB - Promotion", true, true, true, true),
                    new ViewUserAuthorization("A025", "1", "G001", "ADMIN", "M027001", "SUB - Batery EV", true, true, true, true),
                    new ViewUserAuthorization("A026", "1", "G001", "ADMIN", "M002", "MAIN - H1 Module", true, true, true, true),
                    new ViewUserAuthorization("A027", "1", "G001", "ADMIN", "M028002", "SUB - Report", true, true, true, true),
                    new ViewUserAuthorization("A028", "1", "G001", "ADMIN", "M029002", "SUB - Claim C1", true, true, true, true),
                    new ViewUserAuthorization("A029", "1", "G001", "ADMIN", "M030002", "SUB - Receiving Units", true, true, true, true),
                    new ViewUserAuthorization("A030", "1", "G001", "ADMIN", "M031002", "SUB - Delivery", true, true, true, true),
                    new ViewUserAuthorization("A031", "1", "G001", "ADMIN", "M032002", "SUB - Inventory", true, true, true, true),
                    new ViewUserAuthorization("A032", "1", "G001", "ADMIN", "M033002", "SUB - Payment", true, true, true, true),
                    new ViewUserAuthorization("A033", "1", "G001", "ADMIN", "M034002", "SUB - Unit Movement", true, true, true, true),
                    new ViewUserAuthorization("A034", "1", "G001", "ADMIN", "M035002", "SUB - Stock Opname", true, true, true, true),
                    new ViewUserAuthorization("A035", "1", "G001", "ADMIN", "M036002", "SUB - Purchase Order", true, true, true, true),
                    new ViewUserAuthorization("A036", "1", "G001", "ADMIN", "M037002", "SUB - Misc IN OUT", true, true, true, true),
                    new ViewUserAuthorization("A037", "1", "G001", "ADMIN", "M038002", "SUB - Receiving KSU", true, true, true, true),
                    new ViewUserAuthorization("A038", "1", "G001", "ADMIN", "M039002", "SUB - Purchase Return", true, true, true, true),
                    new ViewUserAuthorization("A039", "1", "G001", "ADMIN", "M040002", "SUB - Customer Data", true, true, true, true),
                    new ViewUserAuthorization("A040", "1", "G001", "ADMIN", "M041002", "SUB - FU Prospek", true, true, true, true),
                    new ViewUserAuthorization("A041", "1", "G001", "ADMIN", "M042002", "SUB - Kas", true, true, true, true),
                    new ViewUserAuthorization("A042", "1", "G001", "ADMIN", "M043002", "SUB - FSB", true, true, true, true),
                    new ViewUserAuthorization("A043", "1", "G001", "ADMIN", "M003", "MAIN - H23 Module", true, true, true, true),
                    new ViewUserAuthorization("A044", "1", "G001", "ADMIN", "M044003", "SUB - Claim C3", true, true, true, true),
                    new ViewUserAuthorization("A045", "1", "G001", "ADMIN", "M045003", "SUB - Report H2", true, true, true, true),
                    new ViewUserAuthorization("A046", "1", "G001", "ADMIN", "M046003", "SUB - Work Order", true, true, true, true),
                    new ViewUserAuthorization("A047", "1", "G001", "ADMIN", "M047003", "SUB - Report H3", true, true, true, true),
                    new ViewUserAuthorization("A048", "1", "G001", "ADMIN", "M048003", "SUB - PDI", true, true, true, true),
                    new ViewUserAuthorization("A049", "1", "G001", "ADMIN", "M049003", "SUB - Receiving Parts", true, true, true, true),
                    new ViewUserAuthorization("A050", "1", "G001", "ADMIN", "M050003", "SUB - Receiving Items", true, true, true, true),
                    new ViewUserAuthorization("A051", "1", "G001", "ADMIN", "M051003", "SUB - Misc IN OUT", true, true, true, true),
                    new ViewUserAuthorization("A052", "1", "G001", "ADMIN", "M052003", "SUB - Inventory", true, true, true, true),
                    new ViewUserAuthorization("A053", "1", "G001", "ADMIN", "M053003", "SUB - Parts Movement", true, true, true, true),
                    new ViewUserAuthorization("A054", "1", "G001", "ADMIN", "M054003", "SUB - Stock Opname", true, true, true, true),
                    new ViewUserAuthorization("A055", "1", "G001", "ADMIN", "M055003", "SUB - Procurement", true, true, true, true),
                    new ViewUserAuthorization("A056", "1", "G001", "ADMIN", "M056003", "SUB - Payment", true, true, true, true),
                    new ViewUserAuthorization("A057", "1", "G001", "ADMIN", "M057003", "SUB - FU Prospek", true, true, true, true)
            ); List<ViewUserAuthorization> dummyAuthorizationsDea = Arrays.asList(
                    new ViewUserAuthorization("auth2", "user1", "group2", "Group 2", "menu2", "H1", true, false, false, false)
            );
            List<UserUnitCategoryDTO> dummyCategories = Arrays.asList(
                    new UserUnitCategoryDTO("cat1", "Category 1", "logo1"),
                    new UserUnitCategoryDTO("cat2", "Category 2", "logo2")
            );

            if(tempResponse.getName().equals("Restu")){
                tempResponse.setAuthorizations(dummyAuthorizationsRestu);
            } else {
                tempResponse.setAuthorizations(dummyAuthorizationsDea);
            }
            tempResponse.setUnitCategory(dummyCategories);
            tempResponse.setDealerId("D001");
            tempResponse.setDealerName("Dealer One");

            finalResponse = new GenericResponseDTO().successResponse(tempResponse);
        }else {
            JsonObject jsonAuth = JsonObject.mapFrom(response.getData());
            UserLoginFullAccessResponseDTO tempResponse = jsonAuth.mapTo(UserLoginFullAccessResponseDTO.class);
            finalResponse = new GenericResponseDTO().successResponse(tempResponse);
            finalResponse.setStatus(response.getStatus());
            finalResponse.setCode(response.getCode());
            finalResponse.setMessage(response.getMessage());
            finalResponse.setData(tempResponse);
        }
        long endExec = System.currentTimeMillis();
        System.out.println("Duration Login Full Access "+ (endExec-startExec));
        return ResponseEntity.ok(finalResponse);
    }

    @PostMapping("/v2/loginFullAccess")
    public ResponseEntity doLoginFullAccessv2(@RequestBody UserLoginFullAccessRequestDTO request) {
        long startExec = System.currentTimeMillis();
        GenericResponseDTO<UserLoginFullAccessResponseDTO> finalResponse;
        logger.info("Request Login : " + JsonObject.mapFrom(request).encodePrettily());
        JsonObject jsonReq = JsonObject.mapFrom(request);
        UserLoginRequestDto jsonReqDTO = jsonReq.mapTo(UserLoginRequestDto.class);
        GenericResponseDTO<UserLoginResponseDto> response = authenticationService.generateToken(jsonReqDTO);

        if (response.getStatus().name().equals("S") && response.getCode() == 201) {
            User user = userRepository.findByUserIsActive(request.getRegister(), Long.valueOf(1)).orElseThrow();
            String userID = String.valueOf(user.getIdUser());
            System.out.println("user id: " + userID);
            List<ViewUserAuthorization> listAuthorization = viewUserAuthorizationRepository.findByUserId(userID);
            JsonObject jsonAuth = JsonObject.mapFrom(response.getData());
            jsonAuth.put("dealerId", user.getDealerId());

            List<ViewDealerUnitCategory> unitCategory = viewDealerUnitCategoryRepository.finByDealerId(user.getDealerId());
            List<ViewDealerUnitCategory> listCategory = unitCategory.stream().toList();
            jsonAuth.put("dealerName", unitCategory.get(0).getDealerName());

            UserLoginFullAccessResponseDTO tempResponse = jsonAuth.mapTo(UserLoginFullAccessResponseDTO.class);
            tempResponse.setAuthorizations(listAuthorization);

            List<UserUnitCategoryDTO> listCategoryDTO = new ArrayList<>();
            if (!listCategory.isEmpty()) {
                listCategoryDTO = listCategory.stream()
                        .map(jsonObject -> entityTODto(jsonObject))
                        .collect(Collectors.toList());
            }
            tempResponse.setUnitCategory(listCategoryDTO);

            finalResponse = new GenericResponseDTO<UserLoginFullAccessResponseDTO>().successResponse(tempResponse);
        } else {
            JsonObject jsonAuth = JsonObject.mapFrom(response.getData());
            UserLoginFullAccessResponseDTO tempResponse = jsonAuth.mapTo(UserLoginFullAccessResponseDTO.class);
            finalResponse = new GenericResponseDTO<UserLoginFullAccessResponseDTO>().successResponse(tempResponse);
            finalResponse.setStatus(response.getStatus());
            finalResponse.setCode(response.getCode());
            finalResponse.setMessage(response.getMessage());
            finalResponse.setData(tempResponse);
        }

        long endExec = System.currentTimeMillis();
        System.out.println("Duration Login Full Access " + (endExec - startExec));
        return ResponseEntity.ok(finalResponse);
    }


    private UserUnitCategoryDTO entityTODto(ViewDealerUnitCategory viewDealerUnitCategory){
        UserUnitCategoryDTO userUnitCategoryDTO = new UserUnitCategoryDTO();
        userUnitCategoryDTO.setDealerVehicleCategoryId(viewDealerUnitCategory.getDealerVehicleCategoryId());
        userUnitCategoryDTO.setDealerVehicleCategoryLogo(viewDealerUnitCategory.getDealerVehicleCategoryLogo());
        userUnitCategoryDTO.setDealerVehicleCategoryName(viewDealerUnitCategory.getDealerVehicleCategoryName());
        return userUnitCategoryDTO;
    }


}
