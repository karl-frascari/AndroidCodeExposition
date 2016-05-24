package karl.androidcodeexposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;

public class ServiceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

    }

    public void startService(View v){
        Intent intent = new Intent(this, TesteService.class);
        intent.putExtra("item1", "Item");
        startService(intent);
    }

    public void stopService(View v){
        Intent intent = new Intent(this, TesteService.class);
        stopService(intent);
    }
}
