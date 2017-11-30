package com.example.rusili.homework11.pokedexActivity.model.objects;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokemonEntries {
    private int entry_number;
    private Pokemon_Species pokemon_species;

    public Pokemon_Species getPokemon_species() {
        return pokemon_species;
    }

    public int getEntry_number() {
        return entry_number;
    }

    public static class Pokemon_Species{
        private String url;
        private String name;

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }
    }
}
