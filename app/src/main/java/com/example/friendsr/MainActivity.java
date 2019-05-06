package com.example.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();

        Friend xmen1 = new Friend("Beast","beast possesses superhuman strength, speed and agility. He is an excellent hand-to-hand combatant, employing a unique style of acrobatic combat.",
                getResources().getIdentifier("beast","drawable", getPackageName()));
        Friend xmen2 = new Friend("Cyclops","Cyclops emits beams of energy from his eyes, described as optic blasts, which have the appearance of red light and deliver massive concussive force.",
                getResources().getIdentifier("cyclops","drawable",getPackageName()));
        Friend xmen3 = new Friend("Jean Grey","Jean Grey is an Omega-level mutant, and at her highest and strongest potential was fully merged with the Phoenix Force",
                getResources().getIdentifier("jeangrey","drawable",getPackageName()));
        Friend xmen4 = new Friend("Magneto","Magneto is a mutant with the power to manipulate magnetic fields to achieve a wide range of effects.",
                getResources().getIdentifier("magneto","drawable",getPackageName()));
        Friend xmen5 = new Friend("Mystique","Mystique is a mutant shapeshifter with the ability to psionically shift the formation of her biological cells at will to change her appearance and thereby assume the form of other humans and animals",
                getResources().getIdentifier("mystique","drawable",getPackageName()));
        Friend xmen6 = new Friend("Professor X","Professor X is a mutant who possesses vast telepathic powers, and is among the strongest and most powerful telepaths in the Marvel Universe.",
                getResources().getIdentifier("professorx","drawable",getPackageName()));
        Friend xmen7 = new Friend("Rogue","Rogue possesses the mutant ability to absorb the psyche and abilities of another human being",
                getResources().getIdentifier("rogue","drawable",getPackageName()));
        Friend xmen8 = new Friend("Sabretooth","Sabretooth is an excellent hand-to-hand and armed combatant and superhuman strength due to his healing factor",
                getResources().getIdentifier("sabretooth","drawable",getPackageName()));
        Friend xmen9 = new Friend("Storm","Storm possesses the psionic ability to control all forms of weather over vast areas. She has been able to control both Earthly and extraterrestrial ecosystems",
                getResources().getIdentifier("storm","drawable",getPackageName()));
        Friend xmen10 = new Friend("Wolverine","Wolverine's primary mutant power is an accelerated healing process, also his skeleton was reinforced with the virtually indestructible metal adamantium",
                getResources().getIdentifier("wolverine","drawable",getPackageName()));

        friends.add(xmen1);
        friends.add(xmen2);
        friends.add(xmen3);
        friends.add(xmen4);
        friends.add(xmen5);
        friends.add(xmen6);
        friends.add(xmen7);
        friends.add(xmen8);
        friends.add(xmen9);
        friends.add(xmen10);


        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item,friends);
        GridView gridview = findViewById(R.id.gridView);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new GridItemClickListener());
    }



    private class GridItemClickListener implements AdapterView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

//            System.out.println(clickedFriend.getName());
        }
    }


}
