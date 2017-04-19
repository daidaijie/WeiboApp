package cn.edu.stu.weiboapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView headImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headImageView = (ImageView) findViewById(R.id.headImageView);
        Glide.with(this)
                .load(R.drawable.shimu)
                .transform(new GlideCircleTransform(this))
                .into(headImageView);
    }
}
