package com.example.rusili.homework11.pokedexActivity.model;

import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.example.rusili.homework11.pokedexActivity.model.objects.Region;
import com.example.rusili.homework11.pokedexActivity.model.objects.VersionGroups;

/**
 * Created by rusi.li on 11/22/17.
 */

public class Pokedex {
    private int id;
    private Region region;
    private VersionGroups[] version_groups;
    private PokemonEntries[] pokemon_entries;

    //TODO: Create getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public VersionGroups[] getVersion_groups() {
        return version_groups;
    }

    public void setVersion_groups(VersionGroups[] version_groups) {
        this.version_groups = version_groups;
    }

    public PokemonEntries[] getPokemon_entries() {
        return pokemon_entries;
    }

    public void setPokemon_entries(PokemonEntries[] pokemon_entries) {
        this.pokemon_entries = pokemon_entries;
    }
}
