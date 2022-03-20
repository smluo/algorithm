package niuke.huawei;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 提取不重复的整数
 * 描述:
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * <p>
 * 数据范围： 1≤n≤10^8
 * <p>
 * 输入描述：输入一个int型整数
 * <p>
 * 输出描述：按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 示例1: 输入：9876673 输出：37689
 */
public class HJ9 {
    public static void main(String args[]) {
        demo1();
    }

    /**
     * 运行时间: 52ms, 占用内存: 10948KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arry = (num + "").split("");
        String res = "";
        for (int i = arry.length - 1; i >= 0; i--) {
            if (!res.contains(arry[i])) {
                res += arry[i];
            }
        }
        System.out.println(Integer.parseInt(res));
    }

    /**
     * 运行时间: 17ms, 占用内存: 9360KB
     * @throws IOException
     */
    private static void demo2() throws IOException {
        InputStream in = System.in;
        int available = in.available() - 1;
        char[] chars = new char[available];
        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        StringBuilder resul = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (resul.lastIndexOf(String.valueOf(chars[i])) != -1) {
                continue;
            }
            resul.append(chars[i]);
        }
        System.out.println(resul.toString());
    }
}