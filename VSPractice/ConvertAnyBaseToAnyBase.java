import java.util.Scanner;

public class ConvertAnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();

        System.out.println("Enter the base 1:");
        int b1 = sc.nextInt();

        System.out.println("Enter the base 2:");
        int b2 = sc.nextInt();

        int res = convertAnyBaseToAnyBase(n, b1, b2);
        System.out.println(res);
    }

    public static int convertAnyBaseToAnyBase(int n, int b1, int b2){
        int res = 0, pow = 0;
        
        while (n > 0) {
            int rem = n % b2;
            n /= b2;
            res += rem * (int) Math.pow(b1, pow);
            pow += 1;
        }

        return res;
    }
}
