package maker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputeFourRuleTest {

    @Test
    void suffExpression() {
        //转换为后缀表达式
        List<String> a=Arrays.asList("1","+","2","+","3");
        List<String> b=Arrays.asList("(","8","*","7",")","÷","(","5","-","4",")");
        a=ComputeFourRule.SuffExpression(a);
        b=ComputeFourRule.SuffExpression(b);
        System.out.println(a);
    }

    @Test
    void compute() {
        //计算结果
        List<String> a= Arrays.asList("1","÷","6","+","2'7/10","*","7");
        a=ComputeFourRule.SuffExpression(a);
        System.out.println(ComputeFourRule.Compute(a));
    }
}