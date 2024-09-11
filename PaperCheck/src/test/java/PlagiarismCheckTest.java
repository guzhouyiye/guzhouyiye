import org.junit.jupiter.api.Test;

public class PlagiarismCheckTest {

    //无参数输入
    @Test
    void test1() {
        MainPaperCheck.main(new String[]{});
    }

    //参数中文件名不添加路径
    @Test
    void test2() {
        MainPaperCheck.main(new String[]{
                "orig.txt",
                "orig_0.8_add.txt",
                "result.txt",
        });
    }

    //参数少输入
    @Test
    void test3() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
        });
    }

    //参数多输入
    @Test
    void test4() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
                "src/main/resources/orig_0.8_del.txt",
                "src/main/resources/result.txt",
        });
    }

    //参数中文件路径错误
    @Test
    void test5() {
        MainPaperCheck.main(new String[]{
                "src/main/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
                "src/main/resources/result.txt",
        });
    }

    @Test
    void test6() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
                "src/main/resources/result.txt",
        });
    }

    @Test
    void test7() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_del.txt",
                "src/main/resources/result.txt",
        });
    }

    @Test
    void test8() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_dis_1.txt",
                "src/main/resources/result.txt",
        });
    }

    @Test
    void test9() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_dis_10.txt",
                "src/main/resources/result.txt",
        });
    }

    @Test
    void test610() {
        MainPaperCheck.main(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_dis_15.txt",
                "src/main/resources/result.txt",
        });
    }




}
