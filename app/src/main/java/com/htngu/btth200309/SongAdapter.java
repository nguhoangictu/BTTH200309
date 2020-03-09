package com.htngu.btth200309;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;


public class SongAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Song> data;

    public SongAdapter(Context context, ArrayList<Song> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        init(convertView, i, viewGroup);

        return convertView;
    }

    private void init(View convertView, final int pos, final ViewGroup viewGroup) {
        ImageView thumb;
        TextView txtSongName, txtArtName, txtTime;
        thumb = convertView.findViewById(R.id.thumb);
        txtSongName = convertView.findViewById(R.id.song_name);
        txtArtName = convertView.findViewById(R.id.art_name);

        long mm = data.get(pos).getTime()/60;
        long ss = data.get(pos).getTime() - mm*60;

        txtTime = convertView.findViewById(R.id.time);

        thumb.setImageResource(data.get(pos).getThumb());
        txtSongName.setText(data.get(pos).getSongName());
        txtArtName.setText(data.get(pos).getArtName());
        txtTime.setText(mm+":"+ss);

        TextView edit = convertView.findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_edit,null);
                builder.setView(view1);


                final EditText edtName = view1.findViewById(R.id.edt_song_name);
                final EditText edtArt = view1.findViewById(R.id.edt_art_name);
                final EditText edtTime = view1.findViewById(R.id.edtTime);
                final AlertDialog alertDialog = builder.show();
                view1.findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            data.set(pos, new Song(edtName.getText().toString(), edtArt.getText().toString(), android.R.drawable.ic_media_play, Long.valueOf(edtTime.getText().toString())));
                            notifyDataSetChanged();
                            builder.setCancelable(true);
                            alertDialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(context, "Đữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }
}
