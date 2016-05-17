package karl.androidcodeexposition;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OlimipiadasConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olimipiadas_confirmation);

        // Obtém o Bundle
        Bundle param = getIntent().getExtras();

        // Obtém os valores associados ao Bundle
        String name = param.getString ("name");
        String age = param.getString ("age");
        String modality = param.getString ("modality");
        String time = param.getString ("time");

        TextView txtName = (TextView) findViewById(R.id.txt_name);
        txtName.setText(name);

        TextView txtAge = (TextView) findViewById(R.id.txt_age);
        txtAge.setText(age);

        TextView txtModality = (TextView) findViewById(R.id.txt_modality);
        txtModality.setText(modality);

        TextView txtTime = (TextView) findViewById(R.id.txt_time);
        txtTime.setText(time);
    }

    public void confirm(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Confirmado");
        alertDialogBuilder.show();
    }
}
