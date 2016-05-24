package karl.androidcodeexposition;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import karl.androidcodeexposition.BoundService;

public class BoundActivity extends AppCompatActivity {

    BoundService mBoundService;
    boolean mServiceBound = false;
    private TextView timestampText;
    private Button printTimestampButton;
    private Button stopServiceButon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        timestampText = (TextView) findViewById(R.id.timeStampTxt);
        printTimestampButton = (Button) findViewById(R.id.btn_print_time);
        stopServiceButon = (Button) findViewById(R.id.btn_stop_bind);
    }

    public void print(View view) {

        if (mServiceBound) {
            timestampText.setText(mBoundService.getTimestamp());
        }
    }

    public void stop(View view) {

        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
        Intent intent = new Intent(BoundActivity.this,BoundService.class);
        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };

}
