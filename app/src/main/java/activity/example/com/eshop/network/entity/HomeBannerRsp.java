package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import activity.example.com.eshop.network.core.ResponseEntity;

/**
 * 首页轮播图接口响应体.
 */

public class HomeBannerRsp extends ResponseEntity {
    @SerializedName("data") private Data mData;

    public Data getData() {
        return mData;
    }

    public static class Data {

        // 首页轮播图
        @SerializedName("player") private List<Banner> mBanners;

        // 首页促销商品
        @SerializedName("promote_goods") private List<SimpleGoods> mGoodsList;

        public List<Banner> getBanners() {
            return mBanners;
        }

        public List<SimpleGoods> getGoodsList() {
            return mGoodsList;
        }
    }
}
