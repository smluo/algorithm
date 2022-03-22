package niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * <p>
 * 数据范围： 1≤n≤1000  ，字符串长度满足 1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class HJ14 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    /**
     * 运行时间：156ms 占用内存：17444KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // 需要加入这一行读取nextInt遗留下的\n
        sc.nextLine();
        String[] arry = new String[num];
        for (int i = 0; i < num; i++) {
            arry[i] = sc.nextLine();
        }
        for (int x = num - 1; x >= 1; x--) {
            for (int y = 0; y <= x - 1; y++) {
                if (arry[y].compareTo(arry[y + 1]) > 0) {
                    String tmp = arry[y];
                    arry[y] = arry[y + 1];
                    arry[y + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.println(arry[i]);
        }
    }

    /**
     * 运行时间：7ms 占用内存：9176KB
     */
    private static void demo2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] result = new String[count];
        for (int i = 0; i < count; i++) result[i] = bf.readLine();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(result);
        for (String w : result) sb.append(w).append('\n');
        System.out.println(sb.toString());
    }
}
