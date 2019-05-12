package com.alldi.banklistfromserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alldi.banklistfromserver.databinding.ActivityMainBinding;
import com.alldi.banklistfromserver.utils.ConnectServer;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        act.serverTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                ConnectServer.getRequestInfoBank(mContext, new ConnectServer.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
//                        실제로 서버에서 돌아온 응답을 메인 액티비티에서 처리하는 메쏘드.

                        try {
                            int code = json.getInt("code");

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (code == 200){
                                        Toast.makeText(mContext, "정상적으로 데이터를 가져왔습니다.", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(mContext, "서버통신에 문제가 있습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
                
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
