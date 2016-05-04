package co.edu.uniquindio.android.electiva.practicanavegationdrawer;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practicanavegationdrawer.activity.DetalleDeNoticiaActivity;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.DetalleDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.ListaDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.PaginaWebFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.fragment.SugerenciasFragment;
import co.edu.uniquindio.android.electiva.practicanavegationdrawer.vo.Noticia;

public class NavegationActivity extends AppCompatActivity implements ListaDeNoticiaFragment.OnNoticiaSeleccionadaListener {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private ListaDeNoticiaFragment listaDeNoticiaFragment;
    private ArrayList<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation);


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navview);
        navView.setItemIconTintList(null);

        remplazarFragmento(new ListaDeNoticiaFragment());
        remplazarFragmento(new SugerenciasFragment());
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_seccion_1:

                        break;
                    case R.id.menu_seccion_2:
                        remplazarFragmento(new ListaDeNoticiaFragment());
                        Log.i("NavigationView", "Pulsada seccion 2");
                        break;
                    case R.id.menu_seccion_3:
                        remplazarFragmento(new SugerenciasFragment());
                        Log.i("NavigationView", "Pulsada seccion 3");
                        break;
                    case R.id.menu_seccion_4:
                        remplazarFragmento(new PaginaWebFragment());
                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void remplazarFragmento(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
    }


    @Override
    public void onNoticiaSeleccionada(int position) {
        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia) != null;

        if (esFragmento) {
            ((DetalleDeNoticiaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia)).showDetail(new Noticia("", ""));
        } else {
            Intent intent = new Intent(this,
                    DetalleDeNoticiaActivity.class);
            intent.putExtra("noticia", new Noticia("Noticia", "3333"));
            startActivity(intent);

        }


    }
}
