package co.edu.uniquindio.android.electiva.practicanavegationdrawer.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.Locale;

/**
 * Created by Erick on 20/04/2016.
 */
public class Utilidades {

    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String LENGUAJE_EN = "en";

    /**
     * Este metodo es el encargado de cambiar el idioma de la aplicacion
     */
    public static void cambiarIdioma(Context context){

        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);

        if(language.equals(LENGUAJE_ES)){
            language = LENGUAJE_EN;
        }
        else if(language.equals(LENGUAJE_EN)){
            language = LENGUAJE_ES;
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();

        obtenerLenguaje(context);
    }

    public static void obtenerLenguaje(Context context){

        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS,context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);

        Log.v(Utilidades.class.getSimpleName(),"el idioma es "+language);

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }


}
