public class MainPaperCheck {
    public static void main(String[] args) {
        //判断命令行参数是否错误
        if (args.length != 3) {
            throw new RuntimeException(ExceptionEnums.PARAMETER_INPUT_ERROR);
        }

        //读取命令行参数（分别为源文件、抄袭文件、答案文件）
        String source_file = TxtFileUtils.readTxtFile(args[0]);
        String plagiarized_file = TxtFileUtils.readTxtFile(args[1]);
        String answer_file = args[2];

        //论文重复率计算
        //1.计算每个文本的SimHash值
        String simHash1 = SimHashUtils.getSimHash(source_file);
        String simHash2 = SimHashUtils.getSimHash(plagiarized_file);
        //计算SimHash值之间的海明距离
        int hammingDistance = HammingUtils.getHammingDistance(simHash1, simHash2);
        // 计算文本之间的相似度
        double repetition_rate = HammingUtils.getSimilarity(simHash1, simHash2, hammingDistance);

        //将重复率结果写入答案文件
        TxtFileUtils.writeTxtFile(repetition_rate, answer_file);

        //关闭程序
        System.exit(0);
    }
}
