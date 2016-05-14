package karl.androidcodeexposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_C extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__c);
    }

    public void finishActitivity (View v){
        Intent intent = new Intent(this, Activity_B.class);
        startActivity(intent);
        finish();
    }
}
