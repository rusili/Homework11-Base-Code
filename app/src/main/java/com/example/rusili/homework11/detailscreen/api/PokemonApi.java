package com.example.rusili.homework11.detailscreen.api;

 import com.example.rusili.homework11.detailscreen.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rusi.li on 11/20/17.
 */

public interface PokemonApi {

    @GET("pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String pokemonName);
}