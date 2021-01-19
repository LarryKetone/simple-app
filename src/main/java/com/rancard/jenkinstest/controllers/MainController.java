package com.rancard.jenkinstest.controllers;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {



    @GetMapping("/greeting")

    public String greet(@AuthenticationPrincipal OidcUser user){

        return "Hello " + user.getEmail();

    }

}
