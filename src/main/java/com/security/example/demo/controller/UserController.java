/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.example.demo.controller;

import java.util.Map;
import java.util.HashMap;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ignis
 */
@RestController
public class UserController {
   
   @GetMapping("user")
   public Map<String, Object> user(OAuth2Authentication user){
       
       Map<String, Object> userInfo = new HashMap<>();
       userInfo.put("user", user.getUserAuthentication().getPrincipal());
       userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
       return userInfo;
   }
    
}
