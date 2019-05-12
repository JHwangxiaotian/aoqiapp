package com.aoqiyiwang.device.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aoqiyiwang.device.R;
import com.aoqiyiwang.device.base.BaseHttpResult;
import com.aoqiyiwang.device.http.DeviceBean;
import com.aoqiyiwang.device.http.Http;
import com.aoqiyiwang.device.http.HttpService;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

import static com.aoqiyiwang.device.utils.NetWorkUril.isNetworkAvailable;
import static com.qmuiteam.qmui.widget.dialog.QMUITipDialog.Builder.ICON_TYPE_LOADING;


public class MainActivity extends AppCompatActivity {

    protected static HttpService httpService;

    private EditText mEditText;
    private Button mButton;
    private QMUITipDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edit_query);
        mButton = findViewById(R.id.button_check);
        httpService = Http.getHttpService();
        loading = new QMUITipDialog.Builder(this).setIconType(ICON_TYPE_LOADING).create();

        mButton.setOnClickListener(v -> {
            String s = mEditText.getText().toString().trim();
            if ("".equals(s) || s == null){
                Toast.makeText(getApplication(),"输出的数字有误",Toast.LENGTH_SHORT).show();
                return;
            }
            if (isNetworkAvailable(this)){// 判断网络情况
                getMess("124269000000"+s);
            }else {
                Toast.makeText(getApplication(),"网络情况出问题",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMess(String id){
        httpService.getDeviceMess(id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    loading.show();
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {loading.dismiss();})
                .subscribe(new DefaultObserver<BaseHttpResult<DeviceBean>>() {
                    @Override
                    public void onNext(BaseHttpResult<DeviceBean> deviceBeanBaseHttpResult) {
                        if (deviceBeanBaseHttpResult.getCode() == 200){
                            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                            intent.putExtra("device",deviceBeanBaseHttpResult.getData());
                            startActivity(intent);
                            mEditText.setText("");
                        }else if (deviceBeanBaseHttpResult.getCode() == 201){
                            Toast.makeText(getApplication(),"输入的设备ID没有查询到",Toast.LENGTH_SHORT).show();
                        }
                        else if (deviceBeanBaseHttpResult.getCode() == 401){
                            Toast.makeText(getApplication(),"输入的设备ID有误",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
