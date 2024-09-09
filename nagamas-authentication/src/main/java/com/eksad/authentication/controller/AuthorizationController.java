package com.eksad.authentication.controller;

import com.eksad.authentication.service.*;
import com.eksad.authentication.dto.*;
import com.eksad.authentication.service.AuthorizationService;
import com.eksad.authentication.dto.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationController {

    private final JwtService jwtService;
    private final AuthorizationService authorizationService;

    public AuthorizationController(JwtService jwtService, AuthorizationService authorizationService) {
        this.jwtService = jwtService;
        this.authorizationService = authorizationService;
    }

    @PostMapping("/getAccessFormItem")
    public ResponseEntity getAccessFormItem(@RequestHeader(value="Authorization") String authorization, @RequestBody RequestFormItemDto request) throws Exception {
        String token = authorization.split(" ")[1];
        Long userId = jwtService.extractClaim(token, claims -> claims.get("userId", Long.class));

        GenericResponseDTO<ListFormItem> response = authorizationService.getAccessFormItem(String.valueOf(userId), request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getMasterRoleAccess")
    public ResponseEntity getMasterRoleAccess(){
        GenericResponseDTO<List<String[]>> response = authorizationService.getMenuAcceesRole();
        return ResponseEntity.ok(response);
    }
}
