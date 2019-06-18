package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import activity.example.com.eshop.network.core.RequestParam;

/**
 * Created by Administrator on 2019/6/18.
 */

// 商品详情请求体
public class GoodsInfoReq extends RequestParam {

    @SerializedName("goods_id")
    private int mGoodsId;

    public int getGoodsId() {
        return mGoodsId;
    }

    public void setGoodsId(int goodsId) {
        mGoodsId = goodsId;
    }
}
