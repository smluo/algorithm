package niuke.huawei;

import java.util.Scanner;

/**
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 数据范围：1≤n≤2×10
 * 输入描述：
 * 输入一个整数
 * <p>
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 * <p>
 * 示例1
 * 输入：180 输出：2 2 3 3 5
 */
public class HJ6 {
    public static void main(String[] args) {
        demo2();
    }

    /**
     * 运行超时了 运行时间2001ms 占用内存 10816KB
     */
    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 2; i <= num; i++) {
            if(num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
                i = 1;
            }
        }
    }

    /**
     * 运行时间44ms 占用内存 10908KB
     */
    private static void demo2() {
        Scanner in=new Scanner(System.in);
        long num=in.nextLong();
        getPrimer(num);
    }
    public static void getPrimer(long num){
        long sqrNum=(long)Math.sqrt(num);
        for(int i=2;i<=sqrNum;i++){
            if(num%i==0){
                System.out.print(i+" ");
                getPrimer(num/i);
                break;
            }
            if(i==sqrNum){
                System.out.print(num+" ");
            }
        }
    }
}
