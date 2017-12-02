package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
	private Pokedex pokedex;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, container, false);

		getPokedexList();

		return view;
	}

	public Pokedex getPokedex() {
		return pokedex;
	}

	public void setPokedex(Pokedex pokedex) {
		this.pokedex = pokedex;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				// TODO: show Pokemon
				setPokedex(pokedex);
//						.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/")
//						.override(300, 200)
//						.into(pokemonPic);
				// Each pokemon is in the Pokemon_Species object.

			}
		};


		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(2);
	}
}
