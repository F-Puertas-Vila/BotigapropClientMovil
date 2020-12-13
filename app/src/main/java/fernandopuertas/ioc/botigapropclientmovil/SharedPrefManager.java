package fernandopuertas.ioc.botigapropclientmovil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {

    //les constants
    private static final String SHARED_PREF_NAME = "botigaPropClientMovil";
    private static final String KEY_NOM = "nom";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ROL = "rol";
    private static final String KEY_CONTRASENYA = "contrasenya";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //metode d'acces d'usuari
    //aquest métode deixarà les dades del usuari a shared preferences
    public void userLogin(Usuari usuari) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NOM, usuari.getNom());
        editor.putString(KEY_NOM, usuari.getNom());
        editor.putString(KEY_EMAIL, usuari.getEmail());
        editor.putString(KEY_ROL, usuari.getRol());
        editor.apply();
    }

    //aquest metode comprovarà si l'usuari ha iniciat sessió a l'aplicació o no
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NOM, null) != null;
    }

    //aquest mètode retorna l'usuari que ha iniciat sessió a l'aplicació
    public Usuari getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Usuari(
                sharedPreferences.getString(KEY_ROL, null),
                sharedPreferences.getString(KEY_NOM, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_CONTRASENYA, null)
        );
    }

    //aquets metode finalitza sesió l'usuari
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}