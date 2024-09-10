public class MainPaperCheck {
    public static void main(String[] args) {
        //命令行参数错误
        if (args.length != 3) {
            throw new RuntimeException(ExceptionEnums.PARAMETER_INPUT_ERROR);
        }

        //读取命令行参数（分别为源文件、抄袭文件、答案文件）
        String source_file = TxtFileUtils.readTxtFile(args[0]);
        String plagiarized_file = TxtFileUtils.readTxtFile(args[1]);
        String answer_file = args[2];

        //定义重复率变量
        double repetition_rate = 0.00;

        //todo 论文重复率计算

        //将重复率结果写入答案文件
        TxtFileUtils.writeTxtFile(repetition_rate, answer_file);

        //关闭程序
        System.exit(0);
    }
}
