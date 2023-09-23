package maker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void postOrderDivide() {
    }

    @Test
    void postOrder() {
        List<String> a= Arrays.asList("1","2","+","3","+");
        List<String> b=new ArrayList<>();
        BinaryTree tree=BinaryTree.BuildTree(a);
        tree.root.getLeft().postOrder(b);
        System.out.println(b);

    }

    @Test
    void postOrderSubtraction() {
    }
}