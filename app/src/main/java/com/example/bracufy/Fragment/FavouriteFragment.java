package com.example.bracufy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.bracufy.R;

public class FavouriteFragment extends Fragment {


    View vv;


    String TOPIC = "/topics/newOrder";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        vv = view;


//        WebView browser = view.findViewById(R.id.webview);
//        browser.getSettings().setLoadsImagesAutomatically(true);
//        browser.getSettings().setJavaScriptEnabled(true);
//        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        browser.loadUrl("https://www.scimagojr.com/journalrank.php?category=3310");


        return view;
    }


    //For Back Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

}
