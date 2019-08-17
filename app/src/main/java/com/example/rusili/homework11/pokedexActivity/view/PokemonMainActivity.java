package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rusili.homework11.R;

public class PokemonMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PokedexFragment()).commit();
    }
}
