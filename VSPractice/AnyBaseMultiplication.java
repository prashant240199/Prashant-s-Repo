import java.util.Scanner;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base:");
        int base = sc.nextInt();

        System.out.println("Enter the first number:");
        int num1 = sc.nextInt();
        
        System.out.println("Enter the second number:");
        int num2 = sc.nextInt();

        int res = anyBaseMultiplication(num1, num2, base);
        System.out.println(res);
    }

    public static int anyBaseMultiplication(int num1, int num2, int base){
        int res = 0;
        int carry = 0;
        int pow = 0;

        while(num1 > 0 || carry > 0){
            int d1 = num1 % 10;
            num1 /= 10;

            int d2 = num2;

            int dig = (d1 * d2) + carry;
            int num = dig % base;

            carry = dig / base;

            res += num * (int) Math.pow(10, pow);
            pow += 1;
        }
        return res;
    }
}
