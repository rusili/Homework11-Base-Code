package com.example.rusili.homework11.detailscreen.model;

public class Pokemon {
	private String name;
	private  String type;

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
	/*private Stats[] stats;
	private Sprites sprites;
	private Types[] types;

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
