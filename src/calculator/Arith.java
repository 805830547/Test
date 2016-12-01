package calculator;

import java.math.BigDecimal;

/**
 * 进行BigDecimal对象的加减乘除，四舍五入等运算的工具类
 *
 * @author
 *
 */
public class Arith {

    /**
     * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
     */
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    // 这个类不能实例化
    private Arith() {
    }

    public static String add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).toString();
    }

    public static String sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).toString();
    }

    public static String mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).toString();
    }

    public static String div(String v1, String v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }
}