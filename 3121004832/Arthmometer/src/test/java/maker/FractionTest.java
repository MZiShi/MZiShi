package maker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void splitNumber() {
        //测试分割分子分母
        int[] a=new Fraction().SplitNumber("2");
        System.out.println("分子："+a[0]+" 分母："+a[1]);
        int[] b=new Fraction().SplitNumber("2'2/3");
        System.out.println("分子："+b[0]+" 分母："+b[1]);
        int[] c=new Fraction().SplitNumber("7/8");
        System.out.println("分子："+c[0]+" 分母："+c[1]);
    }

    @Test
    void simplestFraction() {
        //测试转换分数格式
        System.out.println(new Fraction().SimplestFraction("10/3"));

    }
}