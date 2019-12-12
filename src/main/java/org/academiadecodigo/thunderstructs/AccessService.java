package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.thunderstructs.Dto.LoginDto;
import org.academiadecodigo.thunderstructs.Dto.RegisterDto;
import org.academiadecodigo.thunderstructs.models.Battle;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User getActiveUser(int id){
        for (User u : dataSource.getActiveUsers()) {
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    private void addActiveUser(User user){
        dataSource.getActiveUsers().add(user);
    }

    public User getUser(int id){

        for (User u : dataSource.getAllUsersList()) {
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    public boolean registerUser(RegisterDto user){
        for(User u : dataSource.getAllUsersList()){
            if(u.getUsername().equals(user.getUsername())){
                return false;
            }
            if(u.getEmail().equals(user.getEmail())){
                return false;
            }
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setLocation(user.getLocation());

        dataSource.getAllUsersList().add(newUser);
        return true;
    }

    public Battle getBattle(int id){
        for (Battle b : dataSource.getBattlesList()) {
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public void addBattle(Battle battle){
        dataSource.getBattlesList().add(battle);
    }

    public boolean authenticate(LoginDto login){
        for(User user : dataSource.getAllUsersList()){
            if(user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword())){
                addActiveUser(user);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        AccessService accessService = new AccessService();


        System.out.println(accessService.dataSource.getAllUsersList().size());
    }

}
