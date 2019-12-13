package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.Battle;
import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/dashboard")
public class DashboardController {

    private AccessService accessService;

    @RequestMapping(method = RequestMethod.POST, path = "/{uid}/challange/{aid}")
    public ResponseEntity<?> addViewer(@RequestBody Battle battle, @PathVariable int uid, @PathVariable int aid){

        User user1 = accessService.getUser(uid);
        User user2 = accessService.getUser(aid);

        battle.setUser1(user1);
        battle.setUser2(user2);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Autowired
    public void setAccessService(AccessService accessService) {
        this.accessService = accessService;
    }
}
