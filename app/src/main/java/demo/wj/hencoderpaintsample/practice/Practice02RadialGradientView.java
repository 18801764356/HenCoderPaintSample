package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice02RadialGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice02RadialGradientView(Context context) {
        super(context);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(padding,padding);

        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
        drawCircle(canvas,0,0,radius,radius,radius, Shader.TileMode.CLAMP);

        // RadialGradient 的参数：坐标：(0, 0) 到 (200, 200) ；颜色：#E91E63 到 #2196F3 只渐变一半，剩下的看填充效果
        drawCircle(canvas,radius*2+padding,0,radius,radius,radius/2, Shader.TileMode.CLAMP);

        // RadialGradient 的参数：坐标：(0, 0) 到 (200, 200) ；颜色：#E91E63 到 #2196F3 只渐变一半，剩下的看填充效果
        drawCircle(canvas,0,radius*2+padding,radius,radius,radius/2, Shader.TileMode.MIRROR);

        // RadialGradient 的参数：坐标：(0, 0) 到 (200, 200) ；颜色：#E91E63 到 #2196F3 只渐变一半，剩下的看填充效果
        drawCircle(canvas,radius*2+padding,radius*2+padding,radius,radius,radius/2, Shader.TileMode.REPEAT);


        canvas.restore();
    }


    int radius = 150;
    int padding = 50;

    private void drawCircle(Canvas canvas, float tx, float ty, float centerX,float centerY,float radius, Shader.TileMode mode) {
        canvas.save();
        canvas.translate(tx,ty);
        paint.setShader(new RadialGradient(centerX,centerY,radius, Color.parseColor("#E91E63"),Color.parseColor("#2196F3"), mode));
        canvas.drawCircle(centerX, centerY, this.radius, paint);
        canvas.restore();
    }
}
