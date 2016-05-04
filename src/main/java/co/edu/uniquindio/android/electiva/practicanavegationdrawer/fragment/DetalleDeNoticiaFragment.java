package co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Noticia;

/**
 * Clase con la que se genera el fragmento correspondiente al detalle de la noticia
 */
public class DetalleDeNoticiaFragment  extends Fragment {

    private TextView titulo;

    private Noticia noticia;

    /**
     * Constructor por defecto sin parametros
     */
    public DetalleDeNoticiaFragment() {
        // Required empty public constructor
    }

    /**
     * Este metodo es el que retorna la vista del fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_noticia, container, false);
    }

    /**
     * Este metodo es el encargado de obtener el detalle de la pelicula
     * @param noticia
     */
    public void showDetail(Noticia noticia) {
        this.noticia= noticia;
        noticia.getTitulo();
        titulo = (TextView) getView().findViewById(R.id.titulo_de_detalle_noticia);
        titulo.setText(noticia.getTitulo());

    }
}
