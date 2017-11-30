package com.example.rusili.homework11.detailscreen.model;

import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Types;

public class Pokemon {
    private Stats[] stats;
    private Sprites sprites;
    private Types[] types;

    public Stats[] getStats() {
        return stats;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public Types[] getTypes() {
        return types;
    }

    public void setStats(Stats[] stats) {
        this.stats = stats;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public void setTypes(Types[] types) {
        this.types = types;
    }
}
