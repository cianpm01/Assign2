package com.example.cshw2;
//@author Cian Murray
//Date: 3/3/21


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seekbars for rgb
        SeekBar redSeek = (SeekBar)findViewById(R.id.seekBar8);
        SeekBar greenSeek = (SeekBar)findViewById(R.id.seekBarGreen);
        SeekBar blueSeek = (SeekBar)findViewById(R.id.seekBarBlue);


        // button for randomizing look
        Button random = (Button)findViewById(R.id.button);

        //spinner for choosing hair stylr

        Spinner spinner = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //Radio buttons to choose between adjusting eyes, hair or skin color

        RadioButton skinButton = (RadioButton)findViewById(R.id.skinButton);
        RadioButton eyeButton = (RadioButton)findViewById(R.id.eyeButton);
        RadioButton hairButton = (RadioButton)findViewById(R.id.Hairbutton);
        RadioGroup radiogroup = (RadioGroup)findViewById(R.id.radioGroup);



        //creation of a Face object
        Face face = (Face)findViewById(R.id.surfaceView3);
        //Creation of a FaceControl object
        FaceControl fac = new FaceControl(face);
        //Sets the seekBars to instance variables within face
        fac.setSeekBars(redSeek, blueSeek, greenSeek);


        //Setting listeners

        random.setOnClickListener(fac);
        skinButton.setOnClickListener(fac);
        eyeButton.setOnClickListener(fac);
        hairButton.setOnClickListener(fac);

        redSeek.setOnSeekBarChangeListener(fac);
        blueSeek.setOnSeekBarChangeListener(fac);
        greenSeek.setOnSeekBarChangeListener(fac);

        spinner.setOnItemSelectedListener(fac);


                //spinner.setOnItemSelectedListener(this);



    }




}