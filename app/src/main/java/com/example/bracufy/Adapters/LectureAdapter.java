package com.example.bracufy.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import com.example.bracufy.View.AudioPlayer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LectureViewHolder> {

    List<Lecture> LectureList;
    List<DatabaseReference> databaseReferenceList;
    FragmentActivity fragmentActivity;
    Context context;
    boolean isFav = false;



    public LectureAdapter(List<Lecture> LectureList, FragmentActivity fragmentActivity) {
        this.LectureList = LectureList;
        this.fragmentActivity = fragmentActivity;

    }

    public LectureAdapter(List<Lecture> LectureList, Context context) {
        this.LectureList = LectureList;
        this.context = context;
    }

    public LectureAdapter(List<Lecture> LectureList, Context context, List<DatabaseReference> databaseReference){
        this.LectureList = LectureList;
        this.context = context;
        this.databaseReferenceList = databaseReference;
    }




    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.lecture_card,parent,false);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.topicName.setText(LectureList.get(position).topicName);
        holder.courseName.setText(LectureList.get(position).courseName);
        Glide.with(context).load(R.drawable.splash_back).into(holder.picture);
        if(LectureList.get(position).getisFavourite()==true){
            holder.fav.setImageResource(R.drawable.favourite);
            isFav = true;
        }

//

        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AudioPlayer.class);
                intent.putExtra("url",LectureList.get(position).getUrl());
                intent.putExtra("lecture", LectureList.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFav==false){
                    holder.fav.setImageResource(R.drawable.favourite);
                    Toast.makeText(context, "Added to Favourites", Toast.LENGTH_SHORT).show();
                    isFav = true;
                    LectureList.get(position).setFavourite(true);
                    databaseReferenceList.get(position).setValue(LectureList.get(position));
                }else{
                    holder.fav.setImageResource(R.drawable.fav_before);
                    Toast.makeText(context, "Removed to Favourites", Toast.LENGTH_SHORT).show();
                    isFav = false;
                    LectureList.get(position).setFavourite(false);
                    databaseReferenceList.get(position).setValue(LectureList.get(position));
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return LectureList.size();
    }

    public class LectureViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView courseName,topicName;
        ImageButton play,fav;

        public LectureViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.lecture_pic);
            courseName = itemView.findViewById(R.id.course_name);
            topicName = itemView.findViewById(R.id.topic_name);
            play = itemView.findViewById(R.id.play_button);
            fav = itemView.findViewById(R.id.favourite);

        }
    }
}

