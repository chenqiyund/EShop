package activity.example.com.eshop.network.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import activity.example.com.eshop.network.core.ApiInterface;
import activity.example.com.eshop.network.core.ApiPath;
import activity.example.com.eshop.network.core.RequestParam;
import activity.example.com.eshop.network.core.ResponseEntity;
import activity.example.com.eshop.network.entity.CategoryRsp;

/**
 * Created by Administrator on 2019/6/18.
 */

// 服务器接口：获取商品的分类信息
public class ApiCategory implements ApiInterface {

    @NonNull
    @Override
    public String getPath() {
        return ApiPath.CATEGORY;
    }

    @Nullable
    @Override
    public RequestParam getRequestParam() {
        return null;
    }

    @NonNull
    @Override
    public Class<? extends ResponseEntity> getResponseEntity() {
        return CategoryRsp.class;
    }
}
