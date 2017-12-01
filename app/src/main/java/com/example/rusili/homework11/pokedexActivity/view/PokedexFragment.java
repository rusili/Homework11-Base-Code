package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.controller.PokedexAdapter;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private RecyclerView pokedexRecycler;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pokedex, container, false);
		pokedexRecycler = (RecyclerView) view.findViewById(R.id.pokedex_frag_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
		getPokedexList();
        pokedexRecycler.setLayoutManager(gridLayoutManager);
		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
                List<PokemonEntries> pokemonEntriesList = new ArrayList<>();
                Collections.addAll(pokemonEntriesList, pokedex.getPokemon_entries());
				pokedexRecycler.setAdapter(new PokedexAdapter(pokemonEntriesList));
			}
		};
		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(2);
	}

	private void getPokemonDetails (String name) {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {

			}
		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(name);

	}
}
