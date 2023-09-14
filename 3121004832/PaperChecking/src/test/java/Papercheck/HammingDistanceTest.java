package Papercheck;

import org.junit.jupiter.api.Test;


class HammingDistanceTest {

    @Test
    void getSimilarityTest() {
        String path1 = Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig.txt");
        String path2= Filehandling.readTxt("E:\\GitHub\\MZiShi\\3121004832\\PaperChecking\\src\\main\\resources\\测试文本\\orig_0.8_add.txt");
        String simHash0 = Simhash.GetSimhash(path1);
        String simHash1 = Simhash.GetSimhash(path2);
        String similarity = HammingDistance.GetSimilarity(simHash0, simHash1);
        System.out.println(similarity);
    }
}