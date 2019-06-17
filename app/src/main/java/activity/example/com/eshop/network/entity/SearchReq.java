package activity.example.com.eshop.network.entity;


import com.google.gson.annotations.SerializedName;

public class SearchReq {
    @SerializedName("filter") private Filter mFilter;

    @SerializedName("pagination") private Pagination mPagination;

    public void setFilter(Filter filter) {
        mFilter = filter;
    }

    public void setPagination(Pagination pagination) {
        mPagination = pagination;
    }
}
