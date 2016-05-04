package co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo;

/**
 * Created by Andrés Osorio on 04/05/2016.
 */
public class Tarea {
    private String nombre;
    private String telefono;

    public Tarea(String nombre, String telefono){

        this.nombre = nombre;
        this.telefono = telefono;

    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;}

    public String getNombre(){return nombre;}
    public String getTelefono(){return telefono;}
}
