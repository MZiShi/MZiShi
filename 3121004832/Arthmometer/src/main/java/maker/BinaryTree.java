package maker;

import java.util.List;
import java.util.Stack;

public class BinaryTree {
    public TreeNode root;//根节点

    public void setRoot(TreeNode root){
        this.root=root;
    }
    public static boolean CheckRepetition(List<String> a,List<String> b){
        BinaryTree tree1=BuildTree(a);
        BinaryTree tree2=BuildTree(b);
        return isSameTree(tree1.root,tree2.root);
    }
    public  static BinaryTree BuildTree(List<String> a){
        BinaryTree binaryTree=new BinaryTree();
        Stack<TreeNode> stack = new Stack<>();
        for(String str1:a){
            TreeNode node=new TreeNode(str1);
            if(str1.equals("+") || str1.equals("-") || str1.equals("*") || str1.equals("÷")){
                node.setRight(stack.pop());
                node.setLeft(stack.pop());
            }
            stack.push(node);
        }
        binaryTree.setRoot(stack.pop());
        return binaryTree;
    }
    public static boolean CheckDivide(List<String> a){
        BinaryTree tree1=BuildTree(a);

        return tree1.root.postOrderDivide();
    }
    public static boolean CheckSubtraction(List<String> a){
        BinaryTree tree1=BuildTree(a);
        return tree1.root.postOrderSubtraction();
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (!p.getName().equals(q.getName())) {
            return false;
        } else {
            if(p.getName().equals("+") || p.getName().equals("*")){//加法与乘法可交换节点
                return (isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight()))||isSameTree(p.getLeft(),q.getRight() ) && isSameTree(p.getRight(),q.getLeft() );
            }
            return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
        }
    }



}
