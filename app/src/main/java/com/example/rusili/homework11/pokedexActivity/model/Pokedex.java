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

    public Pokedex(int id, Region region, VersionGroups[] version_groups, PokemonEntries[] pokemonEntries){
        this.id = id;
        this.region = region;
        this.version_groups = version_groups;
        this.pokemon_entries = pokemonEntries;
    }

    public int getId() {
        return id;
    }

    //TODO: Create getters

    public Region getRegion() {
        return region;
    }

    public PokemonEntries[] getPokemon_entries() {
        return pokemon_entries;
    }

    public VersionGroups[] getVersion_groups() {
        return version_groups;
    }

}
