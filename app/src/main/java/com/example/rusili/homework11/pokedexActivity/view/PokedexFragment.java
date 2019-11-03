package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.PokemonAdapter;
import com.example.rusili.homework11.R;
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
	private RecyclerView recyclerView;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, container, false );
		recyclerView = (RecyclerView) view.findViewById(R.id.frag_view);
		getPokedexList();
		GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
		recyclerView.setLayoutManager(gridLayoutManager);


		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				// TODO: show Pokemon
				// Each pokemon is in the Pokemon_Species object.
				List<PokemonEntries> pokemonEntriesList = new ArrayList<>();
				Collections.addAll(pokemonEntriesList, pokedex.getPokemon_entries());
				recyclerView.setAdapter(new PokemonAdapter(pokemonEntriesList));

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
