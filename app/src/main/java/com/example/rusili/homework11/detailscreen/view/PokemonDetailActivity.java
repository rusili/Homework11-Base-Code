package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.api.PokedexApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private RetrofitFactory retrofitFactory;
	private String pokemonName;

 	private Retrofit retrofit;
	private ImageView pokemonPic;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		Intent intent = getIntent();
		pokemonName = intent.getStringExtra("pokeName");
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
				List<Pokemon> pokemonList = new ArrayList<>();

				for (int i = 0; i < 151 ; i++) {
					Log.d("pokemon", "" + pokemonList.size());
				}
//				Hint: Learn how to use Glide to display an image.
			}
		};

		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

}
