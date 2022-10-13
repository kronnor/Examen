package com.example.kevinlandivar.vm;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kevinlandivar.Api;
import com.example.kevinlandivar.clases.Productos;
import com.example.kevinlandivar.clases.Responseproducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatalogoViewModel extends ViewModel {

    private static MutableLiveData<List<Productos>> producto_list = new MutableLiveData<>();

    public LiveData<List<Productos>> getProducto() {
        return producto_list;
    }

    public void listarproductos(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://fipo.equisd.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api service=retrofit.create(Api.class);
        Call<Responseproducto> call= service.getProductos();
        call.enqueue(new Callback<Responseproducto>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Responseproducto> call, Response<Responseproducto> response) {
                if (!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }

                Responseproducto rp= response.body();
                producto_list.setValue(rp.getObjects());
            }

            @Override
            public void onFailure(Call<Responseproducto> call, Throwable t) {
                System.out.println("Fallo");
                System.out.println(t.getMessage());
            }
        });
    }
}
