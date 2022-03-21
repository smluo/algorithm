package niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class HJ12 {
    public static void main(String[] args) throws IOException {
        demo1();
    }

    /**
     * 运行时间:42ms 占用内存:13268KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arry = str.split("");
        String res = "";
        for (int i = arry.length - 1; i >= 0; i--) {
            res += arry[i];
        }
        System.out.println(res);
    }

    /**
     * 运行时间:9ms 占用内存:9304KB
     */
    private static void demo2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        System.out.println(new StringBuffer(string).reverse());
    }
}
