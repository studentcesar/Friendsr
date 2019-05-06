package com.example.friendsr;

import android.content.Context;
import android.support.v4.widget.ImageViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        TextView name =  convertView.findViewById(R.id.text);
        ImageView picture = convertView.findViewById(R.id.picture);

        picture.setImageResource(friends.get(position).getDrawableId());
        name.setText(friends.get(position).getName());

        return convertView;
    }
}
