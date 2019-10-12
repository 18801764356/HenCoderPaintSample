package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import androidx.annotation.Nullable;

import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import demo.wj.hencoderpaintsample.R;

public class Practice05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice05ComposeShaderView(Context context) {
        super(context);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap batman = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap batman01 = Bitmap.createScaledBitmap(batman,400,400,true);
        Bitmap batman_logo = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        Bitmap batman_logo01 = Bitmap.createScaledBitmap(batman_logo,400,400,true);
        BitmapShader batmanShader = new BitmapShader(batman01, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        BitmapShader batmanLogoShader = new BitmapShader(batman_logo01, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        ComposeShader shader = new ComposeShader(batmanShader,batmanLogoShader,  PorterDuff.Mode.DST_IN);
        paint.setShader(shader);
        canvas.drawCircle(200, 200, 200, paint);

        canvas.save();
        canvas.translate(450,0);
        ComposeShader shader1 = new ComposeShader(batmanShader,batmanLogoShader,  PorterDuff.Mode.DST_OUT);
        paint.setShader(shader1);
        canvas.drawCircle(200, 200, 200, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0,450);
        ComposeShader shader2 = new ComposeShader(batmanShader,batmanLogoShader,  PorterDuff.Mode.SRC_IN);
        paint.setShader(shader2);
        canvas.drawCircle(200, 200, 200, paint);
        canvas.restore();


        canvas.save();
        canvas.translate(450,450);
        ComposeShader shader3 = new ComposeShader(batmanShader,batmanLogoShader,  PorterDuff.Mode.XOR);
        paint.setShader(shader3);
        canvas.drawCircle(200, 200, 200, paint);
        canvas.restore();
    }
}
