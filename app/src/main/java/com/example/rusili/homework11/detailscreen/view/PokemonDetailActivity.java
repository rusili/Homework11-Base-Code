package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity{
    private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
    //private String pokeName= getIntent().getExtras().getString("pokemon");

    private String id;


    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
         Intent intent = getIntent();
         id = intent.getStringExtra("pokemon");



        initialize();
    }

    private void initialize () {
        getPokemonDetails();
    }

    private void getPokemonDetails () {
        pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
            @Override
            public void pokemonCallback (Pokemon pokemon) {
                //TODO: Display pokemon data
                //Hint: Learn how to use Glide to display an image.

                Glide.with(getApplicationContext())
                        .load(pokemon.getSprites().getBack_default())
                        .into((ImageView)findViewById(R.id.pokemonimage_ImageView) );



            }
        };
        RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
        RetrofitFactory.getInstance().getPokemon(id);
    }
}
