import java.util.Scanner;

public class ConvertDecimalToAnyBase {
    public static int convertDecimalToAnyBase(int num, int base){
        int val = 0,pow = 0;

        while(num > 0){
            int rem = num % base;
            num /= base;
            val += rem * (int) Math.pow(10, pow);
            pow += 1;
        }
        return val;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = sc.nextInt();

        System.out.println("Enter the base:");
        int base = sc.nextInt();

        int val = convertDecimalToAnyBase(num, base);
        System.out.println("Result: " + val);
    }
}
