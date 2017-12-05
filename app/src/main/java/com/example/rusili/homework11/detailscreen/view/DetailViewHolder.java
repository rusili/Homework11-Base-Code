package com.example.rusili.homework11.detailscreen.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;

/**
 * Created by MarckemX on 12/3/17.
 */

public class DetailViewHolder extends RecyclerView.ViewHolder {

    TextView statName = itemView.findViewById(R.id.stat_name);
    ProgressBar statValue = itemView.findViewById(R.id.stat_value);
    String statStr;
    int statValueNum;

    public DetailViewHolder(View itemView) {
        super(itemView);
    }

    public void onBind(String pokemonString){
        splitStatString(pokemonString);
        statName.setText(statStr);
        statValue.setProgress(statValueNum);
    }

    public void splitStatString(String string){
        String[] hold = string.split(" ");
        statStr = hold[0];
        statValueNum = Integer.parseInt(hold[1]);
    }
}
