package niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 句子逆序
 * 描述:
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * <p>
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * <p>
 * 数据范围：输入的字符串长度满足1≤n≤1000
 * <p>
 * 注意本题有多组输入
 * 输入描述：输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 * <p>
 * 输出描述：得到逆序的句子
 * <p>
 * 输入：I am a boy 输出：boy a am I
 */
public class HJ13 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    /**
     * 运行时间:38ms 占用内存:10972KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arry = str.split(" ");
        String res = "";
        for (int i = arry.length - 1; i >= 0; i--) {
            res += arry[i] + " ";
        }
        System.out.println(res);
    }

    /**
     * 运行时间:5ms 占用内存:9224KB
     */
    private static void demo2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            char[] chars = (str + " ").toCharArray();
            int len = str.length();
            // 碰到空格就将当前
            int first = 0;
            int last = len;
            char[] newchar = new char[len];
            for (int j = 0; j <= str.length(); j++) {
                char c = chars[j];
                if (c == ' ') {
                    // 需要copy的长度
                    int _len = j - first;
                    // 开始位置
                    int despos = last - _len;
                    System.arraycopy(chars, first, newchar, despos, _len);
                    // 从旧的下一个位置开始copy，需要赋值空，所以多移动一位
                    first = j + 1;
                    len = len - _len - 1;
                    last = len;
                    // copy完成后，指针变动后，赋值空
                    if (last > 0) {
                        newchar[last] = ' ';
                    }
                }
            }
            System.out.println(new String(newchar));
        }
    }
}
