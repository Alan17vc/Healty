package com.example.healty.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healty.R;
import com.example.healty.models.User;
import com.example.healty.providers.AuthProvider;
import com.example.healty.providers.UsersProvider;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    Button btnLogOut;
    UsersProvider mUsersProvider;
    AuthProvider mAuthProvider;
    User mUser;
    TextView mTextViewNameUser;
    TextView mTextViewInfoUser;
    CircleImageView mCircleImageViewPhotoUser;

    CardView mCardViewCreateDate;
    ImageView mImageViewCreateDate;
    TextView textViewCreateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuthProvider = new AuthProvider();
        mUser = new User();
        mUsersProvider = new UsersProvider();
        mTextViewNameUser = findViewById(R.id.txtNameUserHome);
        mTextViewInfoUser = findViewById(R.id.txtUserInfoHome);
        mCircleImageViewPhotoUser = findViewById(R.id.circleImagePhotoUserHome);

        mCardViewCreateDate = findViewById(R.id.cardViewCreateDate);
        mImageViewCreateDate = findViewById(R.id.imageCreateDate);
        textViewCreateDate = findViewById(R.id.createDatetxt);

        mCircleImageViewPhotoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfileActivity();
            }
        });
        mCardViewCreateDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreateDateActivity();
            }
        });

        getData();

    }

    private void goToCreateDateActivity() {
        Intent intent = new Intent(HomeActivity.this, CreateDietActivity.class);
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(mImageViewCreateDate, "imageTransition");
        pairs[1] = new Pair<View, String>(textViewCreateDate, "nameTransition");
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, pairs);
        startActivity(intent, activityOptions.toBundle());
    }

    private void goToProfileActivity() {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(mCircleImageViewPhotoUser, "profileTransition");
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, pairs);
        startActivity(intent, activityOptions.toBundle());
    }

    private void getData() {
        mUsersProvider.getUserInfo(mAuthProvider.getId()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    //String username = documentSnapshot.getString("username"); // Esta linea trae el campo solicitado desde la base de datos
                    User user = documentSnapshot.toObject(User.class);
                    mTextViewNameUser.setText(user.getUsername());
                    if (mTextViewInfoUser != null){
                        if (!mTextViewInfoUser.equals("")){
                            mTextViewInfoUser.setText(user.getInfo());
                        }
                    }
                    if (user.getImage() != null){
                        if (!user.getImage().equals("")){
                            Picasso.with(HomeActivity.this).load(user.getImage()).into(mCircleImageViewPhotoUser);
                        }
                    }
                }
            }
        });
    }

    private void signOut(){
        mAuthProvider.signOut();
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}