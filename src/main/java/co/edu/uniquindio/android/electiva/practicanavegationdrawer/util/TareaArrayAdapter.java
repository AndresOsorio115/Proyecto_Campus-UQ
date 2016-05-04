package co.edu.uniquindio.android.electiva.practicanavegationdrawer.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Tarea;

/**
 * Created by Andrés Osorio on 04/05/2016.
 */
public class TareaArrayAdapter<T> extends ArrayAdapter<T> {


    public TareaArrayAdapter(Context context, List<T> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater)getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View listItemView = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
            //Si no existe, entonces inflarlo con two_line_list_item.xml
            listItemView = inflater.inflate(
                    android.R.layout.two_line_list_item,
                    parent,
                    false);
        }

        //Obteniendo instancias de los text views
        TextView titulo = (TextView)listItemView.findViewById(android.R.id.text1);
        TextView telefono = (TextView)listItemView.findViewById(android.R.id.text2);

        //Obteniendo instancia de la Tarea en la posición actual
        Tarea item = (Tarea) getItem(position);

        //Dividir la cadena en Nombre y Telefono
        String cadenaBruta;
        String subCadenas [];
        String delimitador = ",";

        cadenaBruta = item.toString();
        subCadenas = cadenaBruta.split(delimitador,2);
        Log.v(cadenaBruta,"::::::::::::::::");
        titulo.setText(item.getNombre());
        telefono.setText(item.getTelefono());

        //Devolver al ListView la fila creada
        return listItemView;

    }
}
