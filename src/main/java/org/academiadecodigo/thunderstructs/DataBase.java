package org.academiadecodigo.thunderstructs;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List usersList;
    private List battlesList;
    private List activeUsers;

    public DataBase(){
        usersList = new ArrayList();
        battlesList = new ArrayList();
        activeUsers = new ArrayList();

    }


    public List getAllUsersList() {
        return usersList;
    }

    public List getBattlesList() {
        return battlesList;
    }

    public List getActiveUsers() {
        return activeUsers;
    }
}
