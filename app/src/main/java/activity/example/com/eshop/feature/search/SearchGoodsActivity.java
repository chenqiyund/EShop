package activity.example.com.eshop.feature.search;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseActivity;
import activity.example.com.eshop.base.widgets.SimpleSearchView;
import activity.example.com.eshop.base.wrapper.ToolbarWrapper;
import activity.example.com.eshop.network.entity.Filter;
import butterknife.BindView;

/**
 * Created by Administrator on 2019/6/17.
 */
//搜索商品页面
public class SearchGoodsActivity extends BaseActivity {

    private static final String EXTRA_SEARCH_FILTER = "EXTRA_SEARCH_FILTER";
    @BindView(R.id.search_view)
    SimpleSearchView mSearchView;
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
    }
}
