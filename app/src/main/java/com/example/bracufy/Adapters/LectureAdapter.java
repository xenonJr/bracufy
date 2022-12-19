package com.example.bracufy.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bracufy.Model.Lecture;
import com.example.bracufy.R;

import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LectureViewHolder> {

    List<Lecture> LectureList;
    FragmentActivity fragmentActivity;
    Context context;

    public LectureAdapter(List<Lecture> LectureList, FragmentActivity fragmentActivity) {
        this.LectureList = LectureList;
        this.fragmentActivity = fragmentActivity;

    }

    public LectureAdapter(List<Lecture> LectureList, Context context) {
        this.LectureList = LectureList;
        this.context = context;
    }




    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.lecture_card,parent,false);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder holder, int position) {

        holder.topicName.setText(LectureList.get(position).topicName);
        holder.courseName.setText(LectureList.get(position).courseName);
        Glide.with(context).load(R.drawable.splash_back).into(holder.picture);

        if(LectureList.get(position).getUrl()!=null){
            Glide.with(context)
                    .load(LectureList.get(position).getUrl())
                    .into(holder.picture);
        }



    }

    @Override
    public int getItemCount() {
        return LectureList.size();
    }

    public class LectureViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView courseName,topicName;

        public LectureViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.lecture_pic);
            courseName = itemView.findViewById(R.id.course_name);
            topicName = itemView.findViewById(R.id.topic_name);

        }
    }
}

