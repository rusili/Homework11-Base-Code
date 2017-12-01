package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rusili.homework11.R;

public class PokeDexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_dex);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PokedexFragment pokedexFragment = new PokedexFragment();
        fragmentTransaction.replace(R.id.frag_lay, pokedexFragment);
        fragmentTransaction.commit();




    }
}
