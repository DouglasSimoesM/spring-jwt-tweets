package tech.simoes.springsecurity.controller.dto;

public record LoginResponse (String accessToken, Long expiresIn){
}
