package com.example.rusili.homework11.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rusili.homework11.R;

import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;

import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 11/29/17.
 */

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {


    private List<PokemonEntries> pokemonEntriesList;
    private Context context;


    public PokedexAdapter(List<PokemonEntries> pokemonEntriesList, Context context) {
        this.pokemonEntriesList = pokemonEntriesList;
        this.context=context;
    }


    @Override
    public PokedexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_itemview, parent, false);
        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PokedexViewHolder holder, int position) {
        PokemonEntries pokemonEntries = pokemonEntriesList.get(position);
        final String pokemonName= pokemonEntries.getPokemon_species().getName();
        holder.pokedexText.setText(pokemonName);

//        RetrofitFactory.getInstance().setPokemonNetworkListener(new RetrofitFactory.PokemonNetworkListener() {
//            @Override
//            public void pokemonCallback(Pokemon pokemon) {
//                System.out.println(pokemonName + " " + pokemon.getSprites().getBack_default());
//
//                Glide.with(context)
//                        .load(pokemon.getSprites().getBack_default())
//                        .into(holder.image);
//            }
//        });
//        RetrofitFactory.getInstance().getPokemon(pokemonName);

        //Onclick listener
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), holder.email.getText(), Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(view.getContext(), PokemonDetailActivity.class);
                intent.putExtra("pokemon", holder.pokedexText.getText());
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pokemonEntriesList.size();
    }

    public class PokedexViewHolder extends RecyclerView.ViewHolder {

         ImageView pokedexView;
         TextView pokedexText;
        CardView layout;
        ImageView image;

        public PokedexViewHolder(View itemView) {
            super(itemView);

            //pokedexView = (ImageView) itemView.findViewById(R.id.pokedex_imageview);
            pokedexText = (TextView) itemView.findViewById(R.id.pokedex_textview);
            layout= (CardView) itemView.findViewById(R.id.idLayout);
            image = (ImageView) itemView.findViewById(R.id.pokedex_imageview);
        }
    }
}
