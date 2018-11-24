package com.example.eventapp.timesofindia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventapp.timesofindia.model.Article;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Article> articles;

    public CustomAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int position) {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.list_item,parent,false);
        }

        TextView titleTxt= (TextView) convertView.findViewById(R.id.titleTxt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);

        Article article= (Article) this.getItem(position);

        final String title=article.getTitle();
        final String desc=article.getDescription();

        titleTxt.setText(title);
        //descTxt.setText(desc.substring(0,50));
        descTxt.setText(desc);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Toast.makeText(c,title,Toast.LENGTH_SHORT).show();*/

              Intent intent=new Intent(c, ParticularArticle.class);
              intent.putExtra("Title", title);
              intent.putExtra("Description", desc);
              v.getContext().startActivity(intent);


            }
        });

        return convertView;
    }
}
