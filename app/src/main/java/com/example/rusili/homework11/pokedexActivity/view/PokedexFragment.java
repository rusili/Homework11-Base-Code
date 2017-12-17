package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.Adaptor.PokedexAdaptor;
import com.example.rusili.homework11.PokemonModel;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.api.PokemonApi;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
	private Retrofit retrofit;
	private RecyclerView recyclerView;
	private PokedexAdaptor pokedexAdaptor;
	private int offset;
	boolean canLoad;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view;
		view = inflater.inflate(R.layout.pokemondex_itemview, container, false);
		recyclerView = (RecyclerView) view.findViewById(R.id.pokemondex_frag_recyclerview);
		pokedexAdaptor = new PokedexAdaptor(getContext());
		final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

		//recyclerView.setAdapter(pokedexAdaptor);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(gridLayoutManager);


		final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fa_button);
		fab.setVisibility(View.GONE);


		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				recyclerView.smoothScrollToPosition(0);

			}
		});
		return null;
	}
}


//		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//			@Override
//			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//				super.onScrolled(recyclerView, dx, dy);
//
//				int visibleItemCount = gridLayoutManager.getChildCount();
//				int totalItemCount = gridLayoutManager.getItemCount();
//				int pastVisibleItems = gridLayoutManager.findFirstVisibleItemPosition();
//
//				if(dy<=0){
//					fab.setVisibility(View.GONE);
//				}
//
//				if (dy > 0) {
//
//					if (canLoad) {
//						if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
//							Log.d("pokedexfrag", "Recyclerview loading");
//
//							canLoad = false;
//							offset += 20;
//						}
//					}
//
//					fab.setVisibility(View.VISIBLE);
//
//
//				}
//
//			}
//		});
//
//
//
//		unlimitedPower();
//		return view;
//	}
//
//	private void unlimitedPower() {
//		retrofit = new Retrofit.Builder()
//				.baseUrl("http://pokeapi.co/api/v2/")
//				.addConverterFactory(GsonConverterFactory.create())
//				.build();
//
//		canLoad = false;
//		offset = 0;
//
//		//getPokemonData(offset);
//	}
//	public void pokedexCallback (Pokedex pokedex) {
//		// TODO: show Pokemon
//		// Each pokemon is in the Pokemon_Species object.
//		for (int i = 0; i < pokedex.getPokemon_entries().length; i++) {
//			PokemonEntries addn = pokedex.getPokemon_entries()[i];
//
//			pokedexAdaptor.listPokemonModel(addn);
//		}
//
////	private void getPokemonData(int offset) {
////		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
////            @Override
////            public void pokedexCallback(Pokedex pokedex) {
////				ArrayList<PokemonModel> pokemonEntries= new ArrayList<>();
//// 				PokemonModel[] entries=pokedex.getPokemon_entries();
////
//////		PokemonApi pokemonApi = retrofit.create(PokemonApi.class);
//////		//Call<PokemonData> pokemonDataCall = pokemonApi.getPokedex(7, offset);
//////		pokemonDataCall.enqueue(new Callback<PokemonData>() {
////
////				for (int i = 0; i < get.length; i++) {
////					PokemonData pokemonData = response.body();
////					ArrayList<PokemonModel> pokemonSets = pokemonData.getResults();
////
////					pokedexAdaptor.listPokemonModel(pokemonSets);
////				} else {
////					Log.e("PokedexFrag", " onResponse: " + response.errorBody());
////				}
////			}
//
////			@Override
////			public void onFailure(@NonNull Call<PokemonData> call, @NonNull Throwable t) {
////				canLoad = true;
////				Log.e("onFailure: ", t.getMessage());
////				ErrorFragment errorFragment= new ErrorFragment();
////				getFragmentManager().beginTransaction().replace(R.id.main_container, errorFragment).commit();
////
//
////                PokedexFragment pokedexFragment = new PokedexFragment();
////                FragmentManager fragmentManager = getSupportFragmentManager();
////                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                fragmentTransaction.replace(R.id.main_container, pokedexFragment);
////                fragmentTransaction.commit();
//
//			//}
//	//
//		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
//		       RetrofitFactory.getInstance().getPokedex(2);
//	}
//}
