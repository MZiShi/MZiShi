package maker;

public class Fraction {
    public int[] SplitNumber(String str){
        //分割分子分母
        int numerator;
        int denominator;
        int[] b = new int[2];
        String[] a=str.split("'|/");
        if(a.length==3){
            denominator= Integer.parseInt(a[2]);
            numerator=Integer.parseInt(a[0])*denominator+Integer.parseInt(a[1]);
        }
        else if(a.length==1){
            numerator= Integer.parseInt(a[0]);
            denominator=1;
        }
        else {
            denominator= Integer.parseInt(a[1]);
            numerator=Integer.parseInt(a[0]);
        }
        b[0]=numerator;
        b[1]=denominator;
        return b;
    }
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
    public String SimplestFraction(String str){
        int[] b=SplitNumber(str);
        int numerator=b[0];
        int denominator=b[1];
        int f=getGCD(numerator,denominator);
        numerator=numerator/f;
        denominator=denominator/f;
        String str2;
        if(numerator/denominator!=0&&numerator%denominator!=0){
            str2=numerator/denominator+"'"+numerator%denominator+"/"+denominator;
        }
        else if(numerator%denominator==0){
            str2=numerator/denominator+"";
        }
        else{
            str2=numerator+"/"+denominator;
        }
        return str2;
    }
}
