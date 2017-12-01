package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.view.PokemonViewHolder;
import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private String pokemonName;
	private ImageView cardImage;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokemon_layout);

		cardImage = findViewById(R.id.card_image);


		Intent intent = getIntent();
		pokemonName = intent.getStringExtra(PokemonViewHolder.POK_KEY);

		initialize();
	}

	private void initialize () {
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				//TODO: Display pokemon data
				//Hint: Learn how to use Glide to display an image.

				ImageView imageView = findViewById(R.id.pokemon_image);
				TextView textView1 = findViewById(R.id.pokemon_text1);
				TextView textView2 = findViewById(R.id.pokemon_text2);
				TextView textView3 = findViewById(R.id.pokemon_text3);
				TextView textView4 = findViewById(R.id.pokemon_text4);
				TextView textView5 = findViewById(R.id.pokemon_text5);
				TextView textView6 = findViewById(R.id.pokemon_text6);
				TextView textView7 = findViewById(R.id.pokemon_text7);
				TextView textView8 = findViewById(R.id.pokemon_text8);
				TextView textView9 = findViewById(R.id.pokemon_text9);
				TextView textView10 = findViewById(R.id.pokemon_text10);
				TextView textView11 = findViewById(R.id.pokemon_text11);
				TextView textView12 = findViewById(R.id.pokemon_text12);

				Stats[] stats = pokemon.getStats();
				Sprites sprites = pokemon.getSprites();

				String info =String.valueOf(stats[0].getBase_stat());
				String info1 =String.valueOf(stats[1].getBase_stat());
				String info2 =String.valueOf(stats[2].getBase_stat());
				String info3 =String.valueOf(stats[3].getBase_stat());
				String info4 =String.valueOf(stats[4].getBase_stat());
				String info5 =String.valueOf(stats[5].getBase_stat());

				Picasso.with(PokemonDetailActivity.this).load(sprites.getFront_default()).into(imageView);

				textView1.setText(stats[0].getStat().getName() + ":");
				textView2.setText(info);

				textView3.setText(stats[1].getStat().getName() + ":");
				textView4.setText(info1);

				textView5.setText(stats[2].getStat().getName() + ":");
				textView6.setText(info2);

				textView7.setText(stats[3].getStat().getName() + ":");
				textView8.setText(info3);

				textView9.setText(stats[4].getStat().getName() + ":");
				textView10.setText(info4);

				textView11.setText(stats[5].getStat().getName() + ":");
				textView12.setText(info5);
			}
		};

		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}
}
