package maker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BinaryTreeTest {



    @Test
    void checkRepetition() {
        //检查四则式的重复功能
        List<String> a= Arrays.asList("1","2","+","3","+");
        List<String> b=Arrays.asList("3","2","1","+","+");
        List<String> c=Arrays.asList("3","2","+","1","+");
        System.out.println(BinaryTree.CheckRepetition(a,b));
        System.out.println(BinaryTree.CheckRepetition(a,c));
    }

    @Test
    void checkdivide(){
        //检查除法的除数是否为0的方法
        List<String> a=Arrays.asList("(","8","*","7",")","÷","(","5","-","4",")");
        List<String> b=Arrays.asList("(","8","*","7",")","÷","(","5","-","5",")");
        System.out.println(BinaryTree.CheckDivide(ComputeFourRule.SuffExpression(a)));
        System.out.println(BinaryTree.CheckDivide(ComputeFourRule.SuffExpression(b)));
    }
    @Test
    void checksubtraction(){
        //检查减法是否会产生负数
        List<String> a=Arrays.asList("(","8","*","7",")","÷","(","5","-","6",")");
        List<String> b=Arrays.asList("(","8","*","7",")","÷","(","5","-","4",")");
        System.out.println(BinaryTree.CheckDivide(ComputeFourRule.SuffExpression(a)));
        System.out.println(BinaryTree.CheckDivide(ComputeFourRule.SuffExpression(b)));
    }
}