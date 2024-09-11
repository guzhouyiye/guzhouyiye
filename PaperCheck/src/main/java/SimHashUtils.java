import com.hankcs.hanlp.HanLP;
import java.util.List;

public class SimHashUtils {
    /**
     * 计算字符串的SimHash值。
     * @param str 字符串
     * @return SimHash值的二进制字符串表示
     */
    public static String getSimHash(String str) {
        //对文本进行分词
        List<String> keywords = HanLP.extractKeyword(str, str.length());
        //生成哈希值的基本值
        long[] hashBits = new long[64];
        
        for (String keyword : keywords) {
            String hash = getHash(keyword);
            for (int i = 0; i < hash.length(); i++) {
                if (hash.charAt(i) == '1') {
                    hashBits[i] += 1;
                } else {
                    hashBits[i] -= 1;
                }
            }
        }

        //生成最终的SimHash值
        StringBuilder simHash = new StringBuilder();
        for (long bit : hashBits) {
            simHash.append(bit >= 0 ? '1' : '0');
        }

        return simHash.toString();
    }

    /**
     * 计算字符串的哈希值。
     * @param str 字符串
     * @return 哈希值的二进制字符串表示
     */
    public static String getHash(String str) {
        //使用java的内建哈希函数
        int hash = str.hashCode();
        //将哈希值转换为二进制字符串
        String binaryHash = Integer.toBinaryString(hash);
        //保证哈希值为32位
        return String.format("%32s", binaryHash).replace(' ', '0');
    }
}
