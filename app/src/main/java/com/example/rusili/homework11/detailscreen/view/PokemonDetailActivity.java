package com.example.rusili.homework11.detailscreen.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.api.PokedexApi;

import retrofit2.Retrofit;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private RetrofitFactory retrofitFactory;
 	private ImageView pokemonPic;
 	private String pokemonName;
 	private Retrofit retrofit;
	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pokemonPic = findViewById(R.id.image);

		initialize();
	}

	private void initialize () {
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				pokemonName = pokemon.getStats()[0].getStat().getName();
				//TODO: Display pokemon data

				Glide.with(getApplicationContext())
						.load(pokemon.getSprites().getFront_default())
						.override(300, 200)
						.into(pokemonPic);
//				Hint: Learn how to use Glide to display an image.
			}
		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}
}
