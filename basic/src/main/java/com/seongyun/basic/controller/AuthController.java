package com.seongyun.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongyun.basic.service.Basicservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final Basicservice basicservice;

    @GetMapping("/{principle}")
    public String getJwt(
        @PathVariable("principle") String principle
    ) {
        return basicservice.getJwt(principle);
    }

    @PostMapping("/validation")
    public String jwtValidate(
        @RequestBody String jwt
    ) {
        return basicservice.jwtValidate(jwt);
    }
}
