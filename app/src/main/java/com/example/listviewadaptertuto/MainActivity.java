package com.example.listviewadaptertuto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView list_item_text;
    String[] listItem;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        list_item_text = findViewById(R.id.item_text);
        listItem = getResources().getStringArray(R.array.programming);

        adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item,
                R.id.item_text,
                listItem
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),position+","+value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
