package karl.persistence;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private String usuario;
    private String senha;
    private AutoCompleteTextView email;
    private EditText password;
    private CheckBox keepConected;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (AutoCompleteTextView)  findViewById(R.id.email);
        password = (EditText)  findViewById(R.id.password);
        sp = getPreferences(MODE_PRIVATE);

        usuario = sp.getString("sp_usuario", null);
        senha = sp.getString("sp_senha", null);

        if(usuario != null){
            email.setText(usuario);
            password.setText(senha);
        }
    }

    protected void login(View v){

        email = (AutoCompleteTextView)  findViewById(R.id.email);
        password = (EditText)  findViewById(R.id.password);
        keepConected = (CheckBox) findViewById(R.id.cbx_keep_conected);

        if(keepConected.isChecked()){
            SharedPreferences sp = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor e = sp.edit();
            e.putString("sp_usuario", email.getText().toString());
            e.putString("sp_senha", password.getText().toString());
            e.commit();
        }
    }
}

