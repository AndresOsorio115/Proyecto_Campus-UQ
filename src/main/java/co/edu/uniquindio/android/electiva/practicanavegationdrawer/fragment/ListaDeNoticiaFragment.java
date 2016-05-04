package co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment;

import android.app.Activity;
import android.content.Context;
import android.media.audiofx.NoiseSuppressor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.util.AdaptadorNoticia;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Noticia;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaDeNoticiaFragment.OnNoticiaSeleccionadaListener} interface
 * to handle interaction events.

 */
public class ListaDeNoticiaFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia{

    private RecyclerView listadoDeNoticias ;

    private ArrayList<Noticia> noticias;

    private AdaptadorNoticia adaptador;

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    private OnNoticiaSeleccionadaListener listener;
    
    /**
     * Constructor de la clase por defecto sin parametros
     */
    public ListaDeNoticiaFragment() {
        // Required empty public constructor
    }

    public ArrayList<Noticia> getPeliculas() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    /**
     * Metodo oncreate del fragmento, encargado de manejar el estado create del fragmento.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * En este metodo nos encargamos de cargas al array con las instancias de las peliculas
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        noticias = new ArrayList();
        noticias.add(new Noticia("Egresados aportan a la Alta Calidad en Ingeniería Electrónica", "Noticias"));
        noticias.add(new Noticia("Uniquindianos podrán cursar maestría en Inaoe, México", "Noticias"));
        noticias.add(new Noticia("Un espacio académico desde la Física para la comunidad", "Noticias"));
        noticias.add(new Noticia("Máquina de Ingenio Abril 22 de 2016", "Noticias"));

        listadoDeNoticias= (RecyclerView) getView().findViewById(R.id.RecView);

        adaptador = new AdaptadorNoticia(noticias,this);

        listadoDeNoticias.setAdapter(adaptador);
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * Este metodo se encarga de crear la vista para el fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_noticia, container, false);
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
                listener= (OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPeliculaSeleccionadaListener");
            }
        }

    }

    /**
     * Metodo encargado de los items pertenecientes al menu pasado opr parametro
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * Este metodo es el encargado de validar la seleccion de un item
     * @param item
     * @return
     */


    /**
     * Metodo encargado de manejar el click dada la posicion
     * @param pos
     */
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
