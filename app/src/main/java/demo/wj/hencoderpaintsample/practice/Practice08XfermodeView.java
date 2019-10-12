package demo.wj.hencoderpaintsample.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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


public class Practice08XfermodeView extends GridView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    ArrayList<Item> modes = new ArrayList();


    public class Item{
        public String modeName;
        public PorterDuff.Mode mode;

        public Item(String modeName, PorterDuff.Mode mode) {
            this.modeName = modeName;
            this.mode = mode;
        }
    }

    public Practice08XfermodeView(Context context) {
        super(context);
        init();
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        modes.add(new Item("CLEAR",PorterDuff.Mode.CLEAR));
        modes.add(new Item("SRC",PorterDuff.Mode.SRC));
        modes.add(new Item("DST",PorterDuff.Mode.DST));
        modes.add(new Item("SRC_OVER",PorterDuff.Mode.SRC_OVER));
        modes.add(new Item("DST_OVER",PorterDuff.Mode.DST_OVER));
        modes.add(new Item("SRC_IN",PorterDuff.Mode.SRC_IN));
        modes.add(new Item("DST_IN",PorterDuff.Mode.DST_IN));
        modes.add(new Item("SRC_OUT",PorterDuff.Mode.SRC_OUT));
        modes.add(new Item("DST_OUT",PorterDuff.Mode.DST_OUT));
        modes.add(new Item("SRC_ATOP",PorterDuff.Mode.SRC_ATOP));
        modes.add(new Item("DST_ATOP",PorterDuff.Mode.DST_ATOP));
        modes.add(new Item("XOR",PorterDuff.Mode.XOR));
        modes.add(new Item("DARKEN",PorterDuff.Mode.DARKEN));
        modes.add(new Item("LIGHTEN",PorterDuff.Mode.LIGHTEN));
        modes.add(new Item("MULTIPLY",PorterDuff.Mode.MULTIPLY));
        modes.add(new Item("SCREEN",PorterDuff.Mode.SCREEN));
        setAdapter(new MyAdpter());

    }


    public class MyAdpter extends BaseAdapter{
        @Override
        public int getCount() {
            return modes.size();
        }

        @Override
        public Item getItem(int position) {
            return modes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_xfermode,null,false);
                holder = new ViewHolder();
                holder.textView = convertView.findViewById(R.id.name);
                holder.xfermode = convertView.findViewById(R.id.xfermode);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            Item item = modes.get(position);
            holder.textView.setText(item.modeName);
            holder.xfermode.setMode(item.mode);
            return convertView;
        }
    }

    class ViewHolder {
        TextView textView;
        XfermodeView xfermode;
    }


}
