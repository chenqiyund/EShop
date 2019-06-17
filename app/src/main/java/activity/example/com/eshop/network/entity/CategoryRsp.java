package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019/6/16.
 *
 */
// 暂时使用的商品分类的响应体
public class CategoryRsp {
    @SerializedName("data")
    private List<CategoryPrimary> mData;

    @SerializedName("status")
    private Status mStatus;

    public Status getStatus() {
        return mStatus;
    }

    public List<CategoryPrimary> getData() {
        return mData;
    }
}
