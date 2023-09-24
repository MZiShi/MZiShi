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

    public void setName(String name) {
        this.name = name;
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
    //编写后序遍历的方法
    public boolean postOrderDivide(){
        boolean  statel=true;
        boolean stater=true;
        if(this.left!=null){
           statel= this.left.postOrderDivide();
        }
        if(this.right!=null){
            stater= this.right.postOrderDivide();
        }
        if(!(statel&&stater)) return false;
        if(this.name.equals("÷")){
            List<String> Right=new ArrayList<>();
            this.right.postOrder(Right);
            if(ComputeFourRule.Compute(Right).equals("0")){
                return false;
            }
            else return true&&statel&&stater;
        }
        else{
            return true&&statel&&stater;
        }


    }
    public boolean postOrderSubtraction(){
        boolean  statel=true;
        boolean stater=true;
        if(this.left!=null){
            statel=this.left.postOrderSubtraction();
        }
        if(this.right!=null){
            stater=this.right.postOrderSubtraction();
        }
        if(!(statel&&stater)) return false;
        if(this.name.equals("-")){
            List<String> Left=new ArrayList<>();
            List<String> Right=new ArrayList<>();
            this.left.postOrder(Left);
            this.right.postOrder(Right);
            String leftnumber=ComputeFourRule.Compute(Left);
            String rightnumber=ComputeFourRule.Compute(Right);
            int[] number1=new Fraction().SplitNumber(leftnumber);
            int[] number2=new Fraction().SplitNumber(rightnumber);
            if(number1[0]*number2[1]<number2[0]*number1[1]){
               return false;
            }else return true&&statel&&stater;
        }
        else return true&&statel&&stater;
    }
    public  void postOrder(List<String> a){
            if(this.left!=null){
                this.left.postOrder(a);
            }
            if(this.right!=null){
                this.right.postOrder(a);
            }
            a.add(this.name);
    }

}
