package com.htngu.btth200309;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvSong;
    private SongAdapter songAdapter;
    private ArrayList<Song> songs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();


    }

    private void event() {
        lvSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("SongName", songs.get(i).getSongName());
                bundle.putString("ArtName", songs.get(i).getArtName());
                bundle.putLong("Time", songs.get(i).getTime());
                bundle.putInt("Thumb", songs.get(i).getThumb());
                intent.putExtra("data", bundle);
                startActivity(intent);

            }
        });
        lvSong.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Xoá "+songs.get(pos).getSongName())
                        .setMessage("Bạn có chắc chắn muốn xoá "+songs.get(pos).getSongName())
                        .setCancelable(true)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                songs.remove(pos);
                                songAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                return false;
            }
        });
    }


    private void init() {
        lvSong = findViewById(R.id.lv_song);
        songs = new ArrayList<>();
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));
        songs.add(new Song("Nhạc sống hà tây", "đan trường", android.R.drawable.ic_media_play, 350));

        songAdapter = new SongAdapter(MainActivity.this, songs);
        lvSong.setAdapter(songAdapter);
    }

    public void addSong(View view) {
        try{
            EditText edtName, edtArt, edtTime;
            edtName = findViewById(R.id.edt_song_name);
            edtArt = findViewById(R.id.edt_art_name);
            edtTime = findViewById(R.id.edtTime);

            songs.add(new Song(edtName.getText().toString(), edtArt.getText().toString(), android.R.drawable.ic_media_play, Integer.valueOf(edtTime.getText().toString())));
            songAdapter.notifyDataSetChanged();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Đữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
