package karl.persistence;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
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


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class FileActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private String usuario;
    private String senha;
    private AutoCompleteTextView email;
    private EditText password;
    private CheckBox keepConected;
    private FileOutputStream fos;
    private FileInputStream fis;
    private String txt;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        email = (AutoCompleteTextView)  findViewById(R.id.email_file);
        password = (EditText)  findViewById(R.id.password_file);
        keepConected = (CheckBox) findViewById(R.id.cbx_keep_conected_file);
        sp = getPreferences(MODE_PRIVATE);

        try {
            fis = openFileInput("login.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            txt = br.readLine();
            fis.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(txt != null){

            String[] loginParts = txt.split("\\|");
            String l = loginParts[0];
            String p = loginParts[1];
            keepConected.setChecked(true);

            email.setText(l);
            password.setText(p);
        }
    }

    protected void login(View v){

        email = (AutoCompleteTextView)  findViewById(R.id.email_file);
        password = (EditText)  findViewById(R.id.password_file);
        keepConected = (CheckBox) findViewById(R.id.cbx_keep_conected_file);

        if(keepConected.isChecked()){

            StringBuilder dataToWrite = new StringBuilder();
            dataToWrite.append(email.getText().toString());
            dataToWrite.append("|");
            dataToWrite.append(password.getText().toString());

            try {
                fos = openFileOutput("login.txt", MODE_PRIVATE);
                fos.write(dataToWrite.toString().getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

