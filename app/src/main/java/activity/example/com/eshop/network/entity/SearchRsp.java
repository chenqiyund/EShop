package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import activity.example.com.eshop.network.core.ResponseEntity;

/**
 * Created by Administrator on 2019/6/17.
 */
// 搜索商品的响应体
public class SearchRsp extends ResponseEntity {


    @SerializedName("data") private List<SimpleGoods> mData;

    @SerializedName("paginated") private Paginated mPaginated;

    public List<SimpleGoods> getData() {
        return mData;
    }

    public Paginated getPaginated() {
        return mPaginated;
    }

}
