package com.example.kevinlandivar.clases;

import java.util.List;

public class Responseproducto {
    private boolean status;
    private List<Productos> objects;

    public Responseproducto() {
    }

    public Responseproducto(boolean status, List<Productos> objects) {
        this.status = status;
        this.objects = objects;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Productos> getObjects() {
        return objects;
    }

    public void setObjects(List<Productos> objects) {
        this.objects = objects;
    }
}
