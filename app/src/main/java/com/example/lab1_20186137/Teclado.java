package com.example.lab1_20186137;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextClock;

public class Teclado extends BaseAdapter {
    private String[]letras;
    private LayoutInflater b;

    public  Teclado (Context context){
        letras=new String[26];
        for(int j=0;j<letras.length;j++){
            letras[j]=""+(char)(j+'A');
        }
        b=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return letras.length;
    }

    @Override
    public Object getItem(int j) {
        return null;
    }

    @Override
    public long getItemId(int j) {
        return 0;
    }

    @Override
    public View getView(int j, View view, ViewGroup viewGroup) {
        Button button;
        if(view==null){
            button=(Button)b.inflate(R.layout.letra,viewGroup,false);
        }else {
            button=(Button) view;
        }
        button.setText(letras[j]);
        //button.setText("A");
        return button;
    }
}
