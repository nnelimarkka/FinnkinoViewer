package my.app.finnkinoviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private  XmlReader xml = null;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Kinos));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        xml = XmlReader.getXmlReader();
        xml.readAreasXml();
        context = MainActivity.this;
        Toast.makeText(context, "mitä kuuluu", Toast.LENGTH_LONG);
    }

    public void buttonAction(View v) {
        String name;
        int id;
        name = spinner.getSelectedItem().toString();
        id = Theatres.getTheatreId(name);
        Toast toast = Toast.makeText(context, "ID: "+Integer.toString(id), Toast.LENGTH_SHORT);
        toast.show();
    }
}
