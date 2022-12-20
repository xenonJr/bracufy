package com.example.bracufy.Fragment;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment  {


    RecyclerView recyclerView;
    LectureAdapter lectureAdapter;
    List<Lecture> lectureList;
    List<DatabaseReference> databaseReferenceList;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;




    @Override
    public View onCreateView  (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        lectureList = new ArrayList<>();
        databaseReferenceList = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance("https://bracufy-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference("Lectures");

        recyclerView = view.findViewById(R.id.lecture_rv);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(inflater.getContext())
        );




        //getting lectures from firebase
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot npsnapshot : snapshot.getChildren()){
                        Lecture l= npsnapshot.getValue(Lecture.class);
                        Log.d("DB",l.courseName);
                        Log.d("DB",l.topicName);
                        Log.d("DB ref",String.valueOf(npsnapshot.getRef()));
                        lectureList.add(l);
                        databaseReferenceList.add(npsnapshot.getRef());
                    }
                    lectureAdapter = new LectureAdapter(lectureList,inflater.getContext(),databaseReferenceList);
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
