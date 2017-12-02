package com.example.rusili.homework11.controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    ArrayList<PokemonEntries> pokedexList;

    public PokemonAdapter() {
        this.pokedexList = new ArrayList<>();
    }

    public void addPokemonList(List<PokemonEntries> pokemonList) {
        this.pokedexList.addAll(pokemonList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PokemonEntries p = pokedexList.get(position);
        holder.onBind(p.getPokemon_species().getName());
    }

    @Override
    public int getItemCount() {
        return pokedexList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageButton imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.poke_name);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), PokemonDetailActivity.class);
                    intent.putExtra("pokeName" , textView.getText().toString());
                    startActivity(intent);
                }
            });
        }

        public void onBind(String name){
            textView.setText(name);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    private void startActivity(Intent intent) {
        startActivity(intent);
    }
}
