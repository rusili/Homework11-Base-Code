package com.example.rusili.homework11;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by c4q on 12/1/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokeViewHolder> {
    private List<PokemonEntries> pokemonEntriesList;

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type;
        private CardView cardView;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            type = (TextView) itemView.findViewById(R.id.tv_type);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }

        public void onBind(final PokemonEntries pokemonEntries) {

        }
    }

    public PokemonAdapter(List<PokemonEntries> pokemonEntriesList) {
        this.pokemonEntriesList = pokemonEntriesList;
    }

    @Override
    public PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.pokemon_row, parent, false);

        return new PokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PokeViewHolder holder, int position) {

        final PokemonEntries pokemonEntries = pokemonEntriesList.get(position);
        holder.name.setText(pokemonEntries.getPokemon_species().getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PokemonDetailActivity.class);
                intent.putExtra("Pokemon", holder.name.getText());
                view.getContext().startActivity(intent);

                holder.onBind(pokemonEntries);



            }
        });

    }

    @Override
    public int getItemCount() {
        return pokemonEntriesList.size();
    }
}
