package karl.androidcodeexposition;

import android.util.Log;

import java.util.TimerTask;

public class Logger extends TimerTask {

    private long cont = 0;

    public void Logger() {

        Log.i("Logger", "Logger iniciando");

    }

    @Override
    public void run() {
        cont++;
        Log.i("Logger", "Logger" + cont);

    }
}
