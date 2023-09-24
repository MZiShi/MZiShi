package maker;


import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateTest {

    @org.junit.jupiter.api.Test
    void creat() {
        System.out.println(String.join(" ",Generate.Creat(10)));
    }

    @org.junit.jupiter.api.Test
    void creatFraction() {
        System.out.println(Generate.CreatFraction(10));
    }

    @Test
    void EquationCreateTest(){
        //生成试题
        List<List<String>> a=Generate.EquationCreate(10,10);
       for (List<String> b:a){
            System.out.println(String.join(" ",b));
        }
    }
    @Test
    void AnswerTest(){
        //计算答案
        List<List<String>> a=Generate.EquationCreate(10,10);
        List<String> b=Generate.Answer(a);
        for (List<String> c:a){
            System.out.println(String.join(" ",c));
        }
        for(String d:b){
            System.out.println(d);
        }
    }
}