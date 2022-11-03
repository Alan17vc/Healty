package com.example.healty.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.healty.R;
import com.example.healty.activities.ProfileActivity;
import com.example.healty.providers.AuthProvider;
import com.example.healty.providers.ImageProvider;
import com.example.healty.providers.UsersProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomSheetUsername extends BottomSheetDialogFragment {
    Button mBtnCancel;
    Button mBtnSave;
    EditText mEditTextUsernameProfile;
    ImageProvider mImageProvider;
    AuthProvider mAuthProvider;
    UsersProvider mUsersProvider;
    String username;

    public static BottomSheetUsername newInstance(String username) {
        BottomSheetUsername bottomSheetSelectImage = new BottomSheetUsername();
        Bundle args = new Bundle();
        args.putString("username",username);
        bottomSheetSelectImage.setArguments(args);

        return bottomSheetSelectImage;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        username = getArguments().getString("username");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_username, container, false);

        mImageProvider = new ImageProvider();
        mUsersProvider = new UsersProvider();
        mAuthProvider = new AuthProvider();

        mBtnCancel = view.findViewById(R.id.btnCancel);
        mBtnSave = view.findViewById(R.id.btnSave);
        mEditTextUsernameProfile = view.findViewById(R.id.editTextUsernameEditProfile);
        mEditTextUsernameProfile.setText(username);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUsername();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return view;
    }

    private void updateUsername() {
        String username = mEditTextUsernameProfile.getText().toString();
        if (!username.equals("")){
            mUsersProvider.updateUsername(mAuthProvider.getId(), username).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    dismiss();
                    Toast.makeText(getContext(), "El nombre se actualizo correctamente", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
