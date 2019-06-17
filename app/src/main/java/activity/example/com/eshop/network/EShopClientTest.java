package activity.example.com.eshop.network;

import com.google.gson.Gson;

import activity.example.com.eshop.network.entity.CategoryRsp;
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
}
