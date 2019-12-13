package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.thunderstructs.models.Battle;
import org.academiadecodigo.thunderstructs.models.Location;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSource {

    private List<User> usersList;
    private List<Battle> battlesList;
    private List<User> activeUsers;

    public DataSource(){
        usersList = new ArrayList<>();
        battlesList = new ArrayList<>();
        activeUsers = new ArrayList<>();
        populate();

    }


    public List<User> getAllUsersList() {
        return usersList;
    }

    public List<Battle> getBattlesList() {
        return battlesList;
    }

    public List<User> getActiveUsers() {
        return activeUsers;
    }

    private void populate(){
        User user = new User();
        user.setUsername("bits");
        user.setName("Bitinha Pires");
        user.setLocation(0);
        user.setPassword("bitinha123");
        user.setWallet(2000.00);
        user.setDescription("Aquela miuda gira de Tavira");
        user.setEmail("bits@gmail.com");
        user.setDancer(true);
        usersList.add(user);

        User user2 = new User();
        user2.setUsername("furnas");
        user2.setName("João Furnas");
        user2.setLocation(0);
        user2.setPassword("furnas123");
        user2.setWallet(2000.00);
        user2.setEmail("joaofurnas@gmail.com");
        user2.setDescription("Aquele gajo grande de São Miguel");
        user2.setDancer(true);
        usersList.add(user2);

        Battle battle = new Battle();
        battle.setUser1(user);
        battle.setUser2(user2);
        battle.setAddress("");
        battle.setLocation(0);
        battlesList.add(battle);

    }

    public void addActiveUser(User user){
        activeUsers.add(user);
    }

}


