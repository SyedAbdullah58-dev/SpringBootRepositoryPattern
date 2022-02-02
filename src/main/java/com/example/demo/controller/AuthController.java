/*
package com.example.demo.controller;

import com.example.demo.jwt.UserAuthFilter;
import com.example.demo.jwt.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
private AuthenticationManager authenticationManager;
public ResponseEntity<?> createAuthToken(@RequestBody UserAuthFilter userAuthFilter)
throws Exception
{
    try {
authenticationManager.authenticate()

    }
    catch (BadCredentialsException badCredentialsException){

    }
    return null;
}


}
*/
