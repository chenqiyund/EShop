package activity.example.com.eshop.feature.category;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.network.EShopClient;
import activity.example.com.eshop.network.core.UICallback;
import activity.example.com.eshop.network.entity.CategoryPrimary;
import activity.example.com.eshop.network.entity.CategoryRsp;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/6/17.
 */

public class CategoryFragment extends Fragment {
    @BindView(R.id.standard_toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.standard_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.list_category)
    ListView mListCategory;
    @BindView(R.id.list_children)
    ListView mListChildren;
    private List<CategoryPrimary> mData;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category,container,false);
        ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 初始化视图的操作
        initView();
    }

    private void initView() {

        // 处理toolbar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);
        // 处理actionbar不展示默认的标题
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle.setText(R.string.category_title);
        
        initToolbar();
        // ListView的展示
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        mListCategory.setAdapter(categoryAdapter);

        ChildrenAdapter childrenAdapter = new ChildrenAdapter();
        mListChildren.setAdapter(childrenAdapter);

        // 拿到数据
        if (mData != null) {
            // 可以直接更新UI
        } else {
            // 去进行网络请求拿到数据
            Call call = EShopClient.getInstance().getCategory();
            call.enqueue(new UICallback() {
                @Override
                public void onFailureInUI(Call call, IOException e) {
                    Toast.makeText(getContext(), "请求失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponseInUI(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        CategoryRsp categoryRsp = new Gson().fromJson(response.body().string(), CategoryRsp.class);
                        if (categoryRsp.getStatus().isSucceed()) {
                            mData = categoryRsp.getData();
                            // 数据有了之后，更新UI
                        }
                    }
                }
            });
        }

    }

    private void initToolbar() {
        // Fragment显示选项菜单
        setHasOptionsMenu(true);
        // 处理toolbar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);
        // 处理actionbar不展示默认的标题
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        // 设置左上方的返回箭头
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTitle.setText(R.string.category_title);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_category, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        // 返回箭头
        if (itemId == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }

        if (itemId == R.id.menu_search) {

            // 后期会跳转到搜素页面上
            Toast.makeText(getContext(), "点击了搜索", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
