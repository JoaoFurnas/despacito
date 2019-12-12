package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.AccessService;
import org.academiadecodigo.thunderstructs.Dto.LoginDto;
import org.academiadecodigo.thunderstructs.Dto.RegisterDto;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class AccessController {

    private AccessService accessService;

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<?> checkLogin(@Valid @RequestBody LoginDto loginDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(loginDto,HttpStatus.BAD_REQUEST);
        }

        User user = accessService.getUser(1);

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

    @Autowired
    public void setAccessService(AccessService accessService) {
        this.accessService = accessService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<User> getUsers(@PathVariable int id){


        return new ResponseEntity<>(accessService.getUser(id),HttpStatus.OK);
    }
}
