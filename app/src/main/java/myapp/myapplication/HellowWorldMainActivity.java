package myapp.myapplication;

import android.app.AlertDialog;
import android.inputmethodservice.ExtractEditText;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class HellowWorldMainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button start, stop;
    ExtractEditText input_text;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellow_world_main);


        start = (Button) findViewById(R.id.btn_start);
        stop = (Button) findViewById(R.id.btn_stop);
        input_text = (ExtractEditText) findViewById(R.id.ipt_name);

        chrono = (Chronometer) findViewById(R.id.chronometer);

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                chrono.start();
                chrono.setTextSize(90);

                handler.postDelayed(new Runnable() {
                    public void run() {
                        showMessage();
                    }
                }, 2000);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setTextSize(50);
                chrono.stop();
            }
        });


    }

    public void showMessage(){

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle(R.string.lbl_name);
        msg.setNeutralButton("Ok", null);
        msg.setMessage(input_text.getText().toString());
        msg.show();

    }
}
