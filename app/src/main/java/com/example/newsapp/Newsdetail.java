package com.example.newsapp;

import static com.example.newsapp.MainActivity.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Newsdetail extends AppCompatActivity {

    int itemPosition;
    ImageView imageView;
    private TextView tvSourceName,tvtime,tvTitle,tvDesc,tvcontent;

    private Object Picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);

        itemPosition=getIntent().getIntExtra("key",0);
        DateFormat formater = new SimpleDateFormat("dd-MM-yy");

        tvSourceName = findViewById(R.id.tvName);
        tvtime = findViewById(R.id.tvtime);
        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        tvcontent = findViewById(R.id.tvcontent);

        tvSourceName.setText(list.get(itemPosition).getSource().getName());
        tvtime.setText(formater.format(list.get(itemPosition).publishedAt));
        tvTitle.setText(list.get(itemPosition).getTitle());
        tvDesc.setText(list.get(itemPosition).getDescription());
        tvcontent.setText(list.get(itemPosition).getContent());

        imageView = findViewById(R.id.newsImageView);
       com.squareup.picasso.Picasso.get().load(list.get(itemPosition).getUrlToImage()).placeholder(R.mipmap.logo).into(imageView);

        Button urlBtn=findViewById(R.id.appCompatButton);
        urlBtn.setOnClickListener(v -> {
            Intent intent=new Intent(v.getContext(), webview.class);
            intent.putExtra("url",list.get(itemPosition).getUrl());
            v.getContext().startActivity(intent);
        });

    }
}