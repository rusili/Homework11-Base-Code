package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
	private RecyclerView recyclerView;
	private View view;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pokedex_fragment_layout, container, false);

		recyclerView = view.findViewById(R.id.recycler_view);
		GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
		getPokedexList();
		recyclerView.setLayoutManager(gridLayoutManager);

		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				List<PokemonEntries> pokemonList = new ArrayList<>();
				for (int i = 0; i < 150; i++) {
					pokemonList.add(pokedex.getPokemon_entries()[i]);
					Log.d("pokemon", "" + pokemonList.size());
				}
				recyclerView.setAdapter(new PokemonAdapter(pokemonList));
				// TODO: show Pokemon
				// Each pokemon is in the Pokemon_Species object.
			}

			@Override
			public void onNetworkError(Throwable t) {
				Snackbar.make(getActivity().findViewById(android.R.id.content), t.getMessage(), Snackbar.LENGTH_LONG).show();
			}
		};

		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(2);
	}
}














