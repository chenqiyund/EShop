package activity.example.com.eshop.network;

import com.google.gson.Gson;

import activity.example.com.eshop.network.entity.CategoryRsp;
import activity.example.com.eshop.network.entity.HomeBannerRsp;
import activity.example.com.eshop.network.entity.HomeCategoryRsp;
import okhttp3.Call;
import okhttp3.Response;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Administrator on 2019/6/16.
 * 单元测试：测试接口
 */

public class EShopClientTest {
    public void getCategory() throws Exception {
        Call call = EShopClient.getInstance().getCategory();
        Response response = call.execute();
        String string = response.body().string();
        CategoryRsp categoryRsp = new Gson().fromJson(string, CategoryRsp.class);
        // 断言方法：为我们做一个判断
        assertTrue(categoryRsp.getStatus().isSucceed());
    }

    public void getHomeBanner() throws Exception{
        Call call = EShopClient.getInstance().getHomeBanner();
        Response response = call.execute();
        String string = response.body().string();
        HomeBannerRsp bannerRsp = new Gson().fromJson(string, HomeBannerRsp.class);
        assertTrue(bannerRsp.getStatus().isSucceed());
    }

    public void getHomeCategory() throws Exception{
        Call call = EShopClient.getInstance().getHomeCategory();
        Response response = call.execute();
        String string = response.body().string();
        HomeCategoryRsp categoryRsp = new Gson().fromJson(string, HomeCategoryRsp.class);
        assertTrue(categoryRsp.getStatus().isSucceed());
    }
}
