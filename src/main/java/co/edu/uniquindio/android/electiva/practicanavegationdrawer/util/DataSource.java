package co.edu.uniquindio.android.electiva.practicanavegationdrawer.util;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Tarea;

/**
 * Created by Andrés Osorio on 04/05/2016.
 */
public class DataSource {


    public static List<Tarea> TAREAS =new ArrayList<Tarea>();

    static{

        TAREAS.add(new Tarea("Trotar 30 minutos","08:00"));
        TAREAS.add(new Tarea("Estudiar análisis técnico","10:00"));
        TAREAS.add(new Tarea("Comer 4 rebanadas de manzana","10:30"));
        TAREAS.add(new Tarea("Asistir al taller de programación gráfica","15:45"));
        TAREAS.add(new Tarea("Consignarle a Marta","18:00"));

    }
}
