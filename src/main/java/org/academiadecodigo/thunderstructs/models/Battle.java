package org.academiadecodigo.thunderstructs.models;

import java.util.List;

public class Battle {

    private static int id= 0;
    private int userId;
    private User user1;
    private User user2;
    private String hour;
    private String date;
    private int user1Votes;
    private int user2Votes;
    private String address;
    private int location;
    private List<User> bettors;
    private int numBettors;
    private List<User> viewers;
    private int numViewers;
    private boolean active;

    public Battle(){
        id++;
        this.userId = id;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return userId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser1Votes() {
        return user1Votes;
    }

    public void setUser1Votes(int user1Votes) {
        this.user1Votes = user1Votes;
    }

    public int getUser2Votes() {
        return user2Votes;
    }

    public void setUser2Votes(int user2Votes) {
        this.user2Votes = user2Votes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public List<User> getBettors() {
        return bettors;
    }

    public void setBettors(List<User> bettors) {
        this.bettors = bettors;
    }

    public void addBettors(User user){
        this.bettors.add(user);
        this.numBettors++;
    }
    public List<User> getViewers() {
        return viewers;
    }

    public void setViewers(List<User> viewers) {
        this.viewers = viewers;
    }

    public void addViewer(User user){
        this.viewers.add(user);
        this.numViewers++;
    }

    public int getNumBettors() {
        return numBettors;
    }

    public int getNumViewers() {
        return numViewers;
    }
}
