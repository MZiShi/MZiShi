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
    }

    @org.junit.jupiter.api.Test
    void gcd() {
    }
    @Test
    void EquationCreateTest(){
        List<List<String>> a=Generate.EquationCreate(10000,10);
       for (List<String> b:a){
            System.out.println(String.join(" ",b));
        }
    }
    @Test
    void AnswerTest(){
        List<List<String>> a=Generate.EquationCreate(10,1000);
        List<String> b=Generate.Answer(a);
        for (List<String> c:a){
            System.out.println(String.join(" ",c));
        }
        for(String d:b){
            System.out.println(d);
        }
    }
}