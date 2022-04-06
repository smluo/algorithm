package niuke.huawei;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 * 输入：hello nowcoder 输出：8
 */
public class HJ1 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arry = str.split(" ");
        System.out.println(arry[arry.length - 1].length());
    }

    private static void demo2() throws IOException {
        int count = 0;
        InputStream in = System.in;
        char c = (char) in.read();
        while(c != '\n'){
            if(c == ' ')
                count = 0;
            else
                count++;
            c = (char) in.read();
        }
        System.out.println(count);
    }
}
