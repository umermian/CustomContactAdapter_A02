package com.example.popie.customcontactadapter_a02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.popie.customcontactadapter_a02.Model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Contact> contact;
    CustomContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView
        listView = (ListView) findViewById(R.id.listView);

        //DataSource (adding 1000 contacts)
        contact = new ArrayList<>();
        contact.add(new Contact(1, "Arslan", "03046284692", "Male"));
        contact.add(new Contact(2, "Badar", "03004121619", "Male"));
        contact.add(new Contact(3, "Faisal", "03347979265", "Male"));
        contact.add(new Contact(4, "Nazim", "+16472811673", "Male"));
        contact.add(new Contact(5, "Omair", "03224540447", "Male"));
        contact.add(new Contact(6, "Zeeshan", "03065932074", "Male"));

        for (int i = 0; i < 994; i++) {
            contact.add(new Contact(i + 7, "Name", "+92" + (i + 7), "Gender"));
        }

        //Adapter
        adapter = new CustomContactAdapter(this, contact);
        listView.setAdapter(adapter);

        //this listener will tell the position of the clicked item
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getApplicationContext(), "Position: " + i, Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}
