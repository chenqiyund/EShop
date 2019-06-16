package activity.example.com.eshop.feature;

import android.os.Bundle;
import android.util.Log;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.utils.LogUtils;

/**
 * Created by Administrator on 2019/6/15.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
