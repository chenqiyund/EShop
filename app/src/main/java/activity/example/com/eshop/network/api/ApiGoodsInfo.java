package activity.example.com.eshop.network.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import activity.example.com.eshop.network.core.ApiInterface;
import activity.example.com.eshop.network.core.ApiPath;
import activity.example.com.eshop.network.core.RequestParam;
import activity.example.com.eshop.network.core.ResponseEntity;
import activity.example.com.eshop.network.entity.GoodsInfoReq;
import activity.example.com.eshop.network.entity.GoodsInfoRsp;

/**
 * Created by Administrator on 2019/6/18.
 */

// 服务器接口：商品详情的请求
public class ApiGoodsInfo implements ApiInterface {

    // 构建请求体数据
    GoodsInfoReq mGoodsInfoReq;

    public ApiGoodsInfo(int goodsId) {
        mGoodsInfoReq = new GoodsInfoReq();
        mGoodsInfoReq.setGoodsId(goodsId);
    }

    @NonNull
    @Override
    public String getPath() {
        return ApiPath.GOODS_INFO;
    }

    @Nullable
    @Override
    public RequestParam getRequestParam() {
        return mGoodsInfoReq;
    }

    @NonNull
    @Override
    public Class<? extends ResponseEntity> getResponseEntity() {
        return GoodsInfoRsp.class;
    }
}
