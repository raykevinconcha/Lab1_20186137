package com.example.lab1_20186137;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private static String TAG="msg-test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.text_view);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menumain,menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView textView = findViewById(R.id.text_view);
        int id_blue=R.id.menu_color_blue;
        int id_green=R.id.menu_color_green;
        int id_red=R.id.menu_color_red;

        if(item.getItemId()==id_blue){
            Toast.makeText(this, "Color Azul Seleccionado", Toast.LENGTH_SHORT).show();
            textView.setTextColor(Color.BLUE);
            return true;
        }else if(item.getItemId()==id_green){
            Toast.makeText(this, "Color Verde Seleccionado", Toast.LENGTH_SHORT).show();
            textView.setTextColor(Color.GREEN);
            return true;
        }else if(item.getItemId()==id_red){
            Toast.makeText(this, "Color Rojo Seleccionado", Toast.LENGTH_SHORT).show();
            textView.setTextColor(Color.RED);
            return true;
        }else{
            return super.onContextItemSelected(item);
        }
    }



    public void play(View view){
        Intent intent=new Intent(this ,TeleAhorcado.class);
        startActivity(intent);
    }

}