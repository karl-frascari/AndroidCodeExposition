package karl.androidcodeexposition;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CanvasActivity extends AppCompatActivity {

    Paint facePaint = new Paint();
    Paint mePaint = new Paint();

    float adjust;
    float radius;

    float mouthLeftX, mouthRightX, mouthTopY, mouthBottomY;
    RectF mouthRectF;
    Path mouthPath;

    RectF eyeLeftRectF, eyeRightRectF;
    float eyeLeftX, eyeRightx, eyeTopY, eyeBottomY;

    ImageView img;

    boolean piscado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        img = (ImageView) findViewById(R.id.face);
        draw(piscado);
    }

    public void drawFace(float radius){

        facePaint.setColor(0xfffed325);
        facePaint.setDither(true);
        facePaint.setStrokeJoin(Paint.Join.ROUND);
        facePaint.setStrokeCap(Paint.Cap.ROUND);
        facePaint.setPathEffect(new CornerPathEffect(10) );
        facePaint.setAntiAlias(true);
        facePaint.setShadowLayer(4, 2, 2, 0x80000000);

        this.radius = radius;

        mePaint = new Paint();
        mePaint.setColor(0xff2a2a2a);
        mePaint.setDither(true);
        mePaint.setStyle(Paint.Style.STROKE);
        mePaint.setStrokeJoin(Paint.Join.ROUND);
        mePaint.setStrokeCap(Paint.Cap.ROUND);
        mePaint.setPathEffect(new CornerPathEffect(10) );
        mePaint.setAntiAlias(true);
        mePaint.setStrokeWidth(radius / 14.0f);

        adjust = radius / 3.2f;

        // Left Eye
        eyeLeftX = radius-(radius*0.43f);
        eyeRightx = eyeLeftX+ (radius*0.3f);
        eyeTopY = radius-(radius*0.5f);
        eyeBottomY = eyeTopY + (radius*0.4f);

        eyeLeftRectF = new RectF(eyeLeftX+adjust,eyeTopY+adjust,eyeRightx+adjust,eyeBottomY+adjust);

        // Right Eye
        eyeLeftX = eyeRightx + (radius*0.3f);
        eyeRightx = eyeLeftX + (radius*0.3f);

        eyeRightRectF = new RectF(eyeLeftX+adjust,eyeTopY+adjust,eyeRightx+adjust,eyeBottomY+adjust);

        // Smiley Mouth
        mouthLeftX = radius-(radius/2.0f);
        mouthRightX = mouthLeftX+ radius;
        mouthTopY = radius - (radius*0.2f);
        mouthBottomY = mouthTopY + (radius*0.5f);

        mouthRectF = new RectF(mouthLeftX+adjust,mouthTopY+adjust,mouthRightX+adjust,mouthBottomY+adjust);
        mouthPath = new Path();

        mouthPath.arcTo(mouthRectF, 30, 120, true);
    }

    public void draw(boolean piscado) {

        drawFace(250);

        Bitmap canvasHolder = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(canvasHolder);;

        canvas.drawCircle(radius+adjust, radius+adjust, radius, facePaint);

        mePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mouthPath, mePaint);

        mePaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(eyeLeftRectF, 0, 360, true, mePaint);

        if(!piscado){
            canvas.drawArc(eyeRightRectF, 0, 360, true, mePaint);
        }else{
            Paint closed_eye = new Paint();
            closed_eye.setColor(Color.BLACK);
            closed_eye.setStrokeWidth(8);
            canvas.drawLine(eyeLeftX+adjust,eyeTopY+adjust,eyeRightx+adjust,eyeBottomY+adjust, closed_eye);
        }

        img.setImageBitmap(canvasHolder);
    }

    public void piscar(View v) {
        draw(piscado);
        piscado = !piscado;
    }
}


