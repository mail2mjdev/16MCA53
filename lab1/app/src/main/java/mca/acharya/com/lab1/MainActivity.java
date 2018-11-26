package mca.acharya.com.lab1;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView txtSelect;
    String[] contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList=getResources().getStringArray(R.array.li_contact);

        txtSelect=(TextView) findViewById(R.id.textView1);
        listView=(ListView) findViewById(R.id.listView1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value=adapter.getItem(position);
                txtSelect.setText(value);
                txtSelect.setTypeface(null, Typeface.BOLD_ITALIC);
            }
        });

    }
}
