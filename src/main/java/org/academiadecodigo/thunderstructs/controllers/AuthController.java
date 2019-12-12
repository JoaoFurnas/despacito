package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.Dto.LoginDto;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AuthController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<LoginDto> checkLogin(){

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("deciomachado90@gmail.com");
        loginDto.setPassword("1234");

        return new ResponseEntity<>(loginDto,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<LoginDto> checkLogin(@RequestBody LoginDto loginDto){

        User user = new User();
        user.setEmail("deciomachado90@gmail.com");
        user.setPassword("1234");

        if(loginDto.getEmail() == user.getEmail() && loginDto.getPassword() == user.getPassword()){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
