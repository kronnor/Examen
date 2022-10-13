package com.example.kevinlandivar;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kevinlandivar.clases.Productos;
import com.example.kevinlandivar.databinding.ProductoRecyclerBinding;

import java.util.Objects;

public  class ProductosAdaptador extends ListAdapter<Productos,ProductosAdaptador.EqViewHolder> {

    public static final DiffUtil.ItemCallback<Productos> DIF_CALLBACK = new DiffUtil.ItemCallback<Productos>() {
        @Override
        public boolean areItemsTheSame(@NonNull Productos oldItem, @NonNull Productos newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Productos oldItem, @NonNull Productos newItem) {
            return oldItem.equals(newItem);
        }
    };

    public ProductosAdaptador() {
        super(DIF_CALLBACK);
    }

    public OnItemClickListener onItemClickListener;

    interface OnItemClickListener{
        void onItemClick(Productos producto);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductoRecyclerBinding binding= ProductoRecyclerBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new EqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EqViewHolder holder, int position) {
        Productos producto = getItem(position);
        holder.bind(producto);
    }

    public class EqViewHolder extends RecyclerView.ViewHolder {
        private ProductoRecyclerBinding binding;
        public EqViewHolder(@NonNull ProductoRecyclerBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Productos product) {
            binding.setProduct(product);
            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(product);
            });
            binding.executePendingBindings();
        }

    }

}
