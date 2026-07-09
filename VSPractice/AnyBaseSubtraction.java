import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base:");
        int base = sc.nextInt();

        System.out.println("Enter the first number:");
        int num1 = sc.nextInt();
        
        System.out.println("Enter the second number:");
        int num2 = sc.nextInt();

        int res = anyBaseSubtraction(num1, num2, base);
        System.out.println(res);
    }

    public static int anyBaseSubtraction(int num1, int num2, int base){
        int res = 0;
        int carry = 0;
        int pow = 0;

        while(num2 > 0){
            int rem1 = num1 % 10;
            int rem2 = num2 % 10;

            num1 /= 10;
            num2 /= 10;

            int dig = 0;
            rem2 = rem2 + carry;

            if(rem2 >= rem1){
                carry = 0;
                dig = rem2 - rem1;
            } else {
                carry = -1;
                dig = rem2 + base - rem1;
            }

            res = res + dig * (int) Math.pow(10, pow);
            pow += 1;
        }
        return res;
    }
}
