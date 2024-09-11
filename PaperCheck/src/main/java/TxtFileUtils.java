import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileUtils {

    // 读取文件内容并返回为 String
    public static String readTxtFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(ExceptionEnums.FILE_READ_ERROR);
        }
        return content.toString();
    }

    // 将内容写入到指定路径的文件
    public static void writeTxtFile(double content, String filePath) {
        // 将浮点数精确到小数点后两位
        String formattedContent = String.format("%.2f", content);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(formattedContent);
        } catch (IOException e) {
            // 抛出文件写入异常
            throw new RuntimeException(ExceptionEnums.FILE_WRITE_ERROR);
        }
    }
}
