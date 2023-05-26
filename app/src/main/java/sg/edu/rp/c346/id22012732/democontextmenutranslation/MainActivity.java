package sg.edu.rp.c346.id22012732.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        tvTranslatedText.setText("Hello");
        tvTranslatedText2.setText("Goodbye");// Replace R.id.tvTranslatedText with the actual ID of your TextView
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");
        if(v == tvTranslatedText) {
            wordClicked = "hello";
        }
        else if(v == tvTranslatedText2) {
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            // code for action
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            if (wordClicked.equals("hello")) {
                tvTranslatedText.setText("Hello");
            } else if (wordClicked.equals("bye")) {
                tvTranslatedText2.setText("Goodbye");
            }

            return true;
        } else if (item.getItemId() == 1) {
            Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
            if (wordClicked.equals("hello")) {
                tvTranslatedText.setText("Ciao");
            } else if (wordClicked.equals("bye")) {
                tvTranslatedText2.setText("Addio");
            }

            return true;
        }
        return super.onContextItemSelected(item);
    }


}
