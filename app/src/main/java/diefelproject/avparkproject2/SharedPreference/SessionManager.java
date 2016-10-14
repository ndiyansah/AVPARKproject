package diefelproject.avparkproject2.SharedPreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import diefelproject.avparkproject2.Form.LoginForm;

/**
 * Created by macbook on 9/12/16.
 */
public class SessionManager {
    // shared preferences //session
    SharedPreferences pref;

    // editor buat shared preferences
    SharedPreferences.Editor editor;

    // context
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // nama file sharedpref
    private static final String PREF_NAME = "AvparkUserPref";

    // key buat shared prefrence
    private static final String IS_LOGIN = "IsLoggedIn";

    // username , public
    public static final String KEY_NAME = "name";

    // email , public
    public static final String KEY_EMAIL = "email";

    // constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    // Buat Login Session
    public void createLoginSession(String name, String email){
        // set nilai login "true"
        editor.putBoolean(IS_LOGIN, true);

        // set username dari textInput store ke sharedPreference
        editor.putString(KEY_NAME, name);

        // set Username dari textInput Store ke SharedPreference
        editor.putString(KEY_EMAIL, email);

        // commit atau submit
        editor.commit();
    }

    // cek session login jika false , redirect ke login activity
    public void checkLogin(){
        // cek status login
        if(!this.isLoggedIn()){
            // cek User Login , kalo null intent ke login activity
            Intent i = new Intent(_context, LoginForm.class);

            // hapus semua activity
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // set flag buat activity baru
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }


    // simpan data sessiion ke shared pref
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // return user
        return user;
    }

    // clear atau hapus session details
    public void logoutUser(){
        // hapus semua data yg ada di shared pref
        editor.clear();
        editor.commit();

        // setelah login intent ke login
        Intent i = new Intent(_context, LoginForm.class);

        // hapus semua activity
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // set flag activity baru
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // start activity baru
        _context.startActivity(i);
    }

    // check session login
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}