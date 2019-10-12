package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import demo.wj.hencoderpaintsample.R;


public class XfermodeView extends View {
    Bitmap src;
    Bitmap dst;


    private PorterDuff.Mode mode;


    public void setMode(PorterDuff.Mode mode) {
        this.mode = mode;
        invalidate();
    }

    public XfermodeView(Context context) {
        super(context);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        src = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        dst = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(src);
        Canvas dstCanvas = new Canvas(dst);
        float radius = w * 1f / 3;
        float left = radius;
        float top = radius;
        float right = radius*3;
        float bottom = radius*3;
        paint.setColor(Color.argb(255,113,171,253));
        canvas.drawRect(left,top,right,bottom,paint);
        paint.setColor(Color.argb(255,248,206,69));
        dstCanvas.drawCircle(radius,radius,radius,paint);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int layerId = canvas.saveLayer(0,0,getMeasuredWidth(),getMeasuredHeight(),null,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dst,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawBitmap(src,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }


}
