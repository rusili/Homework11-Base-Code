package com.example.rusili.homework11.main;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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

import static android.app.PendingIntent.getActivity;


/**
 * Created by Shant on 11/29/2017.
 */

public class MainActivity extends AppCompatActivity {
    List<PokemonEntries> myPokemonList;
    RecyclerView pokemonRecyclerView;
    LinearLayoutManager linearLayoutManager;
    PokemonAdapter pokemonAdapter;

    final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearLayoutManager = new GridLayoutManager(getApplicationContext(),3,GridLayoutManager.VERTICAL, false);
        getPokedexList();
        pokemonAdapter = new PokemonAdapter(myPokemonList);
        pokemonRecyclerView.setLayoutManager(linearLayoutManager);


}
    private void getPokedexList() {
        myPokemonList = new ArrayList<>();

        RetrofitFactory.PokedexNetworkListener pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {

                for (int i = 0; i < 150; i++) {
                    myPokemonList.add(pokedex.getPokemon_entries()[i]);
                }

                pokemonRecyclerView.setAdapter(pokemonAdapter);

            }
            @Override
            public void onNetworkError(Throwable t) {
                Snackbar.make(findViewById(android.R.id.content), t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        };

        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);

    }
}







