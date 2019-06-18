package activity.example.com.eshop.network;

import android.test.AndroidTestCase;

import com.google.gson.Gson;

import activity.example.com.eshop.network.api.ApiCategory;
import activity.example.com.eshop.network.api.ApiGoodsInfo;
import activity.example.com.eshop.network.api.ApiHomeBanner;
import activity.example.com.eshop.network.api.ApiHomeCategory;
import activity.example.com.eshop.network.api.ApiSearch;
import activity.example.com.eshop.network.entity.CategoryRsp;
import activity.example.com.eshop.network.entity.GoodsInfoRsp;
import activity.example.com.eshop.network.entity.HomeBannerRsp;
import activity.example.com.eshop.network.entity.HomeCategoryRsp;
import activity.example.com.eshop.network.entity.SearchReq;
import activity.example.com.eshop.network.entity.SearchRsp;
import okhttp3.Call;
import okhttp3.Response;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Administrator on 2019/6/16.
 * 单元测试：测试接口
 */

public class EShopClientTest {
    // 分类页面
    public void getCategory() throws Exception {

        CategoryRsp categoryRsp = EShopClient.getInstance().execute(new ApiCategory());
        // 断言方法：为我们做一个判断
        assertTrue(categoryRsp.getStatus().isSucceed());
    }
    // 首页：banner
    public void getHomeBanner() throws Exception{
        HomeBannerRsp bannerRsp = EShopClient.getInstance().execute(new ApiHomeBanner());
        assertTrue(bannerRsp.getStatus().isSucceed());
    }
    // 首页：分类和推荐商品
    public void getHomeCategory() throws Exception{
        HomeCategoryRsp categoryRsp = EShopClient.getInstance().execute(new ApiHomeCategory());
        assertTrue(categoryRsp.getStatus().isSucceed());
    }
    public void getSearch() throws Exception{
        ApiSearch apiSearch = new ApiSearch(null,null);
        SearchRsp searchRsp = EShopClient.getInstance().execute(apiSearch);
        assertTrue(searchRsp.getStatus().isSucceed());
    }
    // 商品详情的请求

    public void getGoodsInfo() throws Exception{
        ApiGoodsInfo apiGoodsInfo = new ApiGoodsInfo(78);
        GoodsInfoRsp goodsInfoRsp = EShopClient.getInstance().execute(apiGoodsInfo);
        assertTrue(goodsInfoRsp.getStatus().isSucceed());
    }
}
