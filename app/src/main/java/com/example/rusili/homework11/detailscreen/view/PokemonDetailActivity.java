package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Types;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity{
	private final String TAG = "PokemonDetails";
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private String pokemonName;
	private ImageView pokemonPic;
	private Intent intent;
	private TextView stat1,stat2,stat3,stat4,stat5,stat6,type1,type2;
	private ProgressBar simpleProgressBar1,simpleProgressBar2,simpleProgressBar3,simpleProgressBar4,simpleProgressBar5,simpleProgressBar6; // initiate the progress bar

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		intent = getIntent();
		pokemonName = intent.getStringExtra("pokeName");
		pokemonPic = findViewById(R.id.imageview);
		stat1 = findViewById(R.id.stat1);
		stat2 = findViewById(R.id.stat2);
		stat3 = findViewById(R.id.stat3);
		stat4 = findViewById(R.id.stat4);
		stat5 = findViewById(R.id.stat5);
		stat6 = findViewById(R.id.stat6);
		simpleProgressBar1 = (ProgressBar) findViewById(R.id.simpleProgressBar1);
		simpleProgressBar2 = (ProgressBar) findViewById(R.id.simpleProgressBar2);
		simpleProgressBar3 = (ProgressBar) findViewById(R.id.simpleProgressBar3);
		simpleProgressBar4 = (ProgressBar) findViewById(R.id.simpleProgressBar4);
		simpleProgressBar5 = (ProgressBar) findViewById(R.id.simpleProgressBar5);
		simpleProgressBar6 = (ProgressBar) findViewById(R.id.simpleProgressBar6);
		type1 = findViewById(R.id.type1);
		type2 = findViewById(R.id.type2);
		stat1.setVisibility(View.INVISIBLE);
		stat2.setVisibility(View.INVISIBLE);
		stat3.setVisibility(View.INVISIBLE);
		stat4.setVisibility(View.INVISIBLE);
		stat5.setVisibility(View.INVISIBLE);
		stat6.setVisibility(View.INVISIBLE);
		simpleProgressBar1.setVisibility(View.INVISIBLE);
		simpleProgressBar2.setVisibility(View.INVISIBLE);
		simpleProgressBar3.setVisibility(View.INVISIBLE);
		simpleProgressBar4.setVisibility(View.INVISIBLE);
		simpleProgressBar5.setVisibility(View.INVISIBLE);
		simpleProgressBar6.setVisibility(View.INVISIBLE);
		type1.setVisibility(View.INVISIBLE);
		type2.setVisibility(View.INVISIBLE);

//image
//		Glide.with(getApplicationContext())
//				.load()
//				.override(300, 200)
//				.into(pokemonPic);

		initialize();
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
						.diskCacheStrategy(DiskCacheStrategy.ALL)
						.centerCrop()
						.crossFade()
						.into(pokemonPic);
//				Hint: Learn how to use Glide to display an image.
				Stats[] stats = pokemon.getStats();
				Types[] types = pokemon.getTypes();
				if(types.length == 1) {
					type1.setVisibility(View.VISIBLE);
					type1.setText(types[0].getType().getName());
				}else {
					type1.setVisibility(View.VISIBLE);
					type2.setVisibility(View.VISIBLE);
					type1.setText(types[0].getType().getName());
					type2.setText(types[1].getType().getName());
				}
				Log.d(TAG,"# of stat " + stats.length);
				Log.d(TAG,pokemon.getTypes()[0].getType().getName());

				TextView[] textViews = {stat1,stat2,stat3,stat4,stat5,stat6};
				ProgressBar[] progressBars = {simpleProgressBar1,simpleProgressBar2,simpleProgressBar3,simpleProgressBar4,simpleProgressBar5,simpleProgressBar6};
				for (int i = 0; i < 6; i++) {
					int statNum = stats[i].getBase_stat();
					textViews[i].setVisibility(View.VISIBLE);
					progressBars[i].setVisibility(View.VISIBLE);
					textViews[i].setText(stats[i].getStat().getName());
					progressBars[i].setMax(100);
					progressBars[i].setProgress(statNum);
				}


			}

			@Override
			public void onNetworkError(Throwable t) {
			}
		};

		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

}
