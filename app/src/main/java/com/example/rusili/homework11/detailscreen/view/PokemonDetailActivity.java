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
	private String pokemonName;
	private ImageView pokemonPic;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		Intent intent = getIntent();
		pokemonName = intent.getStringExtra("pokeName");
		pokemonPic = findViewById(R.id.imageview);
		initialize();

//image
//		Glide.with(getApplicationContext())
//				.load()
//				.override(300, 200)
//				.into(pokemonPic);

	}

	private void initialize () {
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
//			public Pokemon pokemon;
//
//			public Pokemon getPokemon() {
//				return pokemon;
//			}

			@Override
			public void pokemonCallback (Pokemon pokemon) {
				//TODO: Display pokemon data

				Glide.with(getApplicationContext())
						.load(pokemon.getSprites().getFront_default())
						.into((ImageView) findViewById(pokemonPic.getId()));
//				Hint: Learn how to use Glide to display an image.
			}

			@Override
			public void onNetworkError(Throwable t) {
			}
		};

		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

}
