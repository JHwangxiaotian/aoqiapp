package com.aoqiyiwang.device.http;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceBean implements Parcelable {

    /**
     * 桩资产 : 1242690000000001
     * 设备类 : 直流设备
     * 桩生产 : 山东鲁能智能技术有限公司
     * 充电标 : 国标2011
     * 桩设备 : SDLN500V60kW
     * 桩最大 : 500
     * 桩输出 : 60
     * 站名称 : 天津市西青区津门湖综合充换电站
     * 站地址 : 天津市西青区翠波道与丽江道交口-富丽津门湖公交站院内停车场
     * 市运维 : 国网天津城南供电公司
     * 站维度 : 39.062687
     * 站经度 : 117.210077
     * 站点类 : 城市公共
     * 区 : 西青区
     * TCU版本 : 2.56
     * 是否无 : “”
     * 是否虚 : “”
     * 备注 : “”
     */

    private String 桩资产;
    private String 设备类;
    private String 桩生产;
    private String 充电标;
    private String 桩设备;
    private String 桩最大;
    private String 桩输出;
    private String 站名称;
    private String 站地址;
    private String 市运维;
    private String 站维度;
    private String 站经度;
    private String 站点类;
    private String 区;
    private String TCU版本;
    private String 是否无;
    private String 是否虚;
    private String 备注;

    protected DeviceBean(Parcel in) {
        桩资产 = in.readString();
        设备类 = in.readString();
        桩生产 = in.readString();
        充电标 = in.readString();
        桩设备 = in.readString();
        桩最大 = in.readString();
        桩输出 = in.readString();
        站名称 = in.readString();
        站地址 = in.readString();
        市运维 = in.readString();
        站维度 = in.readString();
        站经度 = in.readString();
        站点类 = in.readString();
        区 = in.readString();
        TCU版本 = in.readString();
        是否无 = in.readString();
        是否虚 = in.readString();
        备注 = in.readString();
    }

    public static final Creator<DeviceBean> CREATOR = new Creator<DeviceBean>() {
        @Override
        public DeviceBean createFromParcel(Parcel in) {
            return new DeviceBean(in);
        }

        @Override
        public DeviceBean[] newArray(int size) {
            return new DeviceBean[size];
        }
    };

    public String get桩资产() {
        return 桩资产;
    }

    public void set桩资产(String 桩资产) {
        this.桩资产 = 桩资产;
    }

    public String get设备类() {
        return 设备类;
    }

    public void set设备类(String 设备类) {
        this.设备类 = 设备类;
    }

    public String get桩生产() {
        return 桩生产;
    }

    public void set桩生产(String 桩生产) {
        this.桩生产 = 桩生产;
    }

    public String get充电标() {
        return 充电标;
    }

    public void set充电标(String 充电标) {
        this.充电标 = 充电标;
    }

    public String get桩设备() {
        return 桩设备;
    }

    public void set桩设备(String 桩设备) {
        this.桩设备 = 桩设备;
    }

    public String get桩最大() {
        return 桩最大;
    }

    public void set桩最大(String 桩最大) {
        this.桩最大 = 桩最大;
    }

    public String get桩输出() {
        return 桩输出;
    }

    public void set桩输出(String 桩输出) {
        this.桩输出 = 桩输出;
    }

    public String get站名称() {
        return 站名称;
    }

    public void set站名称(String 站名称) {
        this.站名称 = 站名称;
    }

    public String get站地址() {
        return 站地址;
    }

    public void set站地址(String 站地址) {
        this.站地址 = 站地址;
    }

    public String get市运维() {
        return 市运维;
    }

    public void set市运维(String 市运维) {
        this.市运维 = 市运维;
    }

    public String get站维度() {
        return 站维度;
    }

    public void set站维度(String 站维度) {
        this.站维度 = 站维度;
    }

    public String get站经度() {
        return 站经度;
    }

    public void set站经度(String 站经度) {
        this.站经度 = 站经度;
    }

    public String get站点类() {
        return 站点类;
    }

    public void set站点类(String 站点类) {
        this.站点类 = 站点类;
    }

    public String get区() {
        return 区;
    }

    public void set区(String 区) {
        this.区 = 区;
    }

    public String getTCU版本() {
        return TCU版本;
    }

    public void setTCU版本(String TCU版本) {
        this.TCU版本 = TCU版本;
    }

    public String get是否无() {
        return 是否无;
    }

    public void set是否无(String 是否无) {
        this.是否无 = 是否无;
    }

    public String get是否虚() {
        return 是否虚;
    }

    public void set是否虚(String 是否虚) {
        this.是否虚 = 是否虚;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(桩资产);
        dest.writeString(设备类);
        dest.writeString(桩生产);
        dest.writeString(充电标);
        dest.writeString(桩设备);
        dest.writeString(桩最大);
        dest.writeString(桩输出);
        dest.writeString(站名称);
        dest.writeString(站地址);
        dest.writeString(市运维);
        dest.writeString(站维度);
        dest.writeString(站经度);
        dest.writeString(站点类);
        dest.writeString(区);
        dest.writeString(TCU版本);
        dest.writeString(是否无);
        dest.writeString(是否虚);
        dest.writeString(备注);
    }
}
