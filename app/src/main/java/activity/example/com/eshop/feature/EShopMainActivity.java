package activity.example.com.eshop.feature;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import activity.example.com.eshop.R;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2019/6/16.
 */

public class EShopMainActivity extends AppCompatActivity implements OnTabSelectListener {

    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop_main);

        /**
         * 1. 设置监听
         * 2. 各种连接
         * 3. 上下文的引用
         *
         * 非静态的内部类(匿名内部类) 会因为持有外部类的引用
         * 解决方法：静态的内部类+弱引用
         *
         */
        ButterKnife.bind(this);
        initView();
    }

    // 视图的初始化操作
    private void initView() {
        // 设置导航选择的监听事件
        mBottomBar.setOnTabSelectListener(this);
    }
    // 底部导航栏某一项选择的时候触发
    @Override
    public void onTabSelected(@IdRes int tabId) {

        switch (tabId) {
            case R.id.tab_home:
                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_category:
                Toast.makeText(this, "分类", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_cart:
                Toast.makeText(this, "购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_mine:
                Toast.makeText(this, "我的", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new UnsupportedOperationException("unsupport");
        }
    }
}
