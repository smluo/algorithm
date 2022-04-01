package niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * <p>
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * <p>
 * 坐标之间以;分隔。
 * <p>
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * <p>
 * 下面是一个简单的例子 如：
 * <p>
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 处理过程：
 * <p>
 * 起点（0,0）
 * <p>
 * +   A10   =  （-10,0）
 * <p>
 * +   S20   =  (-10,-20)
 * <p>
 * +   W10  =  (-10,-10)
 * <p>
 * +   D30  =  (20,-10)
 * <p>
 * +   x    =  无效
 * <p>
 * +   A1A   =  无效
 * <p>
 * +   B10A11   =  无效
 * <p>
 * +  一个空 不影响
 * <p>
 * +   A10  =  (10,-10)
 * <p>
 * 结果 （10， -10）
 * <p>
 * 数据范围：每组输入的字符串长度满足 1≤n≤10000  ，坐标保证满足 -2^31 <x,y <2^31 - 1，且数字部分仅含正数
 * 输入描述：
 * 一行字符串
 * <p>
 * 输出描述：
 * 最终坐标，以逗号分隔
 * <p>
 * 示例1
 * 输入：A10;S20;W10;D30;X;A1A;B10A11;;A10; 输出：10,-10
 */
public class HJ17 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    /**
     * 运行时间：57ms 占用内存：11208KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arry = str.split(";");
        int x = 0;
        int y = 0;
        for(int i = 0; i < arry.length; i ++) {
            if(arry[i].length() <= 1){
                continue;
            }
            String prefix = arry[i].substring(0, 1);
            if(!prefix.equals("A") && !prefix.equals("D") && !prefix.equals("W") && !prefix.equals("S")) {
                continue;
            }
            String suffix = arry[i].substring(1);
            try {
                int num = Integer.parseInt(suffix);
                switch (prefix) {
                    case "A":
                        x -= num;
                        break;
                    case "D":
                        x += num;
                        break;
                    case "W":
                        y += num;
                        break;
                    case "S":
                        y -= num;
                        break;
                    default:
                        break;
                }
            } catch(Exception e) {

            }
        }
        System.out.println(x + "," + y);
    }

    /**
     * 运行时间：8ms 占用内存：9108KB
     * @throws IOException
     */
    private static void demo2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            int x = 0;
            int y = 0;
            String[] strs = input.split(";");
            for(String str : strs) {
                int v = 0;
                if("".equals(str) || str.length() > 3) continue;
                for(int i = 1; i < str.length(); i++) {
                    int t = str.charAt(i) - '0';
                    if(t >= 0 && t <= 9) {
                        if(i == 1 && str.length() != 2) v += t * 10;
                        else v += t;
                    } else {
                        v = 0;
                        break;
                    }
                }
                char c = str.charAt(0);
                switch(c) {
                    case 'A':
                        x -= v;
                        break;
                    case 'D':
                        x += v;
                        break;
                    case 'W':
                        y += v;
                        break;
                    case 'S':
                        y -= v;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
