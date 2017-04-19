package cn.edu.stu.weiboapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by daidaijie on 2017/4/19.
 */

public class InfoLayout extends RelativeLayout {

    private TextView mTextView;
    private ImageView mIconImageView;
    private View mDivLineView;


    public InfoLayout(Context context) {
        this(context, null);
    }

    public InfoLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InfoLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.item_info_layout, this, true);
        mTextView = (TextView) findViewById(R.id.titleTextView);
        mIconImageView = (ImageView) findViewById(R.id.iconImageView);
        mDivLineView = findViewById(R.id.divLineView);


        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.InfoLayout, defStyleAttr, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.InfoLayout_title:
                    setTitle(typedArray.getString(attr));
                    break;
                case R.styleable.InfoLayout_icon:
                    setIcon(typedArray.getResourceId(attr, 0));
                    break;
                case R.styleable.InfoLayout_showDivLine:
                    setDivLineVisiable(typedArray.getBoolean(attr, false));
                    break;
            }
        }
    }

    public void setTitle(String title) {
        mTextView.setText(title);
    }

    public String getTitle() {
        return mTextView.getText().toString();
    }

    public void setIcon(int resId) {
        if (resId == 0) return;
        mIconImageView.setImageResource(resId);
    }

    public void setDivLineVisiable(boolean isVisiable) {
        if (isVisiable) {
            mDivLineView.setVisibility(VISIBLE);
        } else {
            mDivLineView.setVisibility(GONE);
        }
    }


}
