package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecycleView.PokAdapter;
import com.example.rusili.homework11.RecycleView.PokViewHolder;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Type;
import com.example.rusili.homework11.detailscreen.model.objects.Types;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity {
    private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
    private Sprites sprites;
    private Stats[] stats;
    private Types[] types;
    private String pokemonName;
    private ImageView pokeImage;
    private TextView name, typeInfo, typeInfo2, stat1, stat2, stat3, stat4, stat5, stat6, stat1Percentage, stat2Percentage, stat3Percentage, stat4Percentage, stat5Percentage, stat6Percentage;


    private RoundCornerProgressBar progress1, progress2, progress3, progress4, progress5, progress6;

    private int progressColor1, progressColor2, progressColor3, progressColor4, progressColor5, progressColor6;
    private int backgroundColor1, backgroundColor2, backgroundColor3, backgroundColor4, backgroundColor5, backgroundColor6;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poke_detail_layout);
        Intent intent = getIntent();
        pokemonName = intent.getStringExtra(PokViewHolder.POKEMON_KEY);

        initialize();

    }

    private void initialize() {
        getPokemonDetails();

    }

    private void getPokemonDetails() {
        pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
            @Override
            public void pokemonCallback(Pokemon pokemon) {

                settingViews();
                sprites = pokemon.getSprites();
                stats = pokemon.getStats();
                types = pokemon.getTypes();
                passingTheValues(pokemon);
            }
        };
        RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
        RetrofitFactory.getInstance().getPokemon(pokemonName);
    }

    private void passingTheValues(Pokemon pokemon) {
        Log.d("stat size is:  ", "" + stats.length);
        TextView[] stat = {stat1, stat2, stat3, stat4, stat5, stat6};
        TextView[] statPercentage = {stat1Percentage, stat2Percentage, stat3Percentage, stat4Percentage, stat5Percentage, stat6Percentage};
        RoundCornerProgressBar[] progressBars = {progress1, progress2, progress3, progress4, progress5, progress6};
        for (int i = 0; i < stats.length; i++) {
            stat[i].setText(stats[i].getStat().getName());
            statPercentage[i].setText((stats[i].getBase_stat()) + " %");
            progressBars[i].setProgressColor(Color.parseColor("#ed3b27"));
            progressBars[i].setProgressBackgroundColor(Color.parseColor("#56d2c2"));
            progressBars[i].setMax(100);
            progressBars[i].setProgress((float) stats[i].getBase_stat());
        }

        typeInfo.setText(types[0].getType().getName());
        if (types.length > 1) {
            typeInfo2.setVisibility(View.VISIBLE);
            typeInfo2.setText(types[1].getType().getName());
        } else {
            typeInfo2.setVisibility(View.INVISIBLE);
        }
        name.setText(pokemonName);
        Glide.with(PokemonDetailActivity.this).load(sprites.getFront_default()).into(pokeImage);
    }

    private void settingViews() {

        pokeImage = findViewById(R.id.poke_image_detail);
        name = (TextView) findViewById(R.id.name);
        typeInfo = (TextView) findViewById(R.id.type_result);
        typeInfo2 = (TextView) findViewById(R.id.type_result2);
        stat1 = (TextView) findViewById(R.id.stat1);
        stat2 = (TextView) findViewById(R.id.stat2);
        stat3 = (TextView) findViewById(R.id.stat3);
        stat4 = (TextView) findViewById(R.id.stat4);
        stat5 = (TextView) findViewById(R.id.stat5);
        stat6 = (TextView) findViewById(R.id.stat6);
        stat1Percentage = (TextView) findViewById(R.id.stat1_percentage);
        stat2Percentage = (TextView) findViewById(R.id.stat2_percentage);
        stat3Percentage = (TextView) findViewById(R.id.stat3_percentage);
        stat4Percentage = (TextView) findViewById(R.id.stat4_percentage);
        stat5Percentage = (TextView) findViewById(R.id.stat5_percentage);
        stat6Percentage = (TextView) findViewById(R.id.stat6_percentage);
        progress1 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
        progress2 = (RoundCornerProgressBar) findViewById(R.id.progress_2);
        progress3 = (RoundCornerProgressBar) findViewById(R.id.progress_3);
        progress4 = (RoundCornerProgressBar) findViewById(R.id.progress_4);
        progress5 = (RoundCornerProgressBar) findViewById(R.id.progress_5);
        progress6 = (RoundCornerProgressBar) findViewById(R.id.progress_6);


    }



/*

    private void changeColor(String type, int num) {

	    switch (type) {
            case "bug":
                if (num == 2) {
                    type2.setText("Bug");
                   type2.setBackgroundResource(R.color.bug);
                } else {
                    type1.setBackgroundResource(R.color.bug);
                    type1.setText("Bug");
                }
                break;
            case "dragon":
                if (num == 2) {
                    type2.setText("Dragon");
                    type2.setBackgroundResource(R.color.dragon);
                } else {
                    type1.setBackgroundResource(R.color.dragon);
                    type1.setText("Dragon");
                }
                break;
            case "ice":
                if (num == 2) {
                    type2.setText("Ice");
                    type2.setBackgroundResource(R.color.ice);
                } else {
                    type1.setBackgroundResource(R.color.ice);
                    type1.setText("Ice");
                }
                break;
            case "fighting":
                if (num == 2) {
                    type2.setText("Fighting");
                    type2.setBackgroundResource(R.color.fighting);
                } else {
                    type1.setBackgroundResource(R.color.fighting);
                    type1.setText("Fighting");
                }
                break;
            case "fire":
                if (num == 2) {
                    type2.setText("Fire");
                    type2.setBackgroundResource(R.color.fire);
                } else {
                    type1.setBackgroundResource(R.color.fire);
                    type1.setText("Fire");
                }
                break;
            case "flying":
                if (num == 2) {
                    type2.setText("Flying");
                    type2.setBackgroundResource(R.color.flying);
                } else {
                    type1.setBackgroundResource(R.color.flying);
                    type1.setText("Flying");
                }
                break;
            case "grass":
                if (num == 2) {
                    type2.setText("Grass");
                    type2.setBackgroundResource(R.color.grass);
                } else {
                    type1.setBackgroundResource(R.color.grass);
                    type1.setText("Grass");
                }
                break;
            case "ghost":
                if (num == 2) {
                    type2.setText("Ghost");
                    type2.setBackgroundResource(R.color.ghost);
                } else {
                    type1.setBackgroundResource(R.color.ghost);
                    type1.setText("Ghost");
                }
                break;
            case "ground":
                if (num == 2) {
                    type2.setText("Ground");
                    type2.setBackgroundResource(R.color.ground);
                } else {
                    type1.setBackgroundResource(R.color.ground);
                    type1.setText("Ground");
                }
                break;
            case "electric":
                if (num == 2) {
                    type2.setText("Electric");
                    type2.setBackgroundResource(R.color.electric);
                } else {
                    type1.setBackgroundResource(R.color.electric);
                    type1.setText("Electric");
                }
                break;
            case "normal":
                if (num == 2) {
                    type2.setText("Normal");
                    type2.setBackgroundResource(R.color.normal);
                } else {
                    type1.setBackgroundResource(R.color.normal);
                    type1.setText("Normal");
                }
                break;
            case "poison":
                if (num == 2) {
                    type2.setText("Poison");
                    type2.setBackgroundResource(R.color.poison);
                } else {
                    type1.setBackgroundResource(R.color.poison);
                    type1.setText("Poison");
                }
                break;
            case "psychic":
                if (num == 2) {
                    type2.setText("Psychic");
                    type2.setBackgroundResource(R.color.psychic);
                } else {
                    type1.setBackgroundResource(R.color.psychic);
                    type1.setText("Psychic");
                }
                break;
            case "rock":
                if (num == 2) {
                    type2.setText("Rock");
                    type2.setBackgroundResource(R.color.rock);
                } else {
                    type1.setBackgroundResource(R.color.rock);
                    type1.setText("Rock");
                }
                break;
            case "water":
                if (num == 2) {
                    type2.setText("Water");
                    type2.setBackgroundResource(R.color.water);
                } else {
                    type1.setBackgroundResource(R.color.water);
                    type1.setText("Water");
                }
                break;
        }

    }
    */

}
