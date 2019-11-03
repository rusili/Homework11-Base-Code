
package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Types;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private String pokemonName;
	TextView textViewType;
	TextView textViewStat;
	ImageView pokemonImage;
	String type;
	String stat;




	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokemon_detail);
        Intent intent = getIntent();
        pokemonName = intent.getStringExtra("Pokemon");
        getPokemonDetails(pokemonName);
		pokemonImage = (ImageView) findViewById(R.id.details_image);
		textViewType = (TextView) findViewById(R.id.details_textview_type);
		textViewStat = (TextView) findViewById(R.id.details_textview_stat);

	}
/*
	private void initialize () {
		getPokemonDetails();
	}*/

	private void getPokemonDetails (final String pokemonName) {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				//TODO: Display pokemon data
				//Hint: Learn how to use Glide to display an image.
				Glide.with(getApplicationContext())
						.load(pokemon.getSprites().getFront_default())
						.into(pokemonImage);
				Stats[] stats = pokemon.getStats();
				for (int i = 0; i < stats.length; i++){

					stat = stats[i].getStat().getName();
				}

				Types[] types = pokemon.getTypes();
				for (int i = 0; i < types.length; i++) {
					type = types[i].getType().getName();
				}

				textViewType.setText(type);
				textViewStat.setText(stat);





			}

			@Override
			public void onNetworkError(Throwable t) {
				Snackbar.make(findViewById(android.R.id.content), t.getMessage(), Snackbar.LENGTH_LONG).show();
			}
		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}
}

