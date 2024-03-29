package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.Dto.SessionDto;
import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.AccessService;
import org.academiadecodigo.thunderstructs.Dto.LoginDto;
import org.academiadecodigo.thunderstructs.Dto.RegisterDto;
import org.academiadecodigo.thunderstructs.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/access")
public class AccessController {

    private AccessService accessService;
    private HttpSession session;

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<SessionDto> checkLogin(HttpServletResponse response, @Valid @RequestBody LoginDto loginDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(accessService.authenticate(loginDto)){

//            Cookie cookie = new Cookie("email",loginDto.getEmail());
//            response.addCookie(cookie);
            SessionDto sessionDto = new SessionDto();
            sessionDto.setId(accessService.getUser(loginDto.getEmail()));

            return new ResponseEntity<>(sessionDto,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(accessService.registerUser(registerDto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register/locations")
    public ResponseEntity<List<String>> getLocations(){

        List<String> locations = new ArrayList<>();

        for(Location loc: Location.values()){
            locations.add(loc.getLocation());
        }
        return new ResponseEntity<>(locations,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search")
    public ResponseEntity<List<String>> searchByLocation(){

        List<String> locations = new ArrayList<>();


        return new ResponseEntity<>(locations,HttpStatus.OK);
    }


   @RequestMapping(method = RequestMethod.GET, path = "/user")
    public ResponseEntity<RegisterDto> getRegisterDto(){

        RegisterDto registerDto = new RegisterDto();
        registerDto.setName("test");
        registerDto.setUsername("asd");
        registerDto.setEmail("asd");
        registerDto.setPassword("asd");
        registerDto.setLocation(1);

        return new ResponseEntity<>(registerDto,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public ResponseEntity<User> getRegisterDtoasd(@PathVariable int id){


        return new ResponseEntity<>(accessService.getUser(id),HttpStatus.OK);
    }

    @Autowired
    public void setAccessService(AccessService accessService) {
        this.accessService = accessService;
    }
}
