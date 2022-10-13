package com.example.kevinlandivar.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Usuarios implements Parcelable{

    private int id;
    private String first_name;
    private String last_name;
    private String avatar;
    private String created_at;
    private String updated_at;

    public Usuarios() {
    }

    public Usuarios(int id, String first_name, String last_name, String avatar, String created_at, String updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    protected Usuarios(Parcel in) {
        id = in.readInt();
        first_name = in.readString();
        last_name = in.readString();
        avatar = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }

    public static final Creator<Usuarios> CREATOR = new Creator<Usuarios>() {
        @Override
        public Usuarios createFromParcel(Parcel in) {
            return new Usuarios(in);
        }

        @Override
        public Usuarios[] newArray(int size) {
            return new Usuarios[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuarios)) return false;
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id && Objects.equals(first_name, usuarios.first_name) && Objects.equals(last_name, usuarios.last_name) && Objects.equals(avatar, usuarios.avatar) && Objects.equals(created_at, usuarios.created_at) && Objects.equals(updated_at, usuarios.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, avatar, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(avatar);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
    }
}
