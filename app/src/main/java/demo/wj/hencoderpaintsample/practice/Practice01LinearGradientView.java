package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(padding,padding);

        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(0, 0) 到 (radius*2, radius*2) ；颜色：#E91E63 到 #2196F3
        drawCircle(canvas,0,0,radius*2,radius*2, Shader.TileMode.CLAMP);

        // LinearGradient 的参数：坐标：(0, 0) 到 (200, 200) ；颜色：#E91E63 到 #2196F3 只渐变一半，剩下的看填充效果
        drawCircle(canvas,radius*2+padding,0,radius,radius, Shader.TileMode.CLAMP);

        // LinearGradient 的参数：坐标：(0, 0) 到 (200, 200) ；颜色：#E91E63 到 #2196F3 只渐变一半，剩下的看填充效果
        drawCircle(canvas,0,radius*2+padding,radius,radius, Shader.TileMode.MIRROR);

        // LinearGradient 的参数：坐标：(0, 0) 到 (200, 200) ；颜色：#E91E63 到 #2196F3 只渐变一半，剩下的看填充效果
        drawCircle(canvas,radius*2+padding,radius*2+padding,radius,radius, Shader.TileMode.REPEAT);


        canvas.restore();
    }


    int radius = 150;
    int padding = 50;

    private void drawCircle(Canvas canvas, float tx, float ty, int endX, int endY, Shader.TileMode mode) {
        canvas.save();
        canvas.translate(tx,ty);
        paint.setShader(new LinearGradient(0,0,endX,endY, Color.parseColor("#E91E63"),Color.parseColor("#2196F3"), mode));
        canvas.drawCircle(radius, radius, radius, paint);
        canvas.restore();
    }
}
