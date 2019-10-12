package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import demo.wj.hencoderpaintsample.R;


public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Bitmap bt  = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
        bitmap = Bitmap.createScaledBitmap(bt,300,300,false);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter
        paint.setColor(Color.RED);
        // 第一个：NORMAL
        canvas.save();
        canvas.translate(50,50);
        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
//        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.drawRect(0,0,300,300,paint);
        canvas.restore();

        // 第二个：INNER
        canvas.save();
        canvas.translate(400,50);
        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
//        canvas.drawBitmap(bitmap,0,0,paint);/
        canvas.drawRect(0,0,300,300,paint);
        canvas.restore();

        // 第三个：OUTER
        canvas.save();
        canvas.translate(50,400);
        paint.setMaskFilter(new BlurMaskFilter(200, BlurMaskFilter.Blur.OUTER));
        canvas.drawRect(0,0,300,300,paint);
//        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();

        // 第四个：SOLID
        canvas.save();
        canvas.translate(400,400);
        paint.setMaskFilter(new BlurMaskFilter(200, BlurMaskFilter.Blur.SOLID));
        canvas.drawRect(0,0,300,300,paint);
//        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
    }
}
