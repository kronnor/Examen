package com.example.kevinlandivar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.kevinlandivar.databinding.ActivityBienvenidaBinding;
import com.squareup.picasso.Picasso;

public class Bienvenida extends AppCompatActivity {
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBienvenidaBinding binding = ActivityBienvenidaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setUsuarios(MainActivity.usuario);

        foto=binding.avatar;
        Picasso.get().load(MainActivity.usuario.getAvatar()).into(foto);

        binding.btnLista.setOnClickListener(lista->{
            open_activity();
        });
    }

    private void open_activity() {
        Intent intent=new Intent(this, Catalogo.class);
        startActivity(intent);
    }
}