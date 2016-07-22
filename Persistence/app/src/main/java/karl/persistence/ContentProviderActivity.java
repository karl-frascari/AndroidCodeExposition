package karl.persistence;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ContentProviderActivity extends AppCompatActivity {

    private ContentResolver cr;
    private Cursor cursor;
    private boolean allowedToRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        cr = getContentResolver();
        cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    }


    public void readMyContats(View v){

        allowedToRead = true;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            } while (cursor.moveToNext() && allowedToRead);
        }
        cursor.close();
    }

    public void stopReading(View v){
        cursor.moveToLast();
        cursor.close();
        allowedToRead = false;
    }
}
