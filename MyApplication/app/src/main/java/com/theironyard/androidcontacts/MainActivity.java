package com.theironyard.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    //Create variables for each of the controls in MainActivity.
    ArrayAdapter<String> items;
    ListView list;
    EditText name;
    EditText phone;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.contactsView);
        name = (EditText)findViewById(R.id.nameText);
        phone = (EditText)findViewById(R.id.phoneText);
        addButton = (Button)findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String newContact = name.getText().toString() + " (" + phone.getText().toString() + ")";
        items.add(newContact);
        name.setText("");
        phone.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        String deleteContact = items.getItem(position);
        items.remove(deleteContact);
        return true;
    }
}
