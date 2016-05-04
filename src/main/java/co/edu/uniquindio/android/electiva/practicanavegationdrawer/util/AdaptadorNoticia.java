package co.edu.uniquindio.android.electiva.practicanavegationdrawer.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.ListaDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Noticia;

/**
 * Created by Andrés Osorio on 30/04/2016.
 */
public class AdaptadorNoticia extends RecyclerView.Adapter<AdaptadorNoticia.NoticiaViewHolder>{

    private ArrayList<Noticia> noticias;

    private static OnClickAdaptadorNoticia listener;

    /**
     * Constructor de la clase
     * @param noticias
     * @param listaDeNoticiaFragment
     */
    public AdaptadorNoticia(ArrayList<Noticia>noticias, ListaDeNoticiaFragment listaDeNoticiaFragment) {
        this.noticias= noticias;
        listener= (OnClickAdaptadorNoticia) listaDeNoticiaFragment;
    }

    /**
     * Metodo encargado de cargar la vista
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_de_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        Noticia noticia = noticias.get(position);
        holder.binNoticia(noticia);

    }

    /**
     * Este metodo se encarga de obtener el tamanio de la lista de peliculas
     * @return
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class NoticiaViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTitulo;
        private TextView txtDescripcion;
        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            txtDescripcion = (TextView) itemView.findViewById(R.id.descripcion_de_detalle_pelicula);

        }
        public void binNoticia(Noticia p) {
            txtTitulo.setText(p.getTitulo());
            txtDescripcion.setText(p.getDescripcion());
        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+txtTitulo.getText());

        }
    }

    public interface OnClickAdaptadorNoticia{
        public void onClickPosition(int pos);
    }
}
