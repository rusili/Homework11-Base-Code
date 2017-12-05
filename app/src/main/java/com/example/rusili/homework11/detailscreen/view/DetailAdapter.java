package com.example.rusili.homework11.detailscreen.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;

import java.util.ArrayList;

/**
 * Created by MarckemX on 12/3/17.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {
    private ArrayList<String>statList ;

    public void thisPokeStats(Pokemon pokemon){

        for(int i =0; i < pokemon.getStats().length;i++){
            String strStat = pokemon.getStats()[i].getStat().getName().toUpperCase() + " " +
                    pokemon.getStats()[i].getBase_stat();
            statList.add(strStat);
        }

    }


    public DetailAdapter(Pokemon pokemon){
        statList = new ArrayList<>();
        thisPokeStats(pokemon);
    }
    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_view, parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position){
        holder.onBind(statList.get(position));
    }

    @Override
    public int getItemCount() {
        return statList.size();
    }
}
