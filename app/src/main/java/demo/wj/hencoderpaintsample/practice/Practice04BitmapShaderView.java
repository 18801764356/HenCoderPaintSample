package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;

import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import demo.wj.hencoderpaintsample.R;

public class Practice04BitmapShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice04BitmapShaderView(Context context) {
        super(context);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap bt = Bitmap.createScaledBitmap(bitmap,400,400,true);
        paint.setShader(new BitmapShader(bt, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawCircle(200, 200, 200, paint);

        Bitmap bt1 = Bitmap.createScaledBitmap(bitmap,200,200,false);
        canvas.save();
        canvas.translate(450,0);
        paint.setShader(new BitmapShader(bt1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRect(0,0,400,400,paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0,450);
        paint.setShader(new BitmapShader(bt1, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRect(0,0,400,400,paint);
        canvas.restore();
        canvas.save();

        canvas.translate(450,450);
        paint.setShader(new BitmapShader(bt1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        canvas.drawRect(0,0,400,400,paint);
        canvas.restore();

    }
}
