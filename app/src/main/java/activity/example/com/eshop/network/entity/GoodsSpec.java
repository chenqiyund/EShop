package activity.example.com.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/6/18.
 */
// 商品规格
public class GoodsSpec {
    public static final int ATTR_TYPE_UNIQUE = 0;
    public static final int ATTR_TYPE_SINGLE = 1;
    public static final int ATTR_TYPE_MULTIPLE = 2;

    @SerializedName("attr_type") private int mAttrType;

    @SerializedName("name") private String mAttrName;


    public static class GoodsValue {

        @SerializedName("id") private int mId;

        @SerializedName("label") private String mLabel;

        @SerializedName("price") private float mPrice;

        @SerializedName("format_price") private String mFormatPrice;
    }
}
