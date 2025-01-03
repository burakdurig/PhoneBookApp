package com.mastercoding.firebaseapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database

        // Initialize and Access the Firebase Database.
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Get a reference to a specific node in teh database
        DatabaseReference myRef = database.getReference("Users");
        // THe above changed from "messages" => "Users"

        // Write a value to the specific database location.
        // the below is commented out because it already was upload when
        // application was already ran.
//        User user1 = new User("Jack", "jack@gmail.com");
//        myRef.setValue(user1);

        // Write a value to the specified database location
        // myRef.setValue("Hello from our Course!");

        TextView textView = findViewById(R.id.textView);

        // the below is commented out so we can use the "Users" path.
        // The below will add data from a database snapshot and output the data to a specified value
        // as specific within the onDataChange in our case "textView" is the output. myRef is just a link to the database reference.
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // we don't need the below any more.
//                String newValue = snapshot.getValue(String.class);
//                textView.setText(newValue);
                    User user = snapshot.getValue(User.class);
                    textView.setText("Email: "+user.getEmail());
                    // The above will read from teh Realtime Database and will output in the app
                // link to the firebase:
                // https://console.firebase.google.com/project/fir-demo-app-3d7e2/database/fir-demo-app-3d7e2-default-rtdb/data?fb_gclid=Cj0KCQiAst67BhCEARIsAKKdWOnaaDcfN9nuvfN053h3oLod99KEugIOGPanYGquGRZC9wUI_EdBxRwaAiJIEALw_wcB

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Error handling.
            }
        });

    }
}