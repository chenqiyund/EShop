package activity.example.com.eshop.feature.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseListAdapter;
import activity.example.com.eshop.network.entity.CategoryPrimary;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/6/17.
 */
// 一级分类的适配器
public class CategoryAdapter extends BaseListAdapter<CategoryPrimary,CategoryAdapter.ViewHolder> {


    @Override
    protected int getItemViewLayout() {
        return R.layout.item_primary_category;
    }

    @Override
    protected ViewHolder getItemViewHolder(View view) {
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseListAdapter.ViewHolder{
        @BindView(R.id.text_category)
        TextView mTextCategory;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(int position) {
            // 数据的展示
            mTextCategory.setText(getItem(position).getName());
        }
    }
}
