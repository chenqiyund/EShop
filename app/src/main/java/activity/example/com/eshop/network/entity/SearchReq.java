package activity.example.com.eshop.network.entity;


import com.google.gson.annotations.SerializedName;

import activity.example.com.eshop.network.core.RequestParam;


// 搜索商品的请求体
public class SearchReq extends RequestParam {
    @SerializedName("filter") private Filter mFilter;

    @SerializedName("pagination") private Pagination mPagination;

    public void setFilter(Filter filter) {
        mFilter = filter;
    }

    public void setPagination(Pagination pagination) {
        mPagination = pagination;
    }
}
