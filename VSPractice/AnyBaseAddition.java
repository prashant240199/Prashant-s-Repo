import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = sc.nextInt();

        System.out.println("Enter the second number:");
        int num2 = sc.nextInt();

        System.out.println("Enter the base:");
        int base = sc.nextInt();

        int res = additionOfNumbers(num1, num2, base);
        System.out.println(res);
    }

    public static int additionOfNumbers(int num1, int num2, int base){
        int res = 0;
        int carry = 0;
        int pow = 0;

        while(num1 > 0 || num2 > 0 || carry > 0){
            int firstRem = num1 % 10;
            int secRem = num2 % 10;
            num1 /= 10;
            num2 /= 10;

            int sum = carry + firstRem + secRem;
            carry = sum / base;
            sum %= base;

            res += sum * (int) Math.pow(10, pow);
            pow += 1;
        }

        return res;
    }
}
