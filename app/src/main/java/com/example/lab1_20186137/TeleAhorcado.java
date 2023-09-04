package com.example.lab1_20186137;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
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
    private int acierto;
    private int palabrastotales;
    private ImageView[]partes;
    private int intentos=6;
    private int parte_actual;

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
        partes=new ImageView[intentos];
        partes[0]=findViewById(R.id.cabeza);
        partes[1]=findViewById(R.id.torso);
        partes[2]=findViewById(R.id.manoizquierda);
        partes[3]=findViewById(R.id.manoderecha);
        partes[4]=findViewById(R.id.pieizquierdo);
        partes[5]=findViewById(R.id.piederecho);
        playGame();

        Button botonNuevoJuego = findViewById(R.id.button2);
        botonNuevoJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarjuego();
            }
        });
    }
    private void reiniciarjuego(){
        contenedor.removeAllViews();
        TextView mensajeGanaste = findViewById(R.id.mensaje_ganaste);
        mensajeGanaste.setVisibility(View.INVISIBLE);
        TextView mensajePerdiste = findViewById(R.id.mensaje_perdiste);
        mensajePerdiste.setVisibility(View.INVISIBLE);

        ImageView cabeza = findViewById(R.id.cabeza);
        ImageView torso = findViewById(R.id.torso);
        ImageView manoIzquierda = findViewById(R.id.manoizquierda);
        ImageView manoDerecha = findViewById(R.id.manoderecha);
        ImageView pieIzquierdo = findViewById(R.id.pieizquierdo);
        ImageView pieDerecho = findViewById(R.id.piederecho);

        ImageView[] partes = {cabeza, torso, manoIzquierda, manoDerecha, pieIzquierdo, pieDerecho};
        for (ImageView parte : partes) {
            parte.setVisibility(View.INVISIBLE);
        }
        for (int i = 0; i < gridView.getChildCount(); i++) {
            gridView.getChildAt(i).setEnabled(true);
        }
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
        acierto=0;
        parte_actual=0;
        palabrastotales=a.length();

    }
    public void clic(View view){
        String letra=((TextView)view).getText().toString();
        char letra_t=letra.charAt(0);
        view.setEnabled(false);
        boolean correct=false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==letra_t){
                correct=true;
                acierto++;
                let[i].setTextColor(Color.BLACK);
            }
        }
        if (correct) {
            if(acierto==palabrastotales){
                TextView mensajeGanaste = findViewById(R.id.mensaje_ganaste);
                mensajeGanaste.setVisibility(View.VISIBLE);
                disableButtons();
            }
        }
        else if (parte_actual<intentos) {
            partes[parte_actual].setVisibility(View.VISIBLE);
            parte_actual++;


        }
        else{
            disableButtons();
            TextView mensajePerdiste= findViewById(R.id.mensaje_perdiste);
            mensajePerdiste.setVisibility(View.VISIBLE);
        }
    }
    public void disableButtons(){
        for(int i=0;i<gridView.getChildCount();i++){
            gridView.getChildAt(i).setEnabled(false);
        }
    }
}