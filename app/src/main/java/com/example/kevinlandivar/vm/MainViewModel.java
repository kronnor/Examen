package com.example.kevinlandivar.vm;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kevinlandivar.Api;
import com.example.kevinlandivar.clases.Responseusuarios;
import com.example.kevinlandivar.clases.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {

    private static MutableLiveData<List<Usuarios>> user_list = new MutableLiveData<>();

    public LiveData<List<Usuarios>> getUsers() {
        return user_list;
    }

    public void listarusuarios(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://fipo.equisd.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api service=retrofit.create(Api.class);
        Call<Responseusuarios> call= service.getUsuarios();
        call.enqueue(new Callback<Responseusuarios>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Responseusuarios> call, Response<Responseusuarios> response) {
                if (!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }
                Responseusuarios rp= response.body();
                user_list.setValue(rp.getObjects());
            }
            @Override
            public void onFailure(Call<Responseusuarios> call, Throwable t) {  System.out.println("Fallo");
                System.out.println(t.getMessage());
            }
        });
    }
}
