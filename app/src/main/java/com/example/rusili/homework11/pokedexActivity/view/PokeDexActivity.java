package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

public class PokeDexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_dex);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        PokedexFragment pokedexFragment = new PokedexFragment();
        fragmentTransaction.replace(R.id.frag_lay, pokedexFragment);
        fragmentTransaction.commit();




    }

    public void selectPokemon(View view){
        Intent intent = new Intent(this, PokemonDetailActivity.class);
        String pokemonId = ((TextView)view).getText().toString();
        intent.putExtra(PokedexFragment.intentKey,pokemonId);
        startActivity(intent);
    }
}
