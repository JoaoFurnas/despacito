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

        User user3 = new User();
        user2.setUsername("hugo");
        user2.setName("Hugo Almeida");
        user2.setLocation(0);
        user2.setPassword("hugo123");
        user2.setWallet(2000.00);
        user2.setEmail("hugoantonio@gmail.com");
        user2.setDescription("Aquele totó dos jogos");
        user2.setDancer(true);
        usersList.add(user3);

        User user4 = new User();
        user2.setUsername("decio");
        user2.setName("Décio Flaviano");
        user2.setLocation(0);
        user2.setPassword("decioF");
        user2.setWallet(5000.00);
        user2.setEmail("decidoflaviano@gmail.com");
        user2.setDescription("You can call me Elon Musk");
        user2.setDancer(true);
        usersList.add(user4);



        Battle battle = new Battle();
        battle.setUser1(user);
        battle.setUser2(user2);
        battle.setAddress("");
        battle.setLocation(0);
        battlesList.add(battle);


        Battle battle1 = new Battle();
        battle.setUser1(user3);
        battle.setUser2(user3);
        battle.setAddress("");
        battle.setLocation(1);
        battlesList.add(battle1);

    }

    public void addActiveUser(User user){
        activeUsers.add(user);
    }

}


