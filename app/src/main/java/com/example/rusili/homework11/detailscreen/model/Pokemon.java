package com.example.rusili.homework11.detailscreen.model;

import com.example.rusili.homework11.detailscreen.model.objects.PokeType;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    @SerializedName("name")
    private String name;

    @SerializedName("attack")
    private Integer attack;

    @SerializedName("defense")
    private Integer defense;

    @SerializedName("height")
    private String height;

    @SerializedName("hp")
    private Integer health;

    @SerializedName("pkdx_id")
    private Integer pokedexId;

    @SerializedName("speed")
    private Integer speed;

    @SerializedName("weight")
    private String weight;

    @SerializedName("sprites")
    private List<Sprites> sprites = new ArrayList<>();

    @SerializedName("types")
    private List<PokeType> pokeTypes = new ArrayList<>();

    public Pokemon(String bulbasaur, String grass) {

    }




	/*private Stats[] stats;
	private Sprites sprites;
	//private Types[] types;

	//TODO: Create getters

	public Stats[] getStats() {
		return stats;
	}

	public Sprites getSprites() {
		return sprites;
	}

	public Types[] getTypes() {
		return types;
	}*/
}
