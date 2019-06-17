package activity.example.com.eshop.network.core;

import com.google.gson.annotations.SerializedName;

import activity.example.com.eshop.network.entity.Status;

/**
 * Created by Administrator on 2019/6/17.
 */
// 响应的实体基类：为了防止直接实例化，所以做成抽象类
public abstract class ResponseEntity {
    @SerializedName("status")
    private Status mStatus;

    public Status getStatus() {
        return mStatus;
    }
}
