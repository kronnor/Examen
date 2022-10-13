package com.example.kevinlandivar;

import com.example.kevinlandivar.clases.Responseproducto;
import com.example.kevinlandivar.clases.Responseusuarios;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("products.json")
    public Call<Responseproducto> getProductos();

    @GET("users.json")
    public Call<Responseusuarios> getUsuarios();
}
