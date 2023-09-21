package maker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {
    public  static List Creat(int scope ){
        int OperatorNumber;//运算符数量
        int OperandNumber;//运算数数量
        boolean ifbracket;//是否生成括号
        int BracketNumber=0;//括号对数
        int FractionNumber;//分数数量
        List<String> equation=new ArrayList<>();
        Random r=new Random();
        OperatorNumber= r.nextInt(3)+1;
        OperandNumber=OperatorNumber+1;
        FractionNumber=r.nextInt(OperandNumber+1);
        ifbracket=r.nextBoolean();
        if(ifbracket&&OperandNumber>=3){
            BracketNumber=r.nextInt(OperandNumber-1);
        }
        List<String> str=new ArrayList<>();
        for(int i=0;i<OperandNumber-FractionNumber;i++){
            str.add("NaturalNumber");
        }
        for(int i=0;i<FractionNumber;i++){
            if(str.size()==0){
                str.add("Fraction");
                continue;
            }
            str.add(r.nextInt(str.size()),"Fraction");
        }
        for(int i=0,j=1;i<OperatorNumber;i++){
            int RandomOperator=r.nextInt(4)+1;
            if(RandomOperator==1){
                str.add(j,"+");
            }
            else if(RandomOperator==2){
                str.add(j,"-");
            }
            else if(RandomOperator==3){
                str.add(j,"*");
            }
            else{
                str.add(j,"/");
            }
            j+=2;
        }
        if(ifbracket){
            if(OperandNumber==3){
                int RandomNumber= r.nextInt(2)+1;
               if(RandomNumber==1){
                   str.add(0,"(");
                   str.add(4,")");
               }
               else{
                   str.add(2,"(");
                   str.add(6,")");
               }
            }
            else if(OperandNumber==4){
                if(BracketNumber==1){
                    int RandomNumber= r.nextInt(3)+1;
                    if(RandomNumber==1){
                        str.add(0,"(");
                        str.add((r.nextInt(2)+2)*2,")");
                    }
                    else if(RandomNumber==2){
                        str.add(2,"(");
                        str.add((r.nextInt(2)+3)*2,")");
                    }
                    else {
                        str.add(4,"(");
                        str.add(8,")");
                    }
                }
                else if(BracketNumber==2){
                    int RandomNumber= r.nextInt(2)+1;
                    if(RandomNumber==1){
                        str.add(0,"(");
                        str.add(4,")");
                        str.add(6,"(");
                        str.add(10,")");
                    }
                    else{
                        str.add(0,"(");
                        str.add(0,"(");
                        str.add(5,")");
                        str.add(8,")");
                    }
                }
            }
        }
        for(String str1:str){
            switch (str1){
                case "NaturalNumber":equation.add(String.valueOf(r.nextInt(scope)));break;
                case "Fraction":equation.add(CreatFraction(scope));break;
                case "(":
                case ")":
                case "+":
                case "-":
                case "*":
                case "/":equation.add(str1);break;
            }
        }
        return equation;
    }
    public static String CreatFraction(int scope){
        Random r=new Random();
        int numerator= r.nextInt(scope+1)+1;
        int denominator=r.nextInt(scope+1)+1;
        int f=gcd(numerator,denominator);
        numerator=numerator/f;
        denominator=denominator/f;
        String str=numerator+"/"+denominator;
        return str;
    }
    public static int gcd(int a, int b) {
        // 更相减损法，与辗转相除法一样，但使用了更高效的减法来代替取余
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        if (max % min == 0)
            return min;
        return gcd(max - min, min);
    }

}
