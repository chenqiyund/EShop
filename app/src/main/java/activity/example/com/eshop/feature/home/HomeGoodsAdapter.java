package activity.example.com.eshop.feature.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import activity.example.com.eshop.R;
import activity.example.com.eshop.base.BaseListAdapter;
import activity.example.com.eshop.base.wrapper.ToastWrapper;
import activity.example.com.eshop.network.entity.CategoryHome;
import activity.example.com.eshop.network.entity.Picture;
import activity.example.com.eshop.network.entity.SimpleGoods;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/6/17.
 */

// 首页：推荐商品的适配器
public class HomeGoodsAdapter extends BaseListAdapter<CategoryHome,HomeGoodsAdapter.ViewHolder> {

    @Override
    protected int getItemViewLayout() {
        return R.layout.item_home_goods;
    }

    @Override
    protected ViewHolder getItemViewHolder(View view) {
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseListAdapter.ViewHolder{

        @BindView(R.id.text_category)
        TextView mTvCategory;

        @BindViews({
                R.id.image_goods_01,
                R.id.image_goods_02,
                R.id.image_goods_03,
                R.id.image_goods_04})
        ImageView[] mImageViews;
        private CategoryHome mCategoryHome;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(int position) {
            mCategoryHome = getItem(position);
            mTvCategory.setText(mCategoryHome.getName());
            final List<SimpleGoods> goodsList = mCategoryHome.getHotGoodsList();
            for (int i = 0; i < mImageViews.length; i++) {

                // 取出商品List里面的商品图片
                Picture picture = goodsList.get(i).getImg();
                //                mImageViews[i].setImageResource(R.drawable.image_holder_goods);
                // Picasso加载图片
                Picasso.with(getContext()).load(picture.getLarge()).into(mImageViews[i]);

                final int index = i;
                // 设置点击事件
                mImageViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SimpleGoods simpleGoods = goodsList.get(index);
                        ToastWrapper.show(simpleGoods.getName());
                    }
                });
            }
        }

        @OnClick(R.id.text_category)
        void onclick(){
            ToastWrapper.show(mCategoryHome.getName());
        }
    }

}
