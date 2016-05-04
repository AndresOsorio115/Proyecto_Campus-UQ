package co.edu.uniquindio.android.electiva.practicanavegationdrawer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.DetalleDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Noticia;

/**
 * Esta clase representa la activity para el detalle de las peliculas
 * La clase hereda de la AppCombatActivity
 */
public class DetalleDeNoticiaActivity extends AppCompatActivity {

    /**
     * El metodo onCreate se encarga de crear el fragmento detalleNoticia utilizando parcelabel 
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_noticia);

                DetalleDeNoticiaFragment detalleDeNoticia  = (DetalleDeNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);
        Noticia film = (Noticia) getIntent().getExtras().getParcelable("noticia");
        detalleDeNoticia.showDetail(film);

    }
}
