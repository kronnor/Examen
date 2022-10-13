package com.example.kevinlandivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.kevinlandivar.clases.Usuarios;
import com.example.kevinlandivar.databinding.ActivityMainBinding;
import com.example.kevinlandivar.vm.MainViewModel;

public class MainActivity extends AppCompatActivity {

    public static Usuarios usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel=new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.listarusuarios();

        binding.btnIngreso.setOnClickListener(ingreso->{


            for (int i = 0; i < viewModel.getUsers().getValue().size(); i++) {

                if (viewModel.getUsers().getValue().get(i).getFirst_name().equalsIgnoreCase(binding.txtUsuario.getText().toString())){
                    usuario = viewModel.getUsers().getValue().get(i);
                    open_activity();
                }

            }


        });

    }
    private void open_activity() {
        Intent intent=new Intent(this,Bienvenida.class);
        startActivity(intent);
    }
}