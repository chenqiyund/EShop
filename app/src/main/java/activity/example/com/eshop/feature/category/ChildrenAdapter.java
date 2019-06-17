package activity.example.com.eshop.feature.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.network.entity.CategoryBase;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/6/17.
 */

public class ChildrenAdapter extends BaseAdapter {
    private List<CategoryBase> mData = new ArrayList<>();

    // 对外提供一个方法
    public void reset(List<CategoryBase> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_children_category, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mTextCategory.setText(mData.get(position).getName());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.text_category)
        TextView mTextCategory;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
