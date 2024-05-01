package com.example.ChocolateShopV2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class demoController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello1(){
        return ResponseEntity.ok("Hello");
    }
    @GetMapping("/management/hello")
    public ResponseEntity<String> hello2(){
        return ResponseEntity.ok("Hello");
    }
    @GetMapping("/admin/hello")
    public ResponseEntity<String> hello3(){
        return ResponseEntity.ok("Hello");
    }
}
