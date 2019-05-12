package com.aoqiyiwang.device.http;

import com.aoqiyiwang.device.base.BaseHttpResult;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpService {
    @GET("/app/select")
    Observable<BaseHttpResult<DeviceBean>> getDeviceMess(@Query("deviceId") String id);

    @POST("/app/updata")
    Observable<BaseHttpResult> postData(@Body RequestBody body);
}
