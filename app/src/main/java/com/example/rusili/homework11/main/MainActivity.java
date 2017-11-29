package com.example.rusili.homework11.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecyclerViewPackage.controller.PokemonAdapter;
import com.example.rusili.homework11.RecyclerViewPackage.model.Pokemon;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shant on 11/29/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pokemon> myPokemonList = new ArrayList<>();

        RecyclerView pokemonRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        PokemonAdapter pokemonAdapter = new PokemonAdapter(myPokemonList);

        pokemonRecyclerView.setAdapter(pokemonAdapter);
        pokemonRecyclerView.setLayoutManager(linearLayoutManager);

    }


}
