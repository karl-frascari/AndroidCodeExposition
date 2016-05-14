package karl.androidcodeexposition;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Config;

public class FragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragments);

        Configuration config = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LandscapeFragment ls_fragment = new LandscapeFragment();
            fragmentTransaction.replace(android.R.id.content, ls_fragment);
        }else{
            PortraitFragment pm_fragment = new PortraitFragment();
            fragmentTransaction.replace(android.R.id.content, pm_fragment);
        }

        fragmentTransaction.commit();
    }
}
