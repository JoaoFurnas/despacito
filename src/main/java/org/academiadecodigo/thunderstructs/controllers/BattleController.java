package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.models.Battle;
import org.academiadecodigo.thunderstructs.services.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/battle")
public class BattleController {

    private BattleService battleService;

    @Autowired
    public void setAccessService(BattleService battleService) {
        this.battleService = battleService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Battle> getBattle(@PathVariable int id){

        Battle battle = battleService.getBattleById(id);

        if(battle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(battle, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{user}/active")
    public ResponseEntity<List<Battle>> getActiveBattlesByUser(@PathVariable String user){

        List<Battle> battle = battleService.getActiveBattlesByUsername(user);

        if(battle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(battle, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/local/{local}")
    public ResponseEntity<List<Battle>> getUsersActiveBattles(@PathVariable int local){

        List<Battle> battle = battleService.getActiveBattlesByLocal(local);

        if(battle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(battle, HttpStatus.OK);
    }

}
