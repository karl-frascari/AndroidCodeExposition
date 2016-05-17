package karl.androidcodeexposition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected void login(View v){

        AutoCompleteTextView email = (AutoCompleteTextView)  findViewById(R.id.email);
        EditText password = (EditText)  findViewById(R.id.password);

        Intent intent = new Intent(this, ProcessLoginActivity.class);

        intent.putExtra("login", email.getText().toString());
        intent.putExtra("password", password.getText().toString());

        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Verifica que a execução foi OK
        if(resultCode == RESULT_OK && requestCode == 1) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            if (data.getExtras().getString("Response").equals("true")) {
                Intent intent = new Intent(this, OlimipiadasHomeActivity.class);
                startActivity(intent);
            } else {
                alertDialogBuilder.setMessage("Wrong password");
            }

            alertDialogBuilder.show();
        }
    }
}

