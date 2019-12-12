package org.academiadecodigo.thunderstructs.models;

public class User {

    private static int id = 0;
    private int userId;
    private String email;
    private String username;

    private String password;

    private String name;
    private Location location;
    private double wallet;
    private String description;
    private boolean dancer;

    public User(){
        id++;
        this.userId =  id;
    }

    public int getId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDancer() {
        return dancer;
    }

    public void setDancer(boolean dancer) {
        this.dancer = dancer;
    }
}
