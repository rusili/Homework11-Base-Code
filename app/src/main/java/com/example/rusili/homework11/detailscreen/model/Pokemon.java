package com.example.rusili.homework11.detailscreen.model;

import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Types;

public class Pokemon {
	private Stats[] stats;
	private Sprites sprites;
	private Types[] types;

	//TODO: Create getters


    public Stats[] getStats() {
        return stats;
    }

    public void setStats(Stats[] stats) {
        this.stats = stats;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Types[] getTypes() {
        return types;
    }

    public void setTypes(Types[] types) {
        this.types = types;
    }
}
