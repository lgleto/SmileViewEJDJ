package com.example.lourencogomes.smileview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lourencogomes on 30/10/17.
 */

public class SmileView extends View  implements View.OnTouchListener{

    public SmileView(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public SmileView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public SmileView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SmileView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.f);
        paint.setColor(Color.BLUE);

        float width = getWidth();
        float height = getHeight();

        float w4 = width/4.f;
        float h4 = height/4.f;


        //canvas.drawLine(0,0, width,height, paint );

        //Cara
        RectF rectF=new RectF(5,5,width-5,height-5);
        canvas.drawArc(rectF,0,360,false,paint);

        //Olho Esquerdo
        RectF rectFLeftEye=new RectF(w4,h4,w4*2,h4*2);
        canvas.drawArc(rectFLeftEye,0,360,false,paint);

        //Olho Direito
        RectF rectRightEye=new RectF(w4*2,h4,w4*3,h4*2);
        canvas.drawArc(rectRightEye,0,360,false,paint);

        //Boca
        RectF rectMouth=new RectF(w4,h4*2,w4*3,openMouth);
        canvas.drawArc(rectMouth,0,180,false,paint);
    }

    float openMouth=0;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        float x = motionEvent.getX();
        float y = motionEvent.getY();

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Smileview", "The view was touched on x:"+x+" y:"+y);
                openMouth=y;
                invalidate();
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.d("Smileview", "The view was touched on x:"+x+" y:"+y);
                openMouth=y;
                invalidate();
                return true;

        }

        return false;
    }
}
