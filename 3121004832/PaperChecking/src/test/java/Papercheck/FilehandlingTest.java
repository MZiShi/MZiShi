package Papercheck;

import org.junit.jupiter.api.Test;

class FilehandlingTest {

    @Test
    void readTxtfailTest() {
        //路径错误，读取失败
        String str =Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\none.txt");
    }
    @Test
    void readTxtfail2Test() {
        //非txt文件
        String str =Filehandling.readTxt("none");
    }
    @Test
    void readTxtTest() {
        //路径正确，正常读取
        String str =Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\test.txt");
        System.out.println(str);
    }
    @Test
    void writeTxtTest() {
        //路径正确，写入成功
        String str="1.23";
        Filehandling.writeTxt(str,"none.txt");
    }
    @Test
    void writeTxtfailTest() {
        //路径错误，写入失败
        String str="1.23";
        Filehandling.writeTxt(str,"d\\none.txt");
    }
    @Test
    void writeTxtfail2Test() {
        //非txt文件
        String str="1.23";
        Filehandling.writeTxt(str,"none");
    }
    @Test
    void readTxtHtmlTest(){
        //文本预处理，去除Html标签
        String str =Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\test2.txt");
        System.out.println(str);
    }
}