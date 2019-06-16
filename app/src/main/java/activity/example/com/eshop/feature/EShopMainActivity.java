package activity.example.com.eshop.feature;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;

import activity.example.com.eshop.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/6/16.
 */

public class EShopMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop_main);
        setContentView(R.layout.test);
        ButterKnife.bind(this);

        /**
         * 1. 设置监听
         * 2. 各种连接
         * 3. 上下文的引用
         *
         * 非静态的内部类(匿名内部类) 会因为持有外部类的引用
         * 解决方法：静态的内部类+弱引用
         *
         */

    }

    @OnClick(R.id.button)
    public void onClick(View view){
        startAsyncTask();
    }

    public void startAsyncTask(){
        new MyAsyncTask(this).execute();
    }

    public static class MyAsyncTask extends AsyncTask<Void,Void,Void> {

        private WeakReference<Activity> mWeakReference;

        public MyAsyncTask(Activity activity) {
            mWeakReference = new WeakReference<Activity>(activity);
        }

        @Override
        protected Void doInBackground(Void... params) {

            Log.i("TAG","doInBackground");
            SystemClock.sleep(20*1000);

            return null;
        }
    }
}
