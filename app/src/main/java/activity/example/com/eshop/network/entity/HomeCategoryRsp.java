package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import activity.example.com.eshop.network.core.ResponseEntity;

/**
 * 首页商品分类接口响应体.
 */

public class HomeCategoryRsp extends ResponseEntity {

    @SerializedName("data") private List<CategoryHome> mData;

    public List<CategoryHome> getData() {
        return mData;
    }

}
