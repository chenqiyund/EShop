package activity.example.com.eshop.feature;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import activity.example.com.eshop.base.wrapper.ToastWrapper;

/**
 * Created by Administrator on 2019/6/16.
 */

public class EShopApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {

            // 这个是用于分析内存的线程，我们不能再这里面初始化我们项目
            // 这个是用于分析内存的线程，我们不能在这里面初始化我们项目
            return;
        }
        LeakCanary.install(this);

        // Toast的包装类的初始化
        ToastWrapper.init(this);

    }
}
