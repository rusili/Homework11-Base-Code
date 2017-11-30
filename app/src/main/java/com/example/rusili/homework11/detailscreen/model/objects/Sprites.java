package com.example.rusili.homework11.detailscreen.model.objects;


import com.google.gson.annotations.SerializedName;

public class Sprites {
	@SerializedName("name")
	private String name;

	@SerializedName("resource_uri")
	private String resourceUri;

	public Sprites(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}

	/*private String back_female;
	private String back_shiny_female;
	private String back_default;
	private String front_female;
	private String front_shiny_female;
	private String back_shiny;
	private String front_default;
	private String front_shiny;

	public String getBack_default () {
		return back_default;
	}

	public String getFront_default () {
		return front_default;
	}*/
}
