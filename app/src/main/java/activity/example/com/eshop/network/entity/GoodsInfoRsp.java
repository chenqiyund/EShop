package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import activity.example.com.eshop.network.core.ResponseEntity;

/**
 * Created by Administrator on 2019/6/18.
 */

// 商品详情的响应体
public class GoodsInfoRsp extends ResponseEntity {

    @SerializedName("data")
    private GoodsInfo mData;

    public GoodsInfo getData() {
        return mData;
    }

}
