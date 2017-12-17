package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Types;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;

	TextView pokemonName;
	TextView pokemonStats;
	TextView pokemonType;
	TextView pokemonAverage;
	private String id;
	Intent intent;
	String url;




	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_view_layout);
		intent= getIntent();
		id= intent.getStringExtra("pokemon");
		url=intent.getStringExtra("url");

		String pokemonNmae= intent.getStringExtra("pokemon");
		CharSequence name = pokemonNmae.substring(0,pokemonNmae.length()).toUpperCase();
		this.setTitle(name);

		pokemonName= (TextView) findViewById(R.id.nameTextView);
		pokemonName.setText(id);
		pokemonStats = (TextView) findViewById(R.id.statsTextView);
		pokemonType= (TextView) findViewById(R.id.typeTextView);
		pokemonAverage = (TextView) findViewById(R.id.averageTextView);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);

		initialize();
	}

	private void initialize() {
		getPokemonDetails();
	}

	private void getPokemonDetails() {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback(Pokemon pokemon) {

//                Glide.with(getApplicationContext())
//                        .load(url)
//                        .apply(new RequestOptions().override(600, 200))
//                        .into((ImageView) findViewById(R.id.pokemonimage_ImageView));


				Glide.with(getApplicationContext())
						.load(pokemon.getSprites().getFront_default())

						.apply(new RequestOptions().centerCrop().fitCenter())
						.into((ImageView) findViewById(R.id.pokemon_ImageView));

				Stats[] stats = pokemon.getStats();
				Types[] types = pokemon.getTypes();
				String st = "";
				String typ = "";
				int average = 0;

				for (int i = 0; i < stats.length; i++) {

					st += stats[i].getStat().getName() + " : " + stats[i].getBase_stat() + "\n";

					average += stats[i].getBase_stat();

					System.out.println("Number= " + i + "  " + stats[i].getStat().getName() + " : " + stats[i].getBase_stat());
					System.out.println("Number= " + i + "  " + stats[i].getStat().getUrl());
				}

				for (int i = 0; i < types.length; i++) {

					typ += types[i].getType().getName() + "\n";
					System.out.println("Number= " + i + "  " + types[i].getType().getName());

				}

				int total = average / 6;
				//statsTextView.setText(stats[0].getStat().getName()+" : "+stats[0].getBase_stat());
				pokemonStats.setText(st);
				pokemonType.setText(typ);

				pokemonAverage.setText(average);

				//System.out.println("==========="+);
				//stats[0].getStat();

				ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar); // initiate the progress bar
				simpleProgressBar.setMax(100); // 100 maximum value for the progress value
				simpleProgressBar.setProgress(average / 6); // 50 default progress value for the progress bar

			}
		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(id);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}


