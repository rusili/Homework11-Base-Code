package com.example.rusili.homework11.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rusili.homework11.PokemonModel;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikunjan on 12/12/17.
 */

public class PokedexAdaptor extends RecyclerView.Adapter<PokedexAdaptor.PokedexViewHolder> {

   
    private PokemonModel pokemonModel;
    private ArrayList<PokemonModel> poksets;
    private Context context;

    public PokedexAdaptor   (Context c){
        context=c;

        poksets= new ArrayList<>();
       

    }

    @Override
    public PokedexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view_layout,parent,false);


        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PokedexViewHolder holder, int position) {
              pokemonModel= poksets.get(position);
        holder.pokemondexText.setText(pokemonModel.getName());
          holder.layoutView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(view.getContext(), PokemonDetailActivity.class);
                  intent.putExtra("pokemon", holder.pokemondexText.getText());
                  intent.putExtra("url", "http://pokeapi.co/media/sprites/pokemon/" + pokemonModel.getNum() + ".png");
                  view.getContext().startActivity(intent);
              }
          });

        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + pokemonModel.getNum() + ".png") 
               // .apply(new RequestOptions().placeholder())
        
                .into(holder.pokemondexImageView) ;
    }

    @Override
    public int getItemCount() {
        return poksets.size();
    }
    public  void  listPokemonModel(PokemonEntries pokemonModels){
        poksets.addAll((Collection<? extends PokemonModel>) pokemonModels);
        notifyDataSetChanged();

    }

    public class PokedexViewHolder extends RecyclerView.ViewHolder {
        TextView pokemondexText;
        ImageView pokemondexImageView;
        CardView layoutView;

        public PokedexViewHolder(View itemView) {
            super(itemView);
            pokemondexImageView =(ImageView) itemView.findViewById(R.id.pokemon_ImageView);
            pokemondexText= (TextView) itemView.findViewById(R.id.pokemondex_textview);
            layoutView= (CardView) itemView.findViewById(R.id.cardLayout);
        }
    }
}
