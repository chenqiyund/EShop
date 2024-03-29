package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/6/17.
 */

public class CategoryHome extends CategoryBase {
    @SerializedName("goods")
    private List<SimpleGoods> mHotGoodsList; // 首页分类的推荐商品.

    public List<SimpleGoods> getHotGoodsList() {
        return mHotGoodsList;
    }
}
