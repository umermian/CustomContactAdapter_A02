package com.example.popie.customcontactadapter_a02;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popie.customcontactadapter_a02.Model.Contact;

import java.util.ArrayList;

/**
 * Created by popie on 10/2/2017.
 */

public class CustomContactAdapter extends BaseAdapter {

    Context context;
    ArrayList<Contact> contact;

    public CustomContactAdapter(Context context, ArrayList<Contact> contact) {
        this.context = context;
        this.contact = contact;
    }

    @Override
    public int getCount() {
        return contact.size();
    }

    @Override
    public Object getItem(int i) {
        return getItemId(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Contact cnt = contact.get(i);
        View rootView = view;
        final ViewHolder holder;

        if (rootView == null) {

            rootView = LayoutInflater.from(context).inflate(R.layout.list_view_item, viewGroup, false);
            holder = new ViewHolder();
            holder.tvName = rootView.findViewById(R.id.name);
            holder.tvPhone = rootView.findViewById(R.id.phone);
            holder.tvGender = rootView.findViewById(R.id.gender);
            holder.image = rootView.findViewById((R.id.imageView));

            holder.image.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel: " + holder.tvPhone.getText().toString()));
                            context.startActivity(intent);
                            Toast.makeText(context, "Calling: " + holder.tvPhone.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
            );

            rootView.setTag(holder);

        } else {
            holder = (ViewHolder) rootView.getTag();
        }


        holder.tvName.setText(contact.get(i).getName());
        holder.tvPhone.setText(contact.get(i).getPhone());
        holder.tvGender.setText(contact.get(i).getGender());

        return rootView;
    }

    public class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        TextView tvGender;
        ImageView image;
    }
}
