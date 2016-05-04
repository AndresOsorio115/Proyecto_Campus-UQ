package co.edu.uniquindio.android.electiva.practicanavegationdrawer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.R;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.DetalleDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Noticia;

public class DetalleDeNoticiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_noticia);

                DetalleDeNoticiaFragment detalleDeNoticia  = (DetalleDeNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);
        Noticia film = (Noticia) getIntent().getExtras().getParcelable("noticia");
        detalleDeNoticia.showDetail(film);

    }
}
