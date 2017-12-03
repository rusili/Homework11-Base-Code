package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;

import java.util.ArrayList;

public class PokemonDetailActivity extends AppCompatActivity {
    TextView name, attack, spAttack, spDefense, weight, height, type, moves;
    ImageView pokePic;
    ArrayList<TextView> statsNames = new ArrayList<>();
    private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;

<<<<<<<<< Temporary merge branch 1
	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView();
=========
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        initialize();
        setValues();
//        RecyclerView pokedexRecyclerView = (RecyclerView) findViewById(R.id.pokedex_recyclerview);
    }

    private void setValues(){
        pokePic = findViewById(R.id.pokemon_sprite);
        statsNames.add(name = findViewById(R.id.poke_name));
        statsNames.add(attack = findViewById(R.id.poke_attack));
        statsNames.add(spAttack = findViewById(R.id.poke_sp_attack));
        statsNames.add(spDefense = findViewById(R.id.poke_sp_defense));
        statsNames.add(weight = findViewById(R.id.poke_weight));
        statsNames.add(height = findViewById(R.id.poke_height));
        statsNames.add(type = findViewById(R.id.poke_type));
        statsNames.add(moves = findViewById(R.id.poke_moves));
    }

    private void initialize() {
        getPokemonDetails();
    }

    private void getPokemonDetails() {
        String selectedPokemon = getIntent().getExtras().getString(PokedexFragment.intentKey);
        pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
            @Override
            public void pokemonCallback(Pokemon pokemon) {
                //TODO: Display pokemon data
                //Hint: Learn how to use Glide to display an image.
                //do some more code
                String url = pokemon.getSprites().getFront_default();
                Glide.with(pokePic.getContext()).load(url).into(pokePic);

                for(int i = 0; i < pokemon.getStats().length;i++) {
                    statsNames.get(i).setText(pokemon.getStats()[i].getStat().getName()+
                    " "+ pokemon.getStats()[i].getBase_stat());
//                type.setText(pokemon.getTypes().toString());
                }
            }
        };
        RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
        RetrofitFactory.getInstance().getPokemon(selectedPokemon);
    }
>>>>>>>>> Temporary merge branch 2
}
