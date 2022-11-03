package com.example.healty.providers;

import com.example.healty.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UsersProvider {
    private CollectionReference mCollectionReference;

    public UsersProvider(){
        mCollectionReference = FirebaseFirestore.getInstance().collection("Users");
    }

    public DocumentReference getUserInfo(String id){
        return mCollectionReference.document(id);
    }

    public Task<Void> create(User user){
        return mCollectionReference.document(user.getId()).set(user);
    }

    public Task<Void> update(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("image",user.getImage());
        return mCollectionReference.document(user.getId()).update(map);
    }

    public Task<Void> deleteImage(String id){
        Map<String,Object> map = new HashMap<>();
        map.put("image",null);
        return mCollectionReference.document(id).update(map);
    }

    public Task<Void> updateImage(String id, String url){
        Map<String,Object> map = new HashMap<>();
        map.put("image", url);
        return mCollectionReference.document(id).update(map);
    }

    public Task<Void> updateUsername(String id, String username){
        Map<String,Object> map = new HashMap<>();
        map.put("username", username);
        return mCollectionReference.document(id).update(map);
    }

    public Task<Void> updateInfo(String id, String info){
        Map<String,Object> map = new HashMap<>();
        map.put("info", info);
        return mCollectionReference.document(id).update(map);
    }

}
