package com.example.rusili.homework11.detailscreen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;

import java.util.Arrays;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	Bundle bundle;
	private String pokemonName;
	private ImageView pokeImage;
	private TextView pokeName;
	private TextView pokeStats;
	private TextView pokeType;
	private String imageURL;
	Context context;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pokemondetail);
		context = this.getApplicationContext();
		initialize();
	}

	private void initialize () {
		bundle = getIntent().getExtras();
		pokemonName = bundle.getString("pokemon");
		instantiateViews();
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				//TODO: Display pokemon data
				//Hint: Learn how to use Glide to display an image.

				imageURL = pokemon.getSprites().getBack_default();
				Glide.with(context)
						.load(imageURL)
						.into(pokeImage);
				pokeName.setText(pokemonName);
				pokeType.setText(Arrays.toString(pokemon.getTypes()));
				pokeStats.setText(Arrays.toString(pokemon.getStats()));
			}


		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

	public void instantiateViews(){
		pokeImage = (ImageView) findViewById(R.id.detail_imageview_sprite);
		pokeName = (TextView) findViewById(R.id.detail_textview_name);
		pokeType = (TextView) findViewById(R.id.detail_textview_type);
		pokeStats = (TextView) findViewById(R.id.detail_textview_stats);

	}
}