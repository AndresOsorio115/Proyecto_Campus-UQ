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
 * Esta clase contiene el fragmento diseñado para las sugerencias
 * Implementando el adaptador para las noticias.
 */
public class SugerenciasFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia {


    private ListaDeNoticiaFragment.OnNoticiaSeleccionadaListener listener;

    /**
     * Constructor de la clase por defectos sin parametros
     */
    public SugerenciasFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo encargado de manejar el estado onCreate del fragmento
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        }

    /**
     * Metodo encargado de cargar la vista en el contendor que
     * entra por parametro
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugerencia, container, false);
    }

    /**
     * Metodo encargado de obtener el listener a partir del fragmento
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
    
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    @Override
    public void onClickPosition(int pos) {
        listener.onNoticiaSeleccionada(pos);
    }

/**
 * Metodo encargado de retornar la interface de la pelicula seleccionada, dada la posicion
 */

public interface OnNoticiaSeleccionadaListener {

    void onNoticiaSeleccionada(int position);
}
}
