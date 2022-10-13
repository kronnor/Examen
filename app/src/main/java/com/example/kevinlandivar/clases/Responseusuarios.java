package com.example.kevinlandivar.clases;

import java.util.List;

public class Responseusuarios {
    private boolean status;
    private List<Usuarios> objects;

    public Responseusuarios() {
    }

    public Responseusuarios(boolean status, List<Usuarios> objects) {
        this.status = status;
        this.objects = objects;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Usuarios> getObjects() {
        return objects;
    }

    public void setObjects(List<Usuarios> objects) {
        this.objects = objects;
    }
}
