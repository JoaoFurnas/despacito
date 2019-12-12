package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.Dto.LoginDto;
import org.academiadecodigo.thunderstructs.Dto.RegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class AccessController {

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<?> checkLogin(@Valid @RequestBody LoginDto loginDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(loginDto,HttpStatus.BAD_REQUEST);
        }

        LoginDto user = new LoginDto();
        user.setEmail("deciomachado90@gmail.com");
        user.setPassword("1234");

        if(loginDto.getEmail().equals(user.getEmail()) || loginDto.getPassword().equals(user.getPassword())){
            return new ResponseEntity<>(loginDto,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }




        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}
