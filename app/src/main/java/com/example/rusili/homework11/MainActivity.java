package com.example.rusili.homework11;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokedexFrag();
    }


    private void getPokedexList () {
        pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback (Pokedex pokedex) {
                // TODO: show Pokemon
                // Each pokemon is in the Pokemon_Species object.

                List<PokemonEntries> pokemonEntriesList = new ArrayList<>();
                Collections.addAll(pokemonEntriesList, pokedex.getPokemon_entries());
                pokedexRecycler.setAdapter(new PokedexAdapter(pokemonEntriesList, getApplicationContext()));

//                List<String> pokemonEntries = new ArrayList<>();
//                for (int i = 0; i <= 150; i++) {
//                    pokemonEntries.add(pokedex.getPokemon_entries()[i].getPokemon_species().getName());
//                }
//                PokedexAdapter pokedexAdapter = new PokedexAdapter(pokemonEntries)

            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);

    private void pokedexFrag() {
        PokedexFragment pokedexFragment = new PokedexFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, pokedexFragment);
        fragmentTransaction.commit();
        Log.d("main", "frag ran");

    }
}


