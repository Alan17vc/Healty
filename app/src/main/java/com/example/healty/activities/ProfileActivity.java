package com.example.healty.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healty.R;
import com.example.healty.fragments.BottomSheetInfo;
import com.example.healty.fragments.BottomSheetSelectImage;
import com.example.healty.fragments.BottomSheetUsername;
import com.example.healty.models.User;
import com.example.healty.providers.AuthProvider;
import com.example.healty.providers.ImageProvider;
import com.example.healty.providers.UsersProvider;
import com.example.healty.utils.MyToolbar;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;
import com.fxn.utility.PermUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    FloatingActionButton mFapSelectImage;
    BottomSheetSelectImage mBottomSheetSelectImage;
    UsersProvider mUsersProvider;
    AuthProvider mAuthProvider;
    TextView mTxtViewUsernameProfile;
    TextView mTxtViewStateProfile;
    TextView mTxtViewPhoneProfile;
    CircleImageView mCircleImageViewProfile;
    User mUser;
    // variables de camara
    Options mOptions;
    ArrayList<String> mReturnValues = new ArrayList<>();
    File mFileImage;
    ProgressDialog mProgressDialogProfile;
    ImageProvider mImageProvider;
    BottomSheetUsername mBottomSheetUsername;
    BottomSheetInfo mBottomSheetInfo;
    ImageView mImageViewSheetUsername;
    ImageView mImageViewSheetInfo;

    ListenerRegistration mListenerRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        MyToolbar.show(this, "Perfil",true);
        mFapSelectImage = findViewById(R.id.fabSelectImage);
        mUsersProvider = new UsersProvider();
        mAuthProvider = new AuthProvider();


        mTxtViewUsernameProfile = findViewById(R.id.txtViewUsernameProfile);
        mTxtViewStateProfile = findViewById(R.id.txtViewInfoProfile);
        mTxtViewPhoneProfile = findViewById(R.id.txtViewPhoneProfile);
        mCircleImageViewProfile = findViewById(R.id.circleImageViewProfile);

        mProgressDialogProfile = new ProgressDialog(ProfileActivity.this);
        mProgressDialogProfile.setTitle("Espere un momento");
        mProgressDialogProfile.setMessage("Almacenando informacion");

        mImageViewSheetUsername = findViewById(R.id.imageViewUsernameEditProfile);
        mImageViewSheetInfo = findViewById(R.id.imageViewInfo);

        mOptions = Options.init()
                .setRequestCode(100)                                           //Request code for activity results
                .setCount(1)                                                   //Number of images to restict selection count
                .setFrontfacing(true)                                         //Front Facing camera on start
                .setPreSelectedUrls(mReturnValues)                               //Pre selected Image Urls
                .setSpanCount(4)                                               //Span count for gallery min 1 & max 5
                .setMode(Options.Mode.All)                                     //Option to select only pictures or videos or both
                .setVideoDurationLimitinSeconds(30)                            //Duration for video recording
                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)     //Orientaion
                .setPath("/pix/images");


        mFapSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBotonSheetSelectImage();
            }
        });

        mImageViewSheetUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBottomSheetUsername();
            }
        });

        mImageViewSheetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBottomSheetEditInfo();
            }
        });

        getUserInfo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mListenerRegistration != null){
            mListenerRegistration.remove();
        }
    }

    public void startPix() {
        Pix.start(ProfileActivity.this, mOptions);
    }

    private void getUserInfo() {
        mListenerRegistration = mUsersProvider.getUserInfo(mAuthProvider.getId()).addSnapshotListener(new EventListener<DocumentSnapshot>() { //addSnapshotListener trae datos en tiempo real
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null){
                    if (documentSnapshot.exists()){
                        //String username = documentSnapshot.getString("username"); // Esta linea trae el campo solicitado desde la base de datos
                        mUser = documentSnapshot.toObject(User.class);
                        mTxtViewUsernameProfile.setText(mUser.getUsername());
                        mTxtViewPhoneProfile.setText(mUser.getPhone());
                        mTxtViewStateProfile.setText(mUser.getInfo());
                        if (mUser.getImage() != null){
                            if (!mUser.getImage().equals("")){
                                Picasso.with(ProfileActivity.this).load(mUser.getImage()).into(mCircleImageViewProfile);
                            }
                            else{
                                setImageDefault();
                            }
                        }
                        else{
                            setImageDefault();
                        }
                    }
                }

            }
        });
    }

    private void openBotonSheetSelectImage() {
        if (mUser != null){
            mBottomSheetSelectImage = BottomSheetSelectImage.newInstance(mUser.getImage());
            mBottomSheetSelectImage.show(getSupportFragmentManager(),mBottomSheetSelectImage.getTag());
        }else{
            Toast.makeText(this, "La aplicacion no se pudo cargar", Toast.LENGTH_SHORT).show();
        }
    }

    private void openBottomSheetEditInfo() {
        if (mUser != null){
            mBottomSheetInfo = BottomSheetInfo.newInstance(mUser.getInfo());
            mBottomSheetInfo.show(getSupportFragmentManager(),mBottomSheetInfo.getTag());
        }else{
            Toast.makeText(this, "No se pudo actualizar la informacion", Toast.LENGTH_SHORT).show();
        }
    }

    private void openBottomSheetUsername() {
        if (mUser != null){
            mBottomSheetUsername = BottomSheetUsername.newInstance(mUser.getUsername());
            mBottomSheetUsername.show(getSupportFragmentManager(),mBottomSheetUsername.getTag());
        }else{
            Toast.makeText(this, "No se pudo actualizar el nombre", Toast.LENGTH_SHORT).show();
        }
    }

    public void setImageDefault(){
        mCircleImageViewProfile.setImageResource(R.drawable.ic_person_white);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
            mReturnValues = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            mFileImage = new File(mReturnValues.get(0));
            mCircleImageViewProfile.setImageBitmap(BitmapFactory.decodeFile(mFileImage.getAbsolutePath()));
            saveImage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Pix.start(ProfileActivity.this, mOptions);
            } else {
                Toast.makeText(ProfileActivity.this, "Concede los permisos para acceder a la camara", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void saveImage() {
        mImageProvider = new ImageProvider();
        mProgressDialogProfile.show();
        mImageProvider.save(this, mFileImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()){
                    mImageProvider.getDownloadUri().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String url = uri.toString();
                            mUsersProvider.updateImage(mAuthProvider.getId(), url).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(ProfileActivity.this, "La imagen se subio correctamente", Toast.LENGTH_SHORT).show();
                                    mProgressDialogProfile.dismiss();
                                }
                            });
                        }
                    });
                }else{
                    mProgressDialogProfile.dismiss();
                    Toast.makeText(ProfileActivity.this, "No se pudo almacenar la imagen", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}