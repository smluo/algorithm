package niuke.huawei;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 数字颠倒
 * 描述：
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * <p>
 * 数据范围： 0=<n<=2^30-1
 * 输入描述：
 * 输入一个int整数
 * <p>
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 * <p>
 * 输入：1516000 输出：0006151
 */
public class HJ11 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    /**
     * 运行时间:44ms 占用内存:10848KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = String.valueOf(num);
        String[] arry = str.split("");
        String res = "";
        for (int i = arry.length - 1; i >= 0; i--) {
            res += arry[i];
        }
        System.out.println(res);
    }

    /**
     * 运行时间:9ms 占用内存:9252KB
     */
    private static void demo2() throws IOException {
        InputStream is = System.in;
        int available = is.available() - 1;
        char[] arr = new char[available];
        while (available-- > 0) {
            arr[available] = (char)is.read();
        }
        String result = String.valueOf(arr);
        System.out.println(result);
    }
}
