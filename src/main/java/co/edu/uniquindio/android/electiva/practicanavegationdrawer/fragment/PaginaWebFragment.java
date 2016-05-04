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



public class PaginaWebFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia {


    private ListaDeNoticiaFragment.OnNoticiaSeleccionadaListener listener;


    public PaginaWebFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagina_web, container, false);
    }


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

    public interface OnNoticiaSeleccionadaListener {

        void onNoticiaSeleccionada(int position);
    }
}
