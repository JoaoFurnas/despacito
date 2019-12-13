package org.academiadecodigo.thunderstructs.services;


import org.academiadecodigo.thunderstructs.DataSource;
import org.academiadecodigo.thunderstructs.models.Battle;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleService {

    private DataSource dataSource;
    private AccessService accessService;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Battle getBattleById(int id) {

        for (Battle b : dataSource.getBattlesList()) {

            if (b.getId() == id) {
                return b;
            }

        }

        return null;
    }

    public List<Battle> getActiveBattlesByUsername(String username) {

        List<Battle> list = new ArrayList<>();

        for (Battle b : dataSource.getBattlesList()) {
            if (b.isActive() && (b.getUser1().getUsername().equals(username) || b.getUser2().getUsername().equals(username))) {
                list.add(b);
            }

        }
        return list;
    }

    public List<Battle> getActiveBattlesByLocal(int local) {

        List<Battle> list = new ArrayList<>();

        for (Battle b : dataSource.getBattlesList()) {
            if (b.isActive() && b.getLocation() == local) {
                list.add(b);
            }

        }
        return list;
    }

    //add viewer to battle
    public void addViewer(int uid, int id) {

        User user = dataSource.getAllUsersList().get(uid);

        if(user.getWallet()<0){
            user.setWallet(0);
            return;
        }

        for (Battle b : dataSource.getBattlesList()) {
            if (b.isActive() && b.getId() == id) {
                b.addViewer(user);
            }

        }
    }

    //add viewer to battle
    public void addBettor(int uid, int bid) {

        User user = dataSource.getAllUsersList().get(uid);

        if(user.getWallet()<0){
            user.setWallet(0);
            return;
        }
        user.setWallet(user.getWallet()-10);

        for (Battle b : dataSource.getBattlesList()) {
            if (b.isActive() && b.getId() == bid) {
                b.addBettors(user);
            }

        }
    }

    public List<Battle> getMyBets(int id) {

        List<Battle> list = new ArrayList<>();

        User user = accessService.getUser(id);

        for (int i=0;i<dataSource.getBattlesList().size();i++) {
            if (dataSource.getBattlesList().get(i).isActive()) {
               if(dataSource.getBattlesList().get(i).getViewers().contains(user)) {
                    list.add(dataSource.getBattlesList().get(i));
                }
                if(dataSource.getBattlesList().get(i).getBettors().contains(user)) {
                    list.add(dataSource.getBattlesList().get(i));
                }
            }
        }

        return list;
    }

    @Autowired
    public void setAccessService(AccessService accessService) {
        this.accessService = accessService;
    }
}
