package maker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ComputeFourRule {
    public static List<String> SuffExpression(List<String> list){
        //转换为后缀表达式
        List<String> suffexpression= new ArrayList<>();
        Stack<String> stack= new Stack<>();
        for(int i=0;i<list.size();i++){
            String suff=list.get(i);
            if(suff.equals("(")) {
                stack.push(suff);
            }else if(suff.equals(")")){
                while (!stack.peek().equals("("))
                    suffexpression.add(stack.pop());
                stack.pop();
            }else if(suff.equals("*")||suff.equals("÷")){
                if(!stack.empty()){
                    while (stack.peek().equals("*")||stack.peek().equals("÷")) {
                        suffexpression.add(stack.pop());
                        if(stack.empty())
                            break;
                    }
                }
                stack.push(suff);
            }else if(suff.equals("+")||suff.equals("-")){
                if(!stack.empty()){
                    while (stack.peek().equals("+")||stack.peek().equals("-")||stack.peek().equals("*")||stack.peek().equals("÷")){
                        suffexpression.add(stack.pop());
                        if(stack.empty())
                            break;
                    }
                }
                stack.push(suff);
            }else {
                suffexpression.add(suff);
            }
        }
        while (!stack.empty()){
            suffexpression.add(stack.pop());
        }
        return suffexpression;
    }
    public static String Compute(List<String> list){
        String result;
        Stack<String> stack1= new Stack<>();
        int leftnumber;
        int rightnumber;
        int[] number1=new int[2];
        int[] number2=new int[2];
            for(int i=0;i<list.size();i++){
                String suff=list.get(i);
                if (suff.equals("+")) {
                    number2=new Fraction().SplitNumber(stack1.pop());
                    number1=new Fraction().SplitNumber(stack1.pop());
                    leftnumber=number1[0]*number2[1]+number2[0]*number1[1];
                    rightnumber=number1[1]*number2[1];
                    stack1.push(leftnumber+"/"+rightnumber);
                } else if (suff.equals("-")) {
                    number2=new Fraction().SplitNumber(stack1.pop());
                    number1=new Fraction().SplitNumber(stack1.pop());
                    leftnumber=number1[0]*number2[1]-number2[0]*number1[1];
                    rightnumber=number1[1]*number2[1];
                    stack1.push(leftnumber+"/"+rightnumber);
                } else if (suff.equals("*")) {
                    number2=new Fraction().SplitNumber(stack1.pop());
                    number1=new Fraction().SplitNumber(stack1.pop());
                    leftnumber=number1[0]*number2[0];
                    rightnumber=number1[1]*number2[1];
                    stack1.push(leftnumber+"/"+rightnumber);
                }else if(suff.equals("÷")){
                    number2=new Fraction().SplitNumber(stack1.pop());
                    number1=new Fraction().SplitNumber(stack1.pop());
                    leftnumber=number1[0]*number2[1];
                    rightnumber=number1[1]*number2[0];
                    stack1.push(leftnumber+"/"+rightnumber);
                }else {
                    stack1.push(suff);
                }
            }
            result=stack1.pop();
        result=new Fraction().SimplestFraction(result);
        return result;
    }
}
