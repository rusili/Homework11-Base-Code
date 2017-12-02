package com.example.rusili.homework11.RecyclerViewPackage.model;

/**
 * Created by Shant on 11/29/2017.
 */

public class Pokemon {

    private String pokemonName;
    private String url;

    public Pokemon(String pokemonName,String url) {
        this.pokemonName = pokemonName;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}
