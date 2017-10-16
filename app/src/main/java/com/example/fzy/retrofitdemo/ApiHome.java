package com.example.fzy.retrofitdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by Administrator on 2017/10/12.
 */

public class ApiHome {
    private BaseService baseService;
    private static volatile ApiHome instance;

    public ApiHome(BaseService baseService) {
        this.baseService = baseService;
    }

    public ApiHome() {
    }

    public static ApiHome getInstance() {
        if (instance == null) {
            synchronized (ApiHome.class) {
                if (instance == null) {
                    instance = new ApiHome();
                }
            }
        }
        return instance;
    }

    //网络请求的方法返回call
    public Call<ResponseBody> getData(String qq, String pwd) {
        if (baseService == null) {
            baseService = Home.getBaseService();
        }
        StringBuffer stringBuffer = new StringBuffer();
        //http://169.254.125.233/web/LoginServlet?qq=1&pwd=2
        //拼接参数
        stringBuffer.append(Constant.URL_BASE).append("web/").append("LoginServlet?")
                .append("qq="+qq)
                .append("&pwd=" + pwd);

        return baseService.baseGetRequest(stringBuffer.toString());
    }
    public Call<ResponseBody> getImage() {
        if (baseService == null) {
            baseService = Home.getBaseService();
        }
        StringBuffer stringBuffer = new StringBuffer();
        //http://169.254.34.113/images/2017-06-02/c591370512f1d14c96d72ab383b5d153.jpeg
        //拼接参数
        stringBuffer.append(Constant.IMAGE_URL).append("images/").append("2017-06-02/c591370512f1d14c96d72ab383b5d153.jpeg");
        return baseService.baseGetImage(stringBuffer.toString());
    }

   /* http://169.254.125.233:8080/fuck.mp4*/
    public Call<ResponseBody> getMp4(){
        if (baseService == null) {
            baseService = Home.getBaseService();
        }
        StringBuffer stringBuffer = new StringBuffer();
        //http://169.254.34.113/users/Guolei1130
        //拼接参数
        stringBuffer.append(Constant.URL_BASE).append("fuck.mp4");
        return baseService.baseGetRequest(stringBuffer.toString());

    }
}
