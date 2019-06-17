package activity.example.com.eshop.feature.category;


import android.view.View;
import android.widget.TextView;
import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseListAdapter;
import activity.example.com.eshop.network.entity.CategoryBase;
import butterknife.BindView;

/**
 * Created by Administrator on 2019/6/17.
 */
//子类适配器
public class ChildrenAdapter extends BaseListAdapter<CategoryBase,ChildrenAdapter.ViewHolder> {

    @Override
    protected int getItemViewLayout() {
        return R.layout.item_children_category;
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
            mTextCategory.setText(getItem(position).getName());
        }
    }
}
