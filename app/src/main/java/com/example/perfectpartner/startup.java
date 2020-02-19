package com.example.perfectpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class startup extends AppCompatActivity {

 DatabaseReference reff1;
 FirebaseAuth mFirebaseAuth;
 FirebaseAuth.AuthStateListener mAuthListner;
 FirebaseDatabase database;
 ImageView profile_pic;
 FirebaseStorage storage;
 int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseAuth.addAuthStateListener(authStateListener);

        if(mFirebaseAuth.getCurrentUser() != null){
            reff1 = FirebaseDatabase.getInstance().getReference();
            profile_pic = findViewById(R.id.profile_pic_imageView);

            database = FirebaseDatabase.getInstance();
            storage = FirebaseStorage.getInstance();
            DatabaseReference reff = database.getReference(mFirebaseAuth.getUid());
        StorageReference storageReff = storage.getReference();
       Toast t1 = Toast.makeText(startup.this, "hello" + mFirebaseAuth.getUid(), Toast.LENGTH_LONG);
       t1.show();
        storageReff.child(mFirebaseAuth.getUid()).child("Images").child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Toast.makeText(startup.this, "" + mFirebaseAuth.getUid(), Toast.LENGTH_LONG);
                Picasso.get().load(uri).fit().centerInside().into(profile_pic);

            }

        });
        }

    }

    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user =  mFirebaseAuth.getCurrentUser();

            if(user == null) {
                Intent intent = new Intent(startup.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    };
}
