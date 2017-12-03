package com.example.rusili.homework11;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;

public class MainActivity extends AppCompatActivity {

    Button pokeButton;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokeButton = findViewById(R.id.pokedex_button);


pokeButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        PokedexFragment pokedexFragment = new PokedexFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.layout.activity_main, pokedexFragment);
        fragmentTransaction.commit();
    }
});


    }
}
