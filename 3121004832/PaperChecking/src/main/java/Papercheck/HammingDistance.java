package Papercheck;

public class HammingDistance {
    public static double GetSimilarity(String simHash1,String simHash2){
            double distance=0;
        for (int i = 0; i < simHash1.length(); i++) {
            // 每一位进行比较
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return 0.01 * (100 - distance * 100 / 128);
    }
}
