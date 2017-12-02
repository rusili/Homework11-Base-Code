package com.example.rusili.homework11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.pokemon_fragment, new PokedexFragment()).commit();

    }
}
