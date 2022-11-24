package org.delta.atm;

import org.delta.card.BaseCard;

public class BaseATM {
    private String id;
    private String name;
    private String location;

    public BaseCard insertedCard;

    public BaseATM(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}
