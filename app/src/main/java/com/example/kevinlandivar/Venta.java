package com.example.kevinlandivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.kevinlandivar.databinding.ActivityVentaBinding;

public class Venta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVentaBinding binding = ActivityVentaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        VentaAdaptador adapter= new VentaAdaptador();
        binding.eqRecycler.setAdapter(adapter);
        adapter.submitList(Catalogo.ventas);

        double totalventa=0;

        for (int i = 0; i < Catalogo.ventas.size(); i++) {
            totalventa=totalventa+Double.parseDouble(Catalogo.ventas.get(i).getPrice());
        }

        binding.txtCostoTotal.setText(""+totalventa);

    }
}