package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.DataSource;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getDancersList(int local){

        List<User> list = new ArrayList<>();

        for(User b : dataSource.getAllUsersList()){
            if(b.isDancer() && b.getLocation() == local){
                list.add(b);
            }

        }
        return list;
    }
}
