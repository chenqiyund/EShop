package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Stack;

import activity.example.com.eshop.network.core.ResponseEntity;

/**
 * Created by Administrator on 2019/6/16.
 *
 */
// 暂时使用的商品分类的响应体
public class CategoryRsp extends ResponseEntity {
    @SerializedName("data")
    private List<CategoryPrimary> mData;

    public List<CategoryPrimary> getData() {
        return mData;
    }
}
