package com.example.lab1_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class TeleAhorcado extends AppCompatActivity {
    private Random random;
    private String a;
    private String[] palabras;
    private TextView[] let;
    private LinearLayout contenedor;
    private Teclado teclado;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int id_palabras=R.id.palabras;
        int id_letras=R.id.letras;

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tele_ahorcado);
        palabras=getResources().getStringArray(R.array.palabras);
        contenedor=findViewById(id_palabras);
        gridView=findViewById(id_letras);
        random=new Random();
        playGame();

    }

    private void playGame(){
        String nueva_palabra=palabras[random.nextInt(palabras.length)];
        while (nueva_palabra.equals(a))nueva_palabra=palabras[random.nextInt(palabras.length)];
        a=nueva_palabra;
        let=new TextView[a.length()];
        for(int i=0;i<a.length();i++){
            let[i]=new TextView(this);
            let[i].setText(""+a.charAt(i));
            let[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            let[i].setGravity(Gravity.CENTER);
            let[i].setTextColor(Color.WHITE);
            contenedor.addView(let[i]);
        }
        teclado=new Teclado(this);
        gridView.setAdapter(teclado);

    }
}