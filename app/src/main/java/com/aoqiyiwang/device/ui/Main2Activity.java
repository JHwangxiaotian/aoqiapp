package com.aoqiyiwang.device.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aoqiyiwang.device.R;
import com.aoqiyiwang.device.base.BaseHttpResult;
import com.aoqiyiwang.device.http.DeviceBean;
import com.aoqiyiwang.device.http.Http;
import com.aoqiyiwang.device.http.HttpService;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.aoqiyiwang.device.utils.NetWorkUril.isNetworkAvailable;
import static com.qmuiteam.qmui.widget.dialog.QMUITipDialog.Builder.ICON_TYPE_LOADING;

public class Main2Activity extends AppCompatActivity {

    protected static HttpService httpService;
    private QMUITipDialog loading;
    private DeviceBean deviceBean;
    private Button mCommit;

    private TextView mTextId;
    private RadioButton mRadioButtonZhiLiu;
    private RadioButton mRadioButtonJiaoLiu;
    private QMUIRoundButton mButtonShengChan;
    private RadioButton mRadioButton2011;
    private RadioButton mRadioButton2015;
    private QMUIRoundButton mButtonSheBei;
    private QMUIRoundButton mButtonZuiDa;
    private QMUIRoundButton mButtonShuChu;
    private QMUIRoundButton mButtonYunWei;
    private QMUIRoundButton mButtonZhanDian;
    private QMUIRoundButton mButtonQu;
    private QMUIRoundButton mButtonTCU;
    private RadioButton mRadioButtonWuShi;
    private RadioButton mRadioButtonWuFou;
    private RadioButton mRadioButtonXuShi;
    private RadioButton mRadioButtonXuFou;
    private EditText mEditTextZhanMingCheng;
    private EditText mEditTextZhanDiZhi;
    private EditText mEditTextWeiDu;
    private EditText mEditTextJingDu;
    private EditText mEditTextBeiZhu;


    private QMUIDialog zhuangshengchan;
    private String zhuangshengchanStr [];

    private QMUIDialog zhuangshebei;
    private String zhuangshebeiStr [];

    private QMUIDialog zhuangzuida;
    private String zhuangzuidaStr [];

    private QMUIDialog zhuangshuchu;
    private String zhuangshuchuStr [];

    private QMUIDialog shiyunwei;
    private String shiyunweiStr [];

    private QMUIDialog zhandianlei;
    private String zhandianleiStr [];

    private QMUIDialog qu;
    private String quStr [];

    private QMUIDialog tcu;
    private String tcuStr [];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        httpService = Http.getHttpService();
        loading = new QMUITipDialog.Builder(this).setIconType(ICON_TYPE_LOADING).create();
        mTextId = findViewById(R.id.device_id);
        mRadioButtonZhiLiu = findViewById(R.id.rb_zhiliu);
        mRadioButtonJiaoLiu = findViewById(R.id.rb_jiaoliu);
        mButtonShengChan = findViewById(R.id.device_shengchan);
        mRadioButton2011 = findViewById(R.id.rb_2011);
        mRadioButton2015 = findViewById(R.id.rb_2015);
        mButtonSheBei = findViewById(R.id.device_shebei);
        mButtonZuiDa = findViewById(R.id.device_zuida);
        mButtonShuChu = findViewById(R.id.device_shuchu);
        mButtonYunWei = findViewById(R.id.device_yunwei);
        mButtonZhanDian = findViewById(R.id.device_zhandianlei);
        mButtonQu = findViewById(R.id.device_qu);
        mButtonTCU = findViewById(R.id.device_tcu);
        mRadioButtonWuShi = findViewById(R.id.rb_wushi);
        mRadioButtonWuFou = findViewById(R.id.rb_wufou);
        mRadioButtonXuShi = findViewById(R.id.rb_xushi);
        mRadioButtonXuFou = findViewById(R.id.rb_xufou);

        mEditTextZhanMingCheng = findViewById(R.id.zhanmingcheng);
        mEditTextZhanDiZhi = findViewById(R.id.zhandizhi);
        mEditTextWeiDu = findViewById(R.id.weidu);
        mEditTextJingDu = findViewById(R.id.jingdu);
        mEditTextBeiZhu = findViewById(R.id.beizhu);
        mCommit = findViewById(R.id.commit);



        deviceBean = getIntent().getParcelableExtra("device");


        mTextId.setText(deviceBean.get桩资产());
        mButtonShengChan.setText(deviceBean.get桩生产());
        mButtonSheBei.setText(deviceBean.get桩设备());
        mButtonZuiDa.setText(deviceBean.get桩最大());
        mButtonShuChu.setText(deviceBean.get桩输出());
        mButtonYunWei.setText(deviceBean.get市运维());
        mButtonZhanDian.setText(deviceBean.get站点类());
        mButtonQu.setText(deviceBean.get区());
        mButtonTCU.setText(deviceBean.getTCU版本());

        if ("直流设备".equals(deviceBean.get桩设备())){
            mRadioButtonZhiLiu.setChecked(true);
        }else {
            mRadioButtonJiaoLiu.setChecked(true);
        }
        if ("国标2011".equals(deviceBean.get充电标())){
            mRadioButton2011.setChecked(true);
        }else {
            mRadioButton2015.setChecked(true);
        }
        if ("是".equals(deviceBean.get是否虚())){
            mRadioButtonXuShi.setChecked(true);
        }else {
            mRadioButtonXuFou.setChecked(true);
        }
        if ("是".equals(deviceBean.get是否无())){
            mRadioButtonWuShi.setChecked(true);
        }else {
            mRadioButtonWuFou.setChecked(true);
        }

        mEditTextZhanMingCheng.setText(deviceBean.get站名称());
        mEditTextZhanDiZhi.setText(deviceBean.get站地址());
        mEditTextWeiDu.setText(deviceBean.get站维度());
        mEditTextJingDu.setText(deviceBean.get站经度());
        mEditTextBeiZhu.setText(deviceBean.get备注());
        initDialog();
        initClick();
        initPost();
    }

    private void initDialog(){
        zhuangshengchanStr = new String[]{"安徽南瑞继远电网技术有限公司",
                "北京方智科技有限公司", "北京和信瑞通电力技术有限公司", "北京华商三优新能源科技有限公司",
                "国电南瑞科技股份有限公司","黑龙江省电工仪器仪表工程技术研究中心","科陆电子科技股份有限公司",
                "南京能瑞电力科技有限公司","宁波三星智能电气有限公司","普瑞特高压设备有限公司",
                "青岛高科通信股份有限公司","山东电工电气集团新能科技","山东鲁能智能技术有限公司",
                "深圳奥特迅电力设备股份有限公司","许继电气股份有限公司","银隆新能源股份有限公司"};
        zhuangshengchan = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(zhuangshengchanStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonShengChan.setText(zhuangshengchanStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        zhuangshebeiStr = new String[]{"BJFZ500V60kW", "BJFZ750H060ZY201810240BBZD" , "BJFZ750H120ZF201810530BBZD" ,
                "HDYB750H060ZY201810200XJDQ" , "HDYB750H100ZD201810210XJDQ" , "HSSY220V7kW" , "HSSY500V120kW" ,
                "HSSY500V60kW" , "HSSY700V120kW" , "HXRT500V120kW" , "HXRT500V37.5kW" , "HXRT500V60kW" ,
                "HXRT700V100kW" , "HXRU750H120ZD201810670BBZD" , "NBSX750H060ZY201810280BBZD" , "NJNR220V7kW" , "NJNR500V37.5kW" ,
                "NJNR500V60kW" , "NJNR700V100kW" , "NJNR700V120kW" , "NJNR750H060ZY201810560BBZD" , "NJNR750H450ZY201810330BBZD" ,
                "NRJY750H060ZY201810190SSKJ" , "NRJY750H360ZG201810750SSKJ" , "NRKJ220V7kW" , "NRKJ380V40kW" ,
                "NRKJ380V80kW" , "NRKJ500V120kW" , "NRKJ500V60kW" , "NRKJ750H060ZD201810590NRKJ" , "PRTGY500V120kW" ,
                "QDGK380V40kW" , "SDDG500V120kW" , "SDDG500V37.5kW" , "SDDG500V60kW" , "SDLN220V7kW" , "SDLN500V120kW" ,
                "SDLN500V60kW" , "SDLN700V100kW" , "SDLN700V120kW" , "SDLN700V60kW" , "SXDQ500V37.5kW" ,
                "SXDQ500V60kW" , "SXDQ700V100kW" , "SXDQ700V60kW" , "SZATX450V25KW" , "SZKL500V120kW" ,
                "SZKL500V60kW" , "TJYL750V360kW" , "XJDQ220V7kW" , "XJDQ500V60kW" , "XJDQ700V120kW" ,
                "XJDQ750H060ZY201810030XJDQ" , "XJDQ750H120ZF201810060XJDQ" ,
                "XJDQ750V200kW"};
        zhuangshebei = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(zhuangshebeiStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonSheBei.setText(zhuangshebeiStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        zhuangzuidaStr = new String[]{"220" , "380" , "450" , "500" , "700" , "750"};
        zhuangzuida = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(zhuangzuidaStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonZuiDa.setText(zhuangzuidaStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        zhuangshuchuStr = new String[]{"100" , "120" , "200" , "25" ,
                "360" , "37.5" , "40" , "450" , "60" , "7" , "80"};
        zhuangshuchu = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(zhuangshuchuStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonShuChu.setText(zhuangshuchuStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        shiyunweiStr = new String[]{"国网天津宝坻公司" ,
                "国网天津滨海供电公司" , "国网天津城东公司" , "国网天津城南供电公司" , "国网天津城西公司" ,
                "国网天津东丽公司" , "国网天津蓟县供电公司" ,
                "国网天津静海公司" , "国网天津宁河公司" , "国网天津武清公司"};

        shiyunwei = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(shiyunweiStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonYunWei.setText(shiyunweiStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        zhandianleiStr = new String[]{"城市公共" ,
                "城市公共（暂不开放）" , "单位内部（可选开放）" , "单位内部（专用）" ,
                "高速" , "高速（暂不开放）" , "公交"};
        zhandianlei = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(zhandianleiStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonZhanDian.setText(zhandianleiStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        quStr = new String[]{"宝坻区" , "北辰区" , "滨海新区" , "东丽区" , "和平区" ,
                "河北区" , "河东区" , "河西区" , "红桥区" , "蓟州区" , "津南区" , "静海区" ,
                "南开区" , "宁河区" , "武清区" , "西青区"};
        qu = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(quStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonQu.setText(quStr[which]);
                        dialog.dismiss();
                    }
                }).create();

        tcuStr = new String[]{"2.4" , "2.40" , "2.44" , "2.45" , "2.47" , "2.52" , "2.56" , "2.60" , "2.70"};
        tcu = new QMUIDialog.MenuDialogBuilder(this)
                .addItems(tcuStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mButtonTCU.setText(tcuStr[which]);
                        dialog.dismiss();
                    }
                }).create();

    }

    private void initClick(){
        mButtonShengChan.setOnClickListener(v -> {
            zhuangshengchan.show();
        });
        mButtonSheBei.setOnClickListener(v -> {
            zhuangshebei.show();
        });
        mButtonZuiDa.setOnClickListener(v -> {
            zhuangzuida.show();
        });
        mButtonShuChu.setOnClickListener(v -> {
            zhuangshuchu.show();
        });

        mButtonYunWei.setOnClickListener(v -> {
            shiyunwei.show();
        });
        mButtonZhanDian.setOnClickListener(v -> {
            zhandianlei.show();
        });
        mButtonQu.setOnClickListener(v -> {
            qu.show();
        });
        mButtonTCU.setOnClickListener(v -> {
            tcu.show();
        });
    }

    private void initPost(){
        mCommit.setOnClickListener(v -> {
            String id = deviceBean.get桩资产();
            String shebeileixing = mRadioButtonZhiLiu.isChecked() ? "直流设备":"交流设备";
            String zhuangshengchan = (String) mButtonShengChan.getText();
            String chongdianbiao = mRadioButton2011.isChecked() ? "国标2011":"国标2015";
            String zhuangshebei = mButtonSheBei.getText().toString();
            String zhuangzuida = mButtonZuiDa.getText().toString();
            String zhuangshuchu = mButtonShuChu.getText().toString();
            String zhanmingcheng = mEditTextZhanMingCheng.getText().toString();
            String zhandizhi = mEditTextZhanDiZhi.getText().toString();
            String shiyunwei = mButtonYunWei.getText().toString();
            String zhanweidu = mEditTextWeiDu.getText().toString();
            String zhanjingdu = mEditTextJingDu.getText().toString();
            String zhandianlei = mButtonZhanDian.getText().toString();
            String qu = mButtonQu.getText().toString();
            String tcu = mButtonTCU.getText().toString();
            String shifouwu = mRadioButtonWuShi.isChecked() ? "是":"否";
            String shifouxu = mRadioButtonXuShi.isChecked() ? "是":"否";
            String beizhu = mEditTextBeiZhu.getText().toString();

            if (isNetworkAvailable(this)){// 判断网络情况
                postData( id, shebeileixing,  zhuangshengchan,
                         chongdianbiao,  zhuangshebei,  zhuangzuida,
                         zhuangshuchu,  zhanmingcheng,  zhandizhi,
                         shiyunwei,  zhanweidu,  zhanjingdu,
                         zhandianlei,  qu,  tcu,
                         shifouwu,  shifouxu,  beizhu);
            }else {
                Toast.makeText(getApplication(),"网络情况出问题",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void postData(String id,String shebeileixing, String zhuangshengchan,
                          String chongdianbiao, String zhuangshebei, String zhuangzuida,
                          String zhuangshuchu, String zhanmingcheng, String zhandizhi,
                          String shiyunwei, String zhanweidu, String zhanjingdu,
                          String zhandianlei, String qu, String tcu,
                          String shifouwu, String shifouxu, String beizhu){
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("id",id)
                .addFormDataPart("shebeileixing",shebeileixing)
                .addFormDataPart("zhuangshengchan",zhuangshengchan)
                .addFormDataPart("chongdianbiao",chongdianbiao)
                .addFormDataPart("zhuangshebei",zhuangshebei)
                .addFormDataPart("zhuangzuida",zhuangzuida)
                .addFormDataPart("zhuangshuchu",zhuangshuchu)
                .addFormDataPart("zhanmingcheng",zhanmingcheng)
                .addFormDataPart("zhandizhi",zhandizhi)
                .addFormDataPart("shiyunwei",shiyunwei)
                .addFormDataPart("zhanweidu",zhanweidu)
                .addFormDataPart("zhanjingdu",zhanjingdu)
                .addFormDataPart("zhandianlei",zhandianlei)
                .addFormDataPart("qu",qu)
                .addFormDataPart("tcu",tcu)
                .addFormDataPart("shifouwu",shifouwu)
                .addFormDataPart("shifouxu",shifouxu)
                .addFormDataPart("beizhu",beizhu)
                .build();

        httpService.postData(body)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    loading.show();
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {loading.dismiss();})
                .subscribe(new DefaultObserver<BaseHttpResult>() {
                    @Override
                    public void onNext(BaseHttpResult deviceBeanBaseHttpResult) {
                        if (deviceBeanBaseHttpResult.getCode() == 200){
                            Toast.makeText(getApplication(),"信息上报成功",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(getApplication(),"信息上报失败",Toast.LENGTH_SHORT).show();
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
