package karl.androidcodeexposition;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;

public class TesteService extends Service {

    private Timer timer;
    private Logger logger;


    public TesteService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate(){
        timer = new Timer();
        logger = new Logger();
        timer.schedule(logger, 1000, 2000);
    }

    public int onStartComand(Intent intent, int flag, int startid){

        String name = intent.getExtras().getString("Item1");

        Log.i("item", name);

        return START_STICKY;
    }

    public void onDestroy(){
        logger.cancel();
        timer.cancel();
        super.onDestroy();
    }
}
