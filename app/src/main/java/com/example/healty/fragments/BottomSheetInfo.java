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
import com.example.healty.providers.AuthProvider;
import com.example.healty.providers.ImageProvider;
import com.example.healty.providers.UsersProvider;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetInfo extends BottomSheetDialogFragment {
    Button mBtnCancelInfo;
    Button mBtnSaveInfo;
    EditText mEditTextInfoProfile;
    ImageProvider mImageProvider;
    AuthProvider mAuthProvider;
    UsersProvider mUsersProvider;
    String info;

    public static BottomSheetInfo newInstance(String username) {
        BottomSheetInfo bottomSheetInfo = new BottomSheetInfo();
        Bundle args = new Bundle();
        args.putString("info",username);
        bottomSheetInfo.setArguments(args);

        return bottomSheetInfo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        info = getArguments().getString("info");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_info, container, false);

        mImageProvider = new ImageProvider();
        mUsersProvider = new UsersProvider();
        mAuthProvider = new AuthProvider();

        mBtnCancelInfo = view.findViewById(R.id.btnCancelInfo);
        mBtnSaveInfo = view.findViewById(R.id.btnSaveInfo);
        mEditTextInfoProfile = view.findViewById(R.id.editTextInfoEditProfile);
        mEditTextInfoProfile.setText(info);

        mBtnSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInfo();
            }
        });

        mBtnCancelInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return view;
    }

    private void updateInfo() {
        String info = mEditTextInfoProfile.getText().toString();
        if (!info.equals("")){
            mUsersProvider.updateInfo(mAuthProvider.getId(), info).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    dismiss();
                    Toast.makeText(getContext(), "La informacion se actualizo correctamente", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
