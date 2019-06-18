package activity.example.com.eshop.network.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import activity.example.com.eshop.network.core.ApiInterface;
import activity.example.com.eshop.network.core.ApiPath;
import activity.example.com.eshop.network.core.RequestParam;
import activity.example.com.eshop.network.core.ResponseEntity;
import activity.example.com.eshop.network.entity.Filter;
import activity.example.com.eshop.network.entity.Pagination;
import activity.example.com.eshop.network.entity.SearchReq;
import activity.example.com.eshop.network.entity.SearchRsp;

/**
 * Created by Administrator on 2019/6/18.
 */

// 服务器接口：搜索商品，POST请求，有请求体
public class ApiSearch implements ApiInterface {

    private SearchReq mSearchReq;

    // 根据传入的参数构建请求体数据
    public ApiSearch(Filter filter, Pagination pagination) {
        mSearchReq = new SearchReq();
        mSearchReq.setFilter(filter);
        mSearchReq.setPagination(pagination);
    }

    @NonNull
    @Override
    public String getPath() {
        return ApiPath.SEARCH;
    }

    @Nullable
    @Override
    public RequestParam getRequestParam() {
        return mSearchReq;
    }

    @NonNull
    @Override
    public Class<? extends ResponseEntity> getResponseEntity() {
        return SearchRsp.class;
    }
}
