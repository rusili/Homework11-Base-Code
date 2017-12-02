package com.example.rusili.homework11.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecyclerViewPackage.controller.PokemonAdapter;
import com.example.rusili.homework11.RecyclerViewPackage.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Shant on 11/29/2017.
 */

public class MainActivity extends AppCompatActivity {

    List<PokemonEntries> myPokemonList;
    final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myPokemonList = new ArrayList<>();
        getPokedexList();


        RecyclerView pokemonRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        PokemonAdapter pokemonAdapter = new PokemonAdapter(myPokemonList);

        pokemonRecyclerView.setAdapter(pokemonAdapter);
        pokemonRecyclerView.setLayoutManager(linearLayoutManager);


    }


    public List<Pokemon> populateList(){
        List<Pokemon> myList = new ArrayList<>();

        return myList;
    }

    private void getPokedexList () {
         RetrofitFactory.PokedexNetworkListener pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback (Pokedex pokedex) {

                for (int i = 0; i < 150; i++) {
                    //Log.d("pokemon", "" + pokedex.getPokemon_entries()[i].getPokemon_species().getName());
                    myPokemonList.add(pokedex.getPokemon_entries()[i]);
                    Log.d(TAG, "" + myPokemonList.size());
                }

            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);
    }


}
