package com.tangmo.shengmei.constant;

/**
 * @author boge
 * @date 18/1/19
 * @description 交管局名称code
 */

public class CarOrgCode {

    private static final String BEIJING = "京";
    private static final String BEIJING_CODE = "beijing";
    private static final String ANHUI = "皖";
    private static final String ANHUI_CODE = "anhui";
    private static final String FUJIAN = "闽";
    private static final String FUJIAN_CODE = "fujian";
    private static final String GANSU = "甘";
    private static final String GANSU_CODE = "gansu";
    private static final String GUANGDONG = "粤";
    private static final String GUANGDONG_CODE = "guangdong";
    private static final String GUANGXI = "桂";
    private static final String GUANGXI_CODE = "guangxi";
    private static final String GUIZHOU = "贵";
    private static final String GUIZHOU_CODE = "guizhou";
    private static final String HAINAN = "琼";
    private static final String HAINAN_CODE = "hainan";
    private static final String HEBEI = "冀";
    private static final String HEBEI_CODE = "hebei";
    private static final String HENAN = "豫";
    private static final String HENAN_CODE = "henan";
    private static final String HEILONGJIANG = "黑";
    private static final String HEILONGJIANG_CODE = "heilongjiang";
    private static final String HUBEI = "鄂";
    private static final String HUBEI_CODE = "hubei";
    private static final String HUNAN = "湘";
    private static final String HUNAN_CODE = "hunan";
    private static final String JILIN = "吉";
    private static final String JILIN_CODE = "jilin";
    private static final String JIANGSU = "苏";
    private static final String JIANGSU_CODE = "jiangsu";
    private static final String JIANGXI = "赣";
    private static final String JIANGXI_CODE = "江西";

    private static final String LIAONING = "辽";
    private static final String LIAONING_CODE = "liaoning";
    private static final String NEIMENGGU = "蒙";
    private static final String NEIMENGGU_CODE = "neimenggu";
    private static final String NINGXIA = "宁";
    private static final String NINGXIA_CODE = "ningxia";
    private static final String QINGHAI = "青";
    private static final String QINGHAI_CODE = "qinghai";
    private static final String SHANXI = "晋";
    private static final String SHANXI_CODE = "shanxi";
    private static final String SHANDONG = "鲁";
    private static final String SHANDONG_CODE = "shandong";
    private static final String SHANNXI = "陕";
    private static final String SHANNXI_CODE = "shannxi";

    private static final String SHANGHAI = "沪";
    private static final String SHANGHAI_CODE = "shanghai";
    private static final String SICHUAN = "川";
    private static final String SICHUAN_CODE = "sichuan";
    private static final String TIANJIN = "津";
    private static final String TIANJIN_CODE = "tianjin";
    private static final String XIZANG = "藏";
    private static final String XIZANG_CODE = "xizang";
    private static final String XINJIANG = "新";
    private static final String XINJIANG_CODE = "xinjiang";
    private static final String YUNNAN = "云";
    private static final String YUNNAN_CODE = "yunnan";
    private static final String ZHEJIANG = "浙";
    private static final String ZHEJIANG_CODE = "zhejiang";
    private static final String CHONGQING = "渝";
    private static final String CHONGQING_CODE = "chongqing";


    public static String getCodeByName(String name){
        switch (name){
            case BEIJING: return BEIJING_CODE;
            case ANHUI:  return ANHUI_CODE;
            case FUJIAN: return FUJIAN_CODE;

            case GANSU: return GANSU_CODE;
            case GUANGDONG:  return GUANGDONG_CODE;
            case GUANGXI: return GUANGXI_CODE;
            case GUIZHOU: return GUIZHOU_CODE;
            case HAINAN:  return HAINAN_CODE;
            case HEBEI: return HEBEI_CODE;

            case HENAN: return HENAN_CODE;
            case HEILONGJIANG:  return HEILONGJIANG_CODE;
            case HUBEI: return HUBEI_CODE;
            case HUNAN: return HUNAN_CODE;
            case JILIN:  return JILIN_CODE;
            case JIANGSU: return JIANGSU_CODE;

            case JIANGXI: return JIANGXI_CODE;
            case LIAONING:  return LIAONING_CODE;
            case NEIMENGGU: return NEIMENGGU_CODE;
            case NINGXIA: return NINGXIA_CODE;
            case QINGHAI:  return QINGHAI_CODE;
            case SHANXI: return SHANXI_CODE;

            case SHANDONG: return SHANDONG_CODE;
            case SHANNXI:  return SHANNXI_CODE;
            case SHANGHAI: return SHANGHAI_CODE;
            case SICHUAN: return SICHUAN_CODE;
            case TIANJIN:  return TIANJIN_CODE;
            case XIZANG: return XIZANG_CODE;

            case XINJIANG: return XINJIANG_CODE;
            case YUNNAN:  return YUNNAN_CODE;
            case ZHEJIANG: return ZHEJIANG_CODE;
            case CHONGQING: return CHONGQING_CODE;

            default:
                return "";
        }
    }
}
