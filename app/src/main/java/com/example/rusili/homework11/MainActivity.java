package com.example.rusili.homework11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.homework11.detailscreen.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Pokemon> pokemonList = new ArrayList<>();
    RecyclerView recyclerView;
    PokemonAdapter pokemonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =  findViewById(R.id.rv_pokemons);

        pokemonAdapter = new PokemonAdapter(pokemonList);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pokemonAdapter);
    }
    private void addData() {

        Pokemon poke;

        poke = new Pokemon("Bulbasaur", "Grass");
        pokemonList.add(poke);

        poke = new Pokemon("Charmander", "Fire");
        pokemonList.add(poke);

        poke = new Pokemon("Squirtle", "Water");
        pokemonList.add(poke);

        pokemonAdapter.notifyDataSetChanged();
    }
}
