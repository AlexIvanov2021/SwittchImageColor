package com.example.swittchimagecolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.switchMY);
        imageView = findViewById(R.id.imageView);

        SharedPreferences sharedPreferences = this.getSharedPreferences("myFile", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(sharedPreferences.getBoolean("logic",true)){
            imageView.setBackground(getDrawable(R.color.yellow));
            aSwitch.setChecked(true);
        }else {
            imageView.setBackground(getDrawable(R.color.blue));
            aSwitch.setChecked(false);

        }

     aSwitch.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             if(b){
                imageView.setBackground(getDrawable(R.color.yellow));
                editor.putBoolean("logic",true);
                editor.apply();

             }else{
                 imageView.setBackground(getDrawable(R.color.blue));
                 editor.putBoolean("logic",false);
                 editor.apply();
             }
         }
     }));
    }
}