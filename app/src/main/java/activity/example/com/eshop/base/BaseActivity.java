package activity.example.com.eshop.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/6/17.
 */
// 通用的Activity的基类

public abstract class BaseActivity extends TransitionActivity{
    private Unbinder mUnbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayout());

        mUnbinder = ButterKnife.bind(this);

        initView();
    }

    protected abstract void initView();

    // 让子类来告诉我们布局
    @LayoutRes protected abstract int getContentViewLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder = null;
    }
}
