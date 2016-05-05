package co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo;

/**
 * Con esta clase se crearan las instancias de las tareas.
 * Created by Andrés Osorio on 04/05/2016.
 */
public class Tarea {
    private String nombre;
    private String telefono;

    /**
     * Constructor de la clase por defecto sin parametros.
     */
    public Tarea(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Set del atributo nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Set del atributo telefono
     */
    public void setTelefono(String telefono){
        this.telefono = telefono;}

    /**
     * Get del atributo nombre
     */
    public String getNombre(){return nombre;}
    
    /**
     * Get del atributo telefono
     */
    public String getTelefono(){return telefono;}
}
