package com.htngu.btth200309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView txtTime, txtName, txtArt;
        ImageView img = findViewById(R.id.thumb);
        txtName = findViewById(R.id.song_name);
        txtArt = findViewById(R.id.art_name);
        txtTime = findViewById(R.id.time);

        Bundle bundle = getIntent().getBundleExtra("data");
        txtName.setText(bundle.getString("SongName"));
        txtArt.setText(bundle.getString("ArtName"));

        long mm = bundle.getLong("time")/60;
        long ss = bundle.getLong("time") - mm*60;

        txtTime.setText(mm+":"+ss);
        img.setImageResource(bundle.getInt("Thumb"));
    }
}
