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
        user3.setUsername("hugo");
        user3.setName("Hugo Almeida");
        user3.setLocation(0);
        user3.setPassword("hugo123");
        user3.setWallet(2000.00);
        user3.setEmail("hugoantonio@gmail.com");
        user3.setDescription("Aquele totó dos jogos");
        user3.setDancer(true);
        usersList.add(user3);

        User user4 = new User();
        user4.setUsername("decio");
        user4.setName("Décio Flaviano");
        user4.setLocation(0);
        user4.setPassword("decioF");
        user4.setWallet(5000.00);
        user4.setEmail("decidoflaviano@gmail.com");
        user4.setDescription("You can call me Elon Musk");
        user4.setDancer(true);
        usersList.add(user4);



        Battle battle = new Battle();
        battle.setUser1(user);
        battle.setUser2(user2);
        battle.setAddress("Café da Graça");
        battle.setLocation(0);
        battle.setDate("13/12/2019");
        battle.setHour("10:00");
        battlesList.add(battle);


        Battle battle1 = new Battle();
        battle1.setUser1(user3);
        battle1.setUser2(user4);
        battle1.setAddress("Academia de Código");
        battle1.setLocation(0);
        battle1.setDate("12/12/2019");
        battle1.setHour("22:00");
        battlesList.add(battle1);

    }

    public void addActiveUser(User user){
        activeUsers.add(user);
    }

}


