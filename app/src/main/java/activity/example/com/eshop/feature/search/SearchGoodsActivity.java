package activity.example.com.eshop.feature.search;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseActivity;
import activity.example.com.eshop.base.widgets.SimpleSearchView;
import activity.example.com.eshop.base.wrapper.PtrWrapper;
import activity.example.com.eshop.base.wrapper.ToastWrapper;
import activity.example.com.eshop.base.wrapper.ToolbarWrapper;
import activity.example.com.eshop.network.entity.Filter;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by Administrator on 2019/6/17.
 */
//搜索商品页面
public class SearchGoodsActivity extends BaseActivity {

    private static final String EXTRA_SEARCH_FILTER = "EXTRA_SEARCH_FILTER";
    @BindView(R.id.search_view)
    SimpleSearchView mSearchView;
    @BindView(R.id.list_goods)
    ListView mGoodsListView;
    @BindViews({R.id.text_is_hot,R.id.text_most_expensive,R.id.text_category})
    List<TextView> mTvOrderList;
    private Filter mFilter;
    private PtrWrapper mPtrWrapper;
    private SearchGoodsAdapter mGoodsAdapter;
    // 因为需要传递数据，为了规范我们传递的数据内容，所以我们在此页面对外提供一个跳转的方法
    public static Intent getStartIntent(Context context, Filter filter) {
        Intent intent = new Intent(context, SearchGoodsActivity.class);
        intent.putExtra(EXTRA_SEARCH_FILTER, new Gson().toJson(filter));
        return intent;
    }

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_search_goods;
    }

    @Override
    protected void initView() {
        // toolbar的展示
        new ToolbarWrapper(this);
        // 一进入，默认选择热销
        mTvOrderList.get(0).setActivated(true);

        // 取出传递的数据
        String filterStr = getIntent().getStringExtra(EXTRA_SEARCH_FILTER);
        mFilter = new Gson().fromJson(filterStr, Filter.class);

        // 刷新加载
        mPtrWrapper = new PtrWrapper(this,true) {

            // 刷新
            @Override
            protected void onRefresh() {
                // 要进行网络请求获取数据
                searchGoods(true);
            }

            // 加载
            @Override
            protected void onLoadMore() {
                // 也是要进行请求，和刷新是一个接口，只是分页的参数不一样
                searchGoods(false);
            }
        };

        // 搜索控件的监听
        mSearchView.setOnSearchListener(new SimpleSearchView.OnSearchListener() {
            // 当去搜索会触发
            @Override
            public void search(String query) {
                mFilter.setKeywords(query);
                mPtrWrapper.autoRefresh();
            }
        });

        // 处理ListView:设置适配器
        mGoodsAdapter = new SearchGoodsAdapter();
        mGoodsListView.setAdapter(mGoodsAdapter);

        // 自动刷新
        mPtrWrapper.postRefreshDelayed(50);

    }

    @OnItemClick(R.id.list_goods)
    public void goodsItemClick(int position){
        // TODO: 2017/3/2  跳转到详情页
        ToastWrapper.show(mGoodsAdapter.getItem(position).getName());
    }

    @OnClick({R.id.text_is_hot,R.id.text_most_expensive,R.id.text_cheapest})
    public void chooseGoodsOrder(View view){
        switch (view.getId()){
            case R.id.text_is_hot:
                break;
            case R.id.text_most_expensive:
                break;
            case R.id.text_cheapest:
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    // 网络请求获取数据
    private void searchGoods(boolean isRefresh) {

    }
}
