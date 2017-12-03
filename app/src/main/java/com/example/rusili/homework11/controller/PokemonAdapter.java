package com.example.rusili.homework11.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    ArrayList<PokemonEntries> pokedexList;
    private Context context;
    private String string;

    public PokemonAdapter(Context context) {
        this.context = context;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PokemonEntries p = pokedexList.get(position);
        holder.textView.setText(p.getPokemon_species().getName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PokemonDetailActivity.class);
                intent.putExtra("pokeName" , holder.textView.getText());
                view.getContext().startActivity(intent);
            }
        });

        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" +p.getEntry_number()+ ".png")
                .into((ImageView) holder.imageView);
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
        }

        public void onBind(String name){
            textView.setText(name);
        }

        public String getText() {
            return textView.getText().toString();
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

}
