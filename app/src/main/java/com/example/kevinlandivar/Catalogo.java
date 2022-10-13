package com.example.kevinlandivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kevinlandivar.clases.Productos;
import com.example.kevinlandivar.databinding.ActivityCatalogoBinding;
import com.example.kevinlandivar.vm.CatalogoViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {

    public static ArrayList<Productos> ventas=new ArrayList<>();

    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCatalogoBinding binding = ActivityCatalogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CatalogoViewModel viewModel=new ViewModelProvider(this).get(CatalogoViewModel.class);

        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        viewModel.listarproductos();
        ProductosAdaptador adapter= new ProductosAdaptador();

        binding.eqRecycler.setAdapter(adapter);
        viewModel.getProducto().observe(this, productList-> {
            adapter.submitList(productList);
            Productos pro=productList.get(0);
            binding.setProductos(pro);
            ArrayList<Productos> ventass=new ArrayList<>();

            int rotacion = getWindowManager().getDefaultDisplay().getRotation();

            if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
                adapter.setOnItemClickListener(product ->{
                    Toast.makeText(Catalogo.this, "Agregado: "+product.getName(), Toast.LENGTH_SHORT).show();
                    ventas.add(product);
                });

            } else {
                foto=binding.imageView;
                Picasso.get().load(pro.getAvatar()).into(foto);
                adapter.setOnItemClickListener(product ->{
                    binding.setProductos(product);
                    Picasso.get().load(product.getAvatar()).into(foto);
                });

            }
            if (productList.isEmpty()){
                binding.empyView.setVisibility(View.VISIBLE);
            }else{
                binding.empyView.setVisibility(View.GONE);
            }
        });

        binding.btncarrito.setOnClickListener(earthquake ->{
            open_activity();
        });

    }

    private void open_activity() {
        Intent intent=new Intent(this,Venta.class);
        startActivity(intent);
    }
}