package com.example.rusili.homework11.pokedexActivity.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.controller.PokemonAdapter;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private static final String TAG = "PokedexFrag";
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
	private RecyclerView recyclerView;
	private PokemonAdapter pokemonAdapter;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
		pokemonAdapter = new PokemonAdapter(view.getContext());
		LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
		recyclerView.setAdapter(pokemonAdapter);
		recyclerView.setLayoutManager(layoutManager);
		getPokedexList();
		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {

			@Override
			public void pokedexCallback (Pokedex pokedex) {
				// TODO: show Pokemon
				List<PokemonEntries> pokemonList = new ArrayList<>();

				for (int i = 0; i < 151 ; i++) {
					pokemonList.add(pokedex.getPokemon_entries()[i]);
					Log.d(TAG, "" + pokemonList.size());
				}

				pokemonAdapter.addPokemonList(pokemonList);

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
