package maker;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String name;
    private TreeNode left;//默认为null
    private TreeNode right;//默认为null

    public TreeNode(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    public boolean postOrderDivide(){
        //遍历检查除法
        boolean  statel=true;
        boolean stater=true;
        if(this.left!=null){
           statel= this.left.postOrderDivide();
        }
        if(this.right!=null){
            stater= this.right.postOrderDivide();
        }
        if(!(statel&&stater)) return false;
        if(this.name.equals("÷")){//除法判断右子树对应式子值是否会为0
            List<String> Right=new ArrayList<>();
            this.right.postOrder(Right);
            return !ComputeFourRule.Compute(Right).equals("0");
        }
        else{
            return true;
        }


    }
    public boolean postOrderSubtraction(){
        //遍历检查减法
        boolean  statel=true;
        boolean stater=true;
        if(this.left!=null){
            statel=this.left.postOrderSubtraction();
        }
        if(this.right!=null){
            stater=this.right.postOrderSubtraction();
        }
        if(!(statel&&stater)) return false;
        if(this.name.equals("-")){//计算减法左右子树对应式子的值比较大小
            List<String> Left=new ArrayList<>();
            List<String> Right=new ArrayList<>();
            this.left.postOrder(Left);
            this.right.postOrder(Right);
            String leftnumber=ComputeFourRule.Compute(Left);
            String rightnumber=ComputeFourRule.Compute(Right);
            int[] number1=new Fraction().SplitNumber(leftnumber);
            int[] number2=new Fraction().SplitNumber(rightnumber);
            return number1[0] * number2[1] >= number2[0] * number1[1];
        }
        else return true;
    }
    public  void postOrder(List<String> a){
        //由二叉树得到后缀表达式
            if(this.left!=null){
                this.left.postOrder(a);
            }
            if(this.right!=null){
                this.right.postOrder(a);
            }
            a.add(this.name);
    }

}
