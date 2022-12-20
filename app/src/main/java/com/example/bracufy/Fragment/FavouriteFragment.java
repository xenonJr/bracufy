package com.example.bracufy.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bracufy.Adapters.LectureAdapter;
import com.example.bracufy.Model.Lecture;
import com.example.bracufy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment {

    RecyclerView recyclerView;
    LectureAdapter lectureAdapter;
    List<Lecture> lectureList;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        lectureList = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance("https://bracufy-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference("Lectures");

        recyclerView = view.findViewById(R.id.fav_rv);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(inflater.getContext())
        );

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot npsnapshot : snapshot.getChildren()){
                        Lecture l= npsnapshot.getValue(Lecture.class);
                        Log.d("DB",l.courseName);
                        Log.d("DB",l.topicName);
                        Log.d("DB bool",String.valueOf(l.getisFavourite()));
                        if(l.getisFavourite()==true){
                            Log.d("DB fav",l.topicName);
                            lectureList.add(l);
                        }
                    }
                    lectureAdapter = new LectureAdapter(lectureList,inflater.getContext());
                    recyclerView.setAdapter(lectureAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;
    }




}
