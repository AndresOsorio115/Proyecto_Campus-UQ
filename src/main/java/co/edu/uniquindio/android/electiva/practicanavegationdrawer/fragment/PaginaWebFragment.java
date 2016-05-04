package co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.util.AdaptadorNoticia;

/**
 * Esta clase contiene el fragmento que redirecionara la aplicacion al portal de la universidad
 */
public class PaginaWebFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia {


    private ListaDeNoticiaFragment.OnNoticiaSeleccionadaListener listener;

    /**
     * Constructor de la clase por defecto sin parametros
     */
    public PaginaWebFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo encargado de manejar el estado create del fragmento
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * Metodo encargado de crear la vista en el contenedor indicado por parametro
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagina_web, container, false);
    }

    /**
     * El metodo onAttach es el encargado de integrar la activity con el fragmento
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if(context instanceof Activity){
            activity = (Activity) context;
            Log.v("HJK",activity.getClass().getSimpleName());
            try {
                listener= (ListaDeNoticiaFragment.OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPeliculaSeleccionadaListener");
            }
        }
    }

    /**
     * Metodo que formatea a null el listener del evento
     */
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    /**
     * Con este metodo capturamos la posicion para saber que notica fue la selecionada
     * en la lista de las noticias.
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onNoticiaSeleccionada(pos);
    }

    /**
     * Listener de las noticas para obtener el evento que se presento
     */
    public interface OnNoticiaSeleccionadaListener {

        void onNoticiaSeleccionada(int position);
    }
}
