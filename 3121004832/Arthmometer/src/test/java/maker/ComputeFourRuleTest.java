package maker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputeFourRuleTest {

    @Test
    void suffExpression() {
        List<String> a=Generate.Creat(10);
        System.out.println(a);
        a=ComputeFourRule.SuffExpression(a);
        System.out.println(a);
    }

    @Test
    void compute() {
        List<String> a= Arrays.asList("1","÷","6","+","10","*","7");
        a=ComputeFourRule.SuffExpression(a);
        System.out.println(ComputeFourRule.Compute(a));
    }
}