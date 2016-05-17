package karl.androidcodeexposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProcessLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Obtém o Bundle
        Bundle param = getIntent().getExtras();

        // Obtém os valores associados ao Bundle
        String login = param.getString ("login");
        String senha = param.getString ("password");

        finish(login.equals("usuario") && senha.equals("1234"));
    }

    public void finish(Boolean result){
        //Cria o Intent de retorno
        Intent ret = new Intent();
        ret.putExtra("Response", result.toString());

        //Indica que a execução foi OK
        setResult(RESULT_OK, ret);
        super.finish();
    }

}
