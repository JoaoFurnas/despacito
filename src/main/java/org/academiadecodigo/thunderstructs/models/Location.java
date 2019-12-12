package org.academiadecodigo.thunderstructs.models;

public enum Location {
    TER_PV("Praia da vitória"),
    TER_AH("Angra do Heroísmo"),
    SM_PDL("Ponta Delgada"),
    HOR("Horta");

    private String location;

    Location(String location) {
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}
