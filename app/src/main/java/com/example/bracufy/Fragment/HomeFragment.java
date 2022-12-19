package com.example.bracufy.Fragment;


import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment  {


    RecyclerView recyclerView;
    LectureAdapter lectureAdapter;
    List<Lecture> lectureList;


    @Override
    public View onCreateView  (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        lectureList = new ArrayList<>();

        //dummy lecture//

        Lecture lecture1 = new Lecture("Cse 470","Class 1", "linear layout");
        Lecture lecture2 = new Lecture("Cse 270","Class 1", "diffrent layout");
        Lecture lecture3 = new Lecture("Cse 170","Class 1", "other layout");

        lectureList.add(lecture1);
        lectureList.add(lecture2);
        lectureList.add(lecture3);
        lectureList.add(lecture1);
        lectureList.add(lecture2);
        lectureList.add(lecture3);
        lectureList.add(lecture1);
        lectureList.add(lecture2);
        lectureList.add(lecture3);

        //dummy lecture//



        recyclerView = view.findViewById(R.id.lecture_rv);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(inflater.getContext())
        );

        lectureAdapter = new LectureAdapter(lectureList,inflater.getContext());
        recyclerView.setAdapter(lectureAdapter);




        return view;
    }


}
