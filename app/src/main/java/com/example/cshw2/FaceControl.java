package com.example.cshw2;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.annotation.RequiresApi;

import java.util.Random;

//@author Cian Murray
//Date: 3/3/21


//This class is the faceController class. It controlls changes made to the face. When the user interacts with the widgits when the application is running,
//some elemnet of the face class needs to change, and those changes are done in this class.
//It sets colors, hair styles and seekbar progress based on user input

public class FaceControl implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {
    private Face view;
    Random rand = new Random();
 //Instance variables
     
    // Seekbars to be used in a setter method
    SeekBar seekOne;
    SeekBar seekTwo;
    SeekBar seekThree;
    
   
     //ints representing red, green and blue to be used when adjusting the color
    int red;
    int green;
    int blue;


    //Constructor   
    public FaceControl(Face fav)
    {
        view = fav;

    }
    
    
    //onClick method

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                 //If the random button is clicked, all elements of the face are randomized
                view.hairStyle = rand.nextInt(3);
                view.skinColor = rand.nextInt(1 + 167772) -167772;
                view.eyeColor = rand.nextInt(1 + 167772) -167772;
                view.hairColor = rand.nextInt(1 + 167772) -167772;







                view.invalidate();
                break;

            //If the "hair" radio button is selected, the sliders reflect the hair color's rgb values
            case R.id.Hairbutton:

                 red = Color.red((view.hairColor));
                 blue = Color.blue(view.hairColor);
                 green = Color.green(view.hairColor);


                 seekOne.setProgress(red);
                 seekTwo.setProgress(blue);
                 seekThree.setProgress(green);

                 view.invalidate();












                break;
                //If the "skin" radio button is selected, the sliders reflect the skin color's rgb values

            case R.id.skinButton:

                red = Color.red((view.skinColor));
                blue = Color.blue(view.skinColor);
                green = Color.green(view.skinColor);


                seekOne.setProgress(red);
                seekTwo.setProgress(blue);
                seekThree.setProgress(green);

                view.invalidate();

                break;
                //If the "eye" radio button is selected, the sliders reflect the hair color's rgb values

            case R.id.eyeButton:

                red = Color.red((view.eyeColor));
                blue = Color.blue(view.eyeColor);
                green = Color.green(view.eyeColor);


                seekOne.setProgress(red);
                seekTwo.setProgress(blue);
                seekThree.setProgress(green);
                view.invalidate();

                break;



            default:
                break;




    }

}
  //Method for nothing selected for the spinner. If no items are selected, the spinner will default to Style one
    public void onNothingSelected(AdapterView<?> parent) {
        view.hairStyle = 0;
        view.invalidate();


    }
//This method sets the variable hairStyle in hte face class according to the item on the spinner the user selects
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch(position)
        {
            case 0:
                view.hairStyle = 0;
                break;
            case 1:
                view.hairStyle = 1;
                break;
            case 2:
                view.hairStyle = 2;
                break;
            default:
                break;


        }
        view.invalidate();


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    //setter method
    public void setSeekBars(SeekBar r, SeekBar g, SeekBar y)
    {
        seekOne = r;
        seekTwo = g;
        seekThree = y;

    }
}
