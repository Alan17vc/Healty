package com.example.healty.providers;

import android.content.Context;
import android.net.Uri;

import com.example.healty.utils.CompressorBitmapImage;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Date;

public class ImageProvider {
    StorageReference mStorageReference;
    FirebaseStorage mFirebaseStorage;

    public ImageProvider(){
        mFirebaseStorage = FirebaseStorage.getInstance();
        mStorageReference = mFirebaseStorage.getReference();
    }

    public UploadTask save(Context context, File file){
        byte[] imageByte = CompressorBitmapImage.getImage(context, file.getPath(), 500,500);
        StorageReference storage = mStorageReference.child(new Date() + ".jpg");
        mStorageReference = storage;
        UploadTask task = storage.putBytes(imageByte);
        return  task;
    }

    public Task<Uri> getDownloadUri(){
        return mStorageReference.getDownloadUrl();
    }
    
    public Task<Void> delete(String url){
        return mFirebaseStorage.getReferenceFromUrl(url).delete();
    }
}
