package activity.example.com.eshop.feature.goods;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import activity.example.com.eshop.base.utils.TestFragment;
import activity.example.com.eshop.network.entity.GoodsInfo;

/**
 * Created by Administrator on 2019/6/18.
 */

// 商品页面的适配器
public class GoodsPagerAdapter extends FragmentPagerAdapter {

    // 数据的传递
    private GoodsInfo mGoodsInfo;

    public GoodsPagerAdapter(FragmentManager fm, GoodsInfo goodsInfo) {
        super(fm);
        this.mGoodsInfo = goodsInfo;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TestFragment.newInstance(mGoodsInfo.getName());
            case 1:
                return TestFragment.newInstance("goods details");
            case 2:
                return TestFragment.newInstance("goods comments");
            default:
                throw new UnsupportedOperationException("Position" + position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
