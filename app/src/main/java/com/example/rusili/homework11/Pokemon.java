package com.example.rusili.homework11;

import java.util.List;

/**
 * Created by c4q on 11/29/17.
 */

public class Pokemon {
    private String name;
    private String type;

    public Pokemon() {

    }
    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String pokeTypesToString() {
        String types = "";
        List pokeTypes;
        for (int i = 0; i < pokeTypes.size(); i++) {
            if(i > 0)
                types += ", ";
            types += pokeTypes.get(i).getName();
        }

        return types;
    }
}
