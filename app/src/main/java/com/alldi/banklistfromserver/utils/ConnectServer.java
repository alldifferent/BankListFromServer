package com.alldi.banklistfromserver.utils;

import android.content.Context;

import org.json.JSONObject;

public class ConnectServer {

    private final static String BASE_URL = "http://delivery-dev-389146667.ap-northeast-2.elb.amazonaws.com";

    public interface JsonResponseHandler{
        void onResponse(JSONObject json);
    }

    public static void getRequestInfoBank(Context context, /*필요한 파라미터용 변수들*/ final JsonResponseHandler handler){

    }

}
