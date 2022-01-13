package com.vin.bankServiceSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class BankController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/secured")
    public ResponseEntity<String> securedResource(){
        return ResponseEntity.ok("hello,Iam very secured");
    }

    @GetMapping("/unsecured")
    public ResponseEntity<String> unsecuredResource() {
        return ResponseEntity.ok("hello, I am open to chat");
    }
}
