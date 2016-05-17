package karl.androidcodeexposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class OlimipiadasHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olimipiadas_home);
    }

    public void bookTickest(View v){

        EditText name = (EditText) findViewById(R.id.edt_name);
        EditText age = (EditText) findViewById(R.id.edt_age);

        Spinner spn_modality =(Spinner) findViewById(R.id.spn_modality);
        String modality  = spn_modality.getSelectedItem().toString();

        RadioGroup rgTime = (RadioGroup)findViewById(R.id.rdbtn_periodo);

        String time = ((RadioButton)findViewById(rgTime.getCheckedRadioButtonId())).getText().toString();

        Intent confirmationIntent = new Intent(this, OlimipiadasConfirmationActivity.class);

        confirmationIntent.putExtra("name", name.getText().toString());
        confirmationIntent.putExtra("age", age.getText().toString());
        confirmationIntent.putExtra("modality", modality.toString());
        confirmationIntent.putExtra("time", time.toString());
        startActivity(confirmationIntent);
    }
}
