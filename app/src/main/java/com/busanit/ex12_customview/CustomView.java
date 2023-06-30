package com.busanit.ex12_customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CustomView extends View{
    private Paint paint;

    public CustomView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(100,100,200,200, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(10,10,100,100, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(Color.GREEN);
        canvas.drawRect(10,10,100,100, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(128,0,0,255);
        canvas.drawRect(120,10,210,100,paint);

        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5,5},1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setPathEffect(dashPathEffect);
        paint.setColor(Color.GREEN);
        canvas.drawRect(120,10,210,100,paint);

        paint = new Paint();

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(50,160,40,paint);
        paint.setAntiAlias(true);
        canvas.drawCircle(160,160,40,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setTextSize(30);
        canvas.drawText("Text (Stroke)",20,260,paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Text (Fill)",20,320,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            Toast.makeText(super.getContext(),"Event Action Down "+event.getX()+", "+event.getY(),
                    Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
}
