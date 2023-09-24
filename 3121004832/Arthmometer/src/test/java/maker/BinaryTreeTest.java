package maker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BinaryTreeTest {

    @Test
    void setRoot() {
    }

    @Test
    void checkRepetition() {
        List<String> a= Arrays.asList("1","2","+","3","+");
        List<String> b=Arrays.asList("3","2","1","+","+");
        System.out.println(BinaryTree.CheckRepetition(a,b));
    }

    @Test
    void buildTree() {
    }
    @Test
    void checkdivide(){

        List<String> b=Arrays.asList("(","8","*","7",")","÷","(","5","-","5",")");
        System.out.println(BinaryTree.CheckDivide(ComputeFourRule.SuffExpression(b)));
    }
}