package tech.simoes.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.simoes.springsecurity.controller.dto.LoginRequest;
import tech.simoes.springsecurity.controller.dto.LoginResponse;
import tech.simoes.springsecurity.service.TokenService;

@RestController
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var response = tokenService.authenticateAndGenerateToken(loginRequest);
        return ResponseEntity.ok(response);
    }
}
