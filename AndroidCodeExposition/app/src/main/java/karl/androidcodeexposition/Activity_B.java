package karl.androidcodeexposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity_B extends AppCompatActivity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("Test", "Testing");
        super.onCreate(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__b);

        if(savedInstanceState != null){
            Log.i("State", savedInstanceState.getString("Test"));
        }
    }

    public void next (View v){
        Intent intent = new Intent(this, Activity_C.class);
        startActivity(intent);
        finish();
    }
}
