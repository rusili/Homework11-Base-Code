package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {

	TextView species_View;
	TextView id_View;
	TextView region_View;
	TextView version_View;
	TextView entry_View;

	//TODO: Create click method for CardView
	//TODO: Create Intent to PokemonDetailActivity
	//TODO: Create RecyclerView classes

	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pokedex_fragment, container, false);

		getPokedexList();

		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				// TODO: show Pokemon
				// Each pokemon is in the Pokemon_Species object.
				PokemonEntries pokemonEntries = new PokemonEntries();
				//this might be wrong
				species_View = species_View.findViewById(R.id.species_view);
				id_View = id_View.findViewById(R.id.pokemon_id_view);
				region_View = region_View.findViewById(R.id.region_view);
				version_View = version_View.findViewById(R.id.version_group_view);
				entry_View = entry_View.findViewById(R.id.entry_number_view);

				species_View.setText(pokemonEntries.getPokemon_species().toString());
				id_View.setText(pokedex.getId());
				region_View.setText(pokedex.getRegion().toString());
				version_View.setText(pokedex.getVersion_groups().toString());
				entry_View.setText(pokemonEntries.getEntry_number());


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
