package niuke.huawei;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * <p>
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 * 输入一个整数（int类型）
 * <p>
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
 */
public class HJ15 {
    public static void main(String[] args) {
        System.out.println(5 / 2);
        System.out.println(5 % 2);
    }

    /**
     * 运行时间42ms 占用内存 10836KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;
        while(num > 1) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }
        System.out.println(count);
    }

    /**
     * 运行时间5ms 占用内存 9044KB
     * @throws IOException
     */
    private static void demo2() throws IOException {
        InputStream stream = System.in;
        int l ;
        byte[] bytes = new byte[1024];
        while ((l = stream.read(bytes)) > 0) {
            String numStr = new String(bytes, 0, l - 1);
            int num = Integer.parseInt(numStr);
            char [] numChars = Integer.toBinaryString(num).toCharArray();
            int countNum = 0;
            for (int i = 0;i < numChars.length; i++){
                if (numChars[i] == '1'){
                    countNum = countNum + 1;
                }
            }
            System.out.println(countNum);
        }
    }
}
