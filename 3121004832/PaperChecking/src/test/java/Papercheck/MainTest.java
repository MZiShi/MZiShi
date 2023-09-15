package Papercheck;

import org.junit.jupiter.api.Test;


class MainTest {

    @Test
    void mainTest() {
        String path1 = Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig.txt");
        String path2= Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig_0.8_add.txt");
        String path3 = Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig_0.8_del.txt");
        String path4= Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig_0.8_dis_1.txt");
        String path5 = Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig_0.8_dis_10.txt");
        String path6= Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig_0.8_dis_15.txt");
        String simHash1 = Simhash.GetSimhash(path1);
        String simHash2 = Simhash.GetSimhash(path2);
        String simHash3 = Simhash.GetSimhash(path3);
        String simHash4 = Simhash.GetSimhash(path4);
        String simHash5 = Simhash.GetSimhash(path5);
        String simHash6 = Simhash.GetSimhash(path6);
        String similarity1 = HammingDistance.GetSimilarity(simHash1, simHash2);
        String similarity2 = HammingDistance.GetSimilarity(simHash1, simHash3);
        String similarity3 = HammingDistance.GetSimilarity(simHash1, simHash4);
        String similarity4 = HammingDistance.GetSimilarity(simHash1, simHash5);
        String similarity5 = HammingDistance.GetSimilarity(simHash1, simHash6);
        Filehandling.writeTxt(similarity1, "answer.txt");
        Filehandling.writeTxt(similarity2, "answer.txt");
        Filehandling.writeTxt(similarity3, "answer.txt");
        Filehandling.writeTxt(similarity4, "answer.txt");
        Filehandling.writeTxt(similarity5, "answer.txt");
    }

}