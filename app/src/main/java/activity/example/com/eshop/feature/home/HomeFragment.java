package activity.example.com.eshop.feature.home;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseFragment;
import activity.example.com.eshop.base.widgets.banner.BannerAdapter;
import activity.example.com.eshop.base.widgets.banner.BannerLayout;
import activity.example.com.eshop.network.entity.Banner;
import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2019/6/17.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.standard_toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.standard_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.list_home_goods)
    ListView mListHomeGoods;
    @BindView(R.id.standard_refresh_layout)
    PtrFrameLayout mRefreshLayout;
    private ImageView[] mIvPromotes = new ImageView[4];
    private TextView mMTvPromoteGoods;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getContentViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initToolbar();
        initPtr();
        // 设置适配器
        HomeGoodsAdapter goodsAdapter = new HomeGoodsAdapter();
        mListHomeGoods.setAdapter(goodsAdapter);

        // ListView的头布局
        View view = LayoutInflater.from(getContext()).inflate(R.layout.partial_home_header,mListHomeGoods,false);

        // 找到头布局里面的控件
        BannerLayout bannerLayout = ButterKnife.findById(view,R.id.layout_banner);
        BannerAdapter<Banner> bannerAdapter = new BannerAdapter<Banner>() {
            @Override
            protected void bind(ViewHolder holder, Banner data) {
                // 数据和视图的绑定
                // TODO: 2017/2/28 图片展示待实现
                holder.mImageView.setImageResource(R.drawable.image_holder_banner);
            }
        };
        bannerLayout.setAdapter(bannerAdapter);

        // 促销商品
        mIvPromotes[0] = ButterKnife.findById(view,R.id.image_promote_one);
        mIvPromotes[1] = ButterKnife.findById(view,R.id.image_promote_two);
        mIvPromotes[2] = ButterKnife.findById(view,R.id.image_promote_three);
        mIvPromotes[3] = ButterKnife.findById(view,R.id.image_promote_four);

        // 促销单品的TextView
        mMTvPromoteGoods = ButterKnife.findById(view, R.id.text_promote_goods);

        mListHomeGoods.addHeaderView(view);

    }

    // 刷新的初始化
    private void initPtr() {
        // 设置刷新显示的头布局、刷新事件等
        mRefreshLayout.disableWhenHorizontalMove(true);

        // 设置刷新显示的头布局：默认的
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
        mRefreshLayout.setHeaderView(header);
        mRefreshLayout.addPtrUIHandler(header);

        // 设置刷新处理的Handler
        mRefreshLayout.setPtrHandler(mPtrHandler);


        // 一进来我们就去刷新：自动刷新的方法，延时任务然后自动刷新
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 自动刷新
                mRefreshLayout.autoRefresh();
            }
        },50);
    }

    private PtrDefaultHandler2 mPtrHandler = new PtrDefaultHandler2() {

        // 加载时触发
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {

        }

        // 刷新的时候触发
        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {

        }
    };

    // 初始化Toolbar的操作
    private void initToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        // 设置Toolbar作为ActionBar
        activity.setSupportActionBar(mToolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbarTitle.setText(R.string.home_title);
    }
}
