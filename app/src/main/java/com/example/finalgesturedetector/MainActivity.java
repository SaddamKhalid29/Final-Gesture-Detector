package com.example.finalgesturedetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    /********* Steps **********
    *  Step 1: Create an activity and implements GestureDetector.OnGestureListener
    *  Step 2: Implement Methods from this interface
    *  Step 3: Create GestureDetectorCompat object
    *  Step 4: onTouchEvent override
    * */
    GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Context --> From where to listen
        // listener --> Which will hear
        gestureDetectorCompat=new GestureDetectorCompat(this,this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(gestureDetectorCompat.onTouchEvent(event)){
            return true;
        }
     //   int as= MotionEventCompat.getActionMasked(event);
        int action=event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.i("Tag","From motion event down is implemented");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.i("Tag","The movement of x is "+event.getX()+" Y is : "+event.getY());
                return true;
            case MotionEvent.ACTION_UP:
                Log.i("Tag","The Action Up is implemented X is  : "+event.getX()+ "  and Y is : "+event.getY());
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.i("Tag","On Down event has occurred..");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("Tag","On Show press event has occurred..");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("Tag","On Single Tap event has occurred..");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("Tag","On Scroll event has occurred..with X : "+e1.getX() +"  "+e2.getX());

        Log.i("Tag","On Scroll event has occurred..with Y : "+e1.getY() +"  "+e2.getY());
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

        Log.i("Tag","On Long Press event has occurred..");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("Tag","On Fling event has occurred.."+e1.getX() +"  "+e2.getX());
        return true;
    }
}