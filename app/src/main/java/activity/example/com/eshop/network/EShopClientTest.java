package activity.example.com.eshop.network;

import android.test.AndroidTestCase;

import com.google.gson.Gson;

import activity.example.com.eshop.network.entity.CategoryRsp;
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
    public void getCategory() throws Exception {

        CategoryRsp categoryRsp = EShopClient.getInstance().execute("/category", null, CategoryRsp.class);
        // 断言方法：为我们做一个判断
        assertTrue(categoryRsp.getStatus().isSucceed());
    }

    public void getHomeBanner() throws Exception{
        HomeBannerRsp bannerRsp = EShopClient.getInstance().execute("/home/data", null, HomeBannerRsp.class);
        assertTrue(bannerRsp.getStatus().isSucceed());
    }

    public void getHomeCategory() throws Exception{
        CategoryRsp categoryRsp = EShopClient.getInstance().execute("/home/category", null, CategoryRsp.class);
        assertTrue(categoryRsp.getStatus().isSucceed());
    }
    public void getSearch() throws Exception{
        SearchReq searchReq = new SearchReq();
        SearchRsp searchRsp = EShopClient.getInstance().execute("/search", searchReq, SearchRsp.class);
        assertTrue(searchRsp.getStatus().isSucceed());
    }
}
