package co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrés Osorio on 30/04/2016.
 */
public class Noticia implements Parcelable{
    /**
     * Declaracion de los atributos de la pelicula
     */
    private String titulo;
    private String descripcion;

    /**
     * Constructor de la clase
     * @param titulo
     */


    public Noticia(String titulo) {
        this.titulo = titulo;

    }

    /**
     * Constructor de la clase
     * @param titulo
     * @param descripcion
     */
    public Noticia(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;

    }

    /**
     * Constructor de la clase
     * @param in
     */
    protected Noticia(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
    }

    public static final Parcelable.Creator<Noticia> CREATOR = new Parcelable.Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
    }


    public void readFromParcel(Parcel in) {
        titulo=in.readString();
        descripcion=in.readString();
    }
}
