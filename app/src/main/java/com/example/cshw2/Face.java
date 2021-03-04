package com.example.cshw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import java.util.Random;

//@author Cian Murray
//Date: 3/3/21

//This is the face class. In this class, hte face is drawn. This class has instance variables repersenting the hair color, eye color and skin color of the face.
//It darws a face according to these specifacations in the onDraw method. This method utilizes several helper methods to help draw different parts of the face
public class Face extends SurfaceView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

//Instance variables
    //These ints repersent different colors
    public int skinColor;

    public int eyeColor;
    public int hairColor;
    //This int will repersent which hair style will be drawn
    public int hairStyle;

    Random rand = new Random();




//Paint
    Paint paint = new Paint();

    //Constructor
    //Sets willNotDraw to false to allow for drawing
    //calls randomize method, which sets all instance variables to random values
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);


        setWillNotDraw(false);

        randomize();



    }
    //Sets instance variables to random values
    //Bounds for hair style is three, because there are three hair styles to choose from
    //Bounds for colors are -167772 to -1
    public void randomize()
    {
        skinColor = rand.nextInt(1 + 167772) -167772;

        eyeColor = rand.nextInt(1 + 167772) -167772;
        hairColor = rand.nextInt(1 + 167772) -167772;

        hairStyle = rand.nextInt(3);




    }

//OnDraw method draws the face
    protected void onDraw(Canvas canvas)
    {

        drawEars(canvas);
        drawHead(canvas);

        drawEyes(canvas);
        drawMouth(canvas);
        drawHair(canvas);








    }
    //Draws the face head
    public void drawHead(Canvas can)
    {
        paint.setColor(skinColor);
        can.drawOval(100.0f, 100.0f, 600.0f, 800.0f, paint);


    }
    //draws the face ears
    public void drawEars(Canvas can)
    {
        paint.setColor(skinColor);

        can.drawOval(75.0f, 300.0f, 250.0f, 500.0f, paint);
        can.drawOval(450.0f, 300.0f, 625.0f, 500.0f, paint);

        //can.drawOval(600.0f, 200.0f, 50.0f, 100.0f, paint);

    }
    //draws the face eyes
    public void drawEyes(Canvas can)
    {
        paint.setColor(eyeColor);
        can.drawOval(200.0f, 300.0f, 250.0f, 350.0f, paint);
        can.drawOval(450.0f, 300.0f, 500.0f, 350.0f, paint);

    }
    //draws the mouth
    public void drawMouth(Canvas can)
    {
        paint.setColor(Color.BLACK);
        can.drawRect(200.0f, 525.0f, 500.0f,550.0f,paint);

    }
    //Draws one of three hair styled depending on the value of hairStyle
    public void drawHair(Canvas can)
    {

        paint.setColor(hairColor);
        if(hairStyle == 1)
        {
            can.drawOval(200.0f, 50.0f, 500.0f, 150.0f, paint);

        }
        else if(hairStyle == 2)
        {
            can.drawOval(150.0f, 0.0f, 550.0f, 250.0f, paint);
        }
        else
        {
            can.drawOval(200.0f, 100.0f, 500.0f, 150.0f, paint);
        }



    }






    @Override
    public void onClick(View v) {







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
}


