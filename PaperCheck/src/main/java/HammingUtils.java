public class HammingUtils {

    /**
     * 计算两个字符串的海明距离。
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 海明距离
     */
    public static int getHammingDistance(String str1, String str2) {
        //判断字符串长度是否相同
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException(ExceptionEnums.STRINGS_DIFFERENT_LENGTH_ERROR);
        }
        //计算两个字符串的海明距离
        int distance = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * 计算两个字符串的重复率。
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 重复率
     */
    public static double getSimilarity(String str1, String str2, int hammingDistance) {
        //判断字符串长度是否相同
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException(ExceptionEnums.STRINGS_DIFFERENT_LENGTH_ERROR);
        }
        //计算两个字符串的重复率
        return 1.0 - (double) hammingDistance / str1.length();
    }
}
