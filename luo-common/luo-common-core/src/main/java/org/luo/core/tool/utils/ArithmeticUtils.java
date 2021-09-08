package org.luo.core.tool.utils;

import java.math.BigDecimal;

/**
 * @Date 10:07 2021/6/8
 * @Description {
 *  精确计算工具类
 * }
 * @Author lsay
 **/
public class ArithmeticUtils {

    private static final int SCALE_2 = 2;

    /**
     * 精确的加法运算
     * @param v1 被加数
     * @param v2 加数
     * @param scale 保留小数位数
     * @return 和
     */
    public static Double add(Double v1,Double v2,int scale){
        return new BigDecimal(v1).add(new BigDecimal(v2)).setScale(scale,BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    /**
     * 精确的加法运算
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static Double add(Double v1,Double v2){
        return add(v1,v2,SCALE_2);
    }

    /**
     * 精确的除法运算
     * @param v1 被除数
     * @param v2 除数
     * @param scale 保留小数位数
     * @return 商
     */
    public static Double divide(Double v1,Double v2,int scale){
        return new BigDecimal(v1).divide(new BigDecimal(v2)).setScale(scale,BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    /**
     * 精确的除法运算
     * @param v1 被除数
     * @param v2 除数
     * @return 商
     */
    public static Double divide(Double v1,Double v2){
        return divide(v1,v2,SCALE_2);
    }

}
