package com.example.rusili.homework11.detailscreen.model.objects;
import com.google.gson.annotations.SerializedName;

public class PokeType {
    @SerializedName("name")
    private String name;

    public PokeType(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	/*private String url;
	private String name;

	public String getUrl () {
		return url;
	}

	public String getName () {
		return name;
	}*/
}
