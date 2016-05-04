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

        TAREAS.add(new Tarea("Andres ososrio","310677899"));
        TAREAS.add(new Tarea("Erick Vargas","321456765"));
        TAREAS.add(new Tarea("Pepito Perez","3114332345"));
        TAREAS.add(new Tarea("Rosa Maria Garcia","3227665478"));
        TAREAS.add(new Tarea("Hugo Chavez","3143240098"));
        TAREAS.add(new Tarea("Ronaldinho Gaucho","3046758767"));
        TAREAS.add(new Tarea("Oliver Atom","3145459988"));
        TAREAS.add(new Tarea("Michael Jackson","3145455788"));
        TAREAS.add(new Tarea("Julio Jose","31567803234"));
        TAREAS.add(new Tarea("Palechos Ramirez","3145459988"));
        TAREAS.add(new Tarea("Juanita Vanegas","3168973456"));

    }
}
