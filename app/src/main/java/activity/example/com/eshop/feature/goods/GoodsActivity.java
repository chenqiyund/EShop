package activity.example.com.eshop.feature.goods;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseActivity;
import activity.example.com.eshop.base.GoodsPopupWindow;
import activity.example.com.eshop.base.wrapper.ToastWrapper;
import activity.example.com.eshop.base.wrapper.ToolbarWrapper;
import activity.example.com.eshop.network.api.ApiGoodsInfo;
import activity.example.com.eshop.network.core.ApiPath;
import activity.example.com.eshop.network.core.ResponseEntity;
import activity.example.com.eshop.network.entity.GoodsInfo;
import activity.example.com.eshop.network.entity.GoodsInfoRsp;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/6/18.
 */


/** 商品页面
 * 主要切换三个Fragment：
 * 1. 商品页面
 * 2. 详情页面
 * 3. 评价页面
 */
public class GoodsActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private static final String EXTRA_GOODS_ID = "EXTRA_GOOD_ID";
    @BindView(R.id.pager_goods)
    ViewPager mGoodsPager;
    @BindViews({R.id.text_tab_goods,R.id.text_tab_details,R.id.text_tab_comments})
    List<TextView> mTvTabList;
    private GoodsInfo mGoodsInfo;
    private GoodsPopupWindow mGoodsPopupWindow;

    // 提供一个跳转的方法
    public static Intent getStartIntent(Context context, int goodsId) {
        Intent intent = new Intent(context, GoodsActivity.class);
        intent.putExtra(EXTRA_GOODS_ID, goodsId);
        return intent;
    }
    // 填充选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_goods,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 设置选项菜单的item选择事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.menu_share){
            ToastWrapper.show(R.string.action_share);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_goods;
    }

    @Override
    protected void initView() {
        // toolbar
        new ToolbarWrapper(this);

        // ViewPager：获取到数据之后再去给Viewpager设置适配器
        mGoodsPager.addOnPageChangeListener(this);

        // 获取数据
        // 拿到传递的数据
        int goodsId = getIntent().getIntExtra(EXTRA_GOODS_ID, 0);
        enqueue(new ApiGoodsInfo(goodsId));

    }

    @OnClick({R.id.button_show_cart,R.id.button_add_cart,R.id.button_buy})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_show_cart:
                break;
            case R.id.button_add_cart:
                showGoodsPopupWindow();
                break;
            case R.id.button_buy:
                showGoodsPopupWindow();
                break;
            default:
                throw new UnsupportedOperationException("Unsupported View");
        }
    }
    // 展示商品弹窗
    private void showGoodsPopupWindow() {
        if (mGoodsInfo==null) return;
        if (mGoodsPopupWindow==null){
            mGoodsPopupWindow = new GoodsPopupWindow(this,mGoodsInfo);
        }
        mGoodsPopupWindow.show(new GoodsPopupWindow.OnConfirmListener() {
            @Override
            public void onConfirm(int number) {
                ToastWrapper.show("Confirm:"+number);
                mGoodsPopupWindow.dismiss();
            }
        });
    }
    // 三个TextView标题的切换事件
    @OnClick({R.id.text_tab_goods,R.id.text_tab_details,R.id.text_tab_comments})
    public void onClickTab(TextView textView){
        // 拿到我们点击的哪一项、ViewPager设置到当前项、改变选中的样式
        int position = mTvTabList.indexOf(textView);
        mGoodsPager.setCurrentItem(position,false);
        chooseTab(position);
    }


    // 拿到数据处理
    @Override
    protected void onBusinessResponse(String path, boolean isSucces, ResponseEntity responseEntity) {
        switch (path){
            case ApiPath.GOODS_INFO:
                if (isSucces){
                    GoodsInfoRsp goodsInfoRsp = (GoodsInfoRsp) responseEntity;
                    // 请求得到的商品详情的响应数据
                    mGoodsInfo = goodsInfoRsp.getData();
                    // 数据要给ViewPager的适配器设置上，展示
                    mGoodsPager.setAdapter(new GoodsPagerAdapter(getSupportFragmentManager(), mGoodsInfo));
                    // 默认选择第一项
                    chooseTab(0);

                }
                break;
            default:
                throw new UnsupportedOperationException(path);
        }
    }

    // 滑动中
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    // 页面选择
    @Override
    public void onPageSelected(int position) {
        // 是不是也要相应的改变上面的TextView的展示
        chooseTab(position);
    }

    // 页面滑动状态变化
    @Override
    public void onPageScrollStateChanged(int state) {
    }
    // 切换页面的方法
    public void selectPage(int position){
        mGoodsPager.setCurrentItem(position,false);
        chooseTab(position);
    }

    // 主要是改变选中的Tab的样式：颜色和字体大小
    private void chooseTab(int position){
        Resources resources = getResources();
        for (int i = 0; i < mTvTabList.size(); i++) {
            mTvTabList.get(i).setSelected(i==position);
            float textSize = i==position?resources.getDimension(R.dimen.font_large):resources.getDimension(R.dimen.font_normal);
            mTvTabList.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        }
    }
}
