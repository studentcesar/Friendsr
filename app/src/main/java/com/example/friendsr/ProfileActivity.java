package com.example.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.SharedPreferences;

public class ProfileActivity extends AppCompatActivity {

    private String friend_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(retrievedFriend.getDrawableId());

        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName());

        TextView power = findViewById(R.id.power);
        power.setText(retrievedFriend.getPower());

        RatingBar rating_bar = findViewById(R.id.rating_bar);
        rating_bar.setOnRatingBarChangeListener(new RatingBarChangeListener());


        friend_name = retrievedFriend.getName();
//        String key = friend_name + "Rating";

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat(friend_name,0.0f);

        if (rating != 0.0f) {
            rating_bar.setRating(rating);
        }
        else {
            rating_bar.setRating(0.0f);
        }



    }

    private class RatingBarChangeListener  implements RatingBar.OnRatingBarChangeListener{

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(friend_name,rating);
            editor.apply();


        }
    }
}
