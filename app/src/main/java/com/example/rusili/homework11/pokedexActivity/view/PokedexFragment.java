package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	View rootView;
	ImageView imageView;
	String pokemonName;
	String imageURL;
	Context context;
	String img;

	public PokedexFragment(){

	}

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.image_fragment,container,false);

		context = rootView.getContext();
		imageView = (ImageView) rootView.findViewById(R.id.detail_imageview_sprite);

		Bundle bundle = getArguments();
		pokemonName = bundle.getString("pokemon");
		img = bundle.getString("default");


		getPokemonDetails();

		return rootView;
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {

			@Override
			public void pokemonCallback (Pokemon pokemon) {
				Log.d("imgvalue",img);
				if(img.equals("front")){
				imageURL = pokemon.getSprites().getFront_default();
				Glide.with(context)
						.load(imageURL)
						.into(imageView);
				}
				if(img.equals("back")){
					imageURL = pokemon.getSprites().getBack_default();
					Glide.with(context)
							.load(imageURL)
							.into(imageView);
				}
			}


			@Override
			public void onNetworkError(Throwable t) {
				Snackbar.make(rootView.findViewById(android.R.id.content), t.getMessage(), Snackbar.LENGTH_LONG).show();
			}

		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

}
