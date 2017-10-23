package id.refactory.app.refactoryapps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by prana on 18/10/17.
 */

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    public static final String MY_PREFS_NAME = "TokenPrefs";
    public static final String KEY_NAME = "Token";
    public static final String EXPIRED = "ExpireIN";
    public static final String REFRESH = "Refresh Token";
    public static final String TOKEN_TYPE = "Token Type";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(MY_PREFS_NAME, 0);
        editor = pref.edit();
    }

    public void createLogin(String token, Integer expireIn, String refreshToken, String typeToken) {
        Log.d("yeh", "onResponse: " + token);
        editor.putBoolean("login", true);
        editor.putString(KEY_NAME, token);
        editor.putInt(EXPIRED, expireIn);
        editor.putString(REFRESH, refreshToken);
        editor.putString(TOKEN_TYPE, typeToken);
        editor.commit();
    }

    public HashMap<String, String> getTokenDetails() {
        HashMap<String, String> token = new HashMap<String, String>();
        token.put(KEY_NAME, pref.getString(KEY_NAME, null));
        return token;
    }

    public void logout() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, GitLogin.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public void checkLogin() {
        if (!this.loggedIn()) {
            Intent i = new Intent(context, GitLogin.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }

    public boolean loggedIn() {
        return pref.getBoolean("login", false);
    }
}