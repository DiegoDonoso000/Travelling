package es.travelWorld.travelling.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private String nombre;
    private String apellido;


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.apellido);
    }

    public void readFromParcel(Parcel source) {
        this.nombre = source.readString();
        this.apellido = source.readString();
    }

    public Usuario() {
    }

    protected Usuario(Parcel in) {
        this.nombre = in.readString();
        this.apellido = in.readString();
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
