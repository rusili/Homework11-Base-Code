package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import org.w3c.dom.Text;

/**
 * Created by TatianaM on 11/30/17.
 */

public class PokedexViewHolder extends ViewHolder {

    TextView name;



    public PokedexViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.pokedex_name);

    }


    public void onBind(PokemonEntries pokedex) {
      name.setText(pokedex.getPokemon_species().getName());
    }
}
