import java.util.Scanner;

public class ConvertAnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();

        System.out.println("Enter the base:");
        int b = sc.nextInt();

        int dig = convertAnyBaseToDecimal(n, b);
        System.out.println(dig);
    }

    public static int convertAnyBaseToDecimal(int n, int b){
        int rv = 0, pow = 0;

        while(n > 0){
            int rem = n % 10;
            n /= 10;

            rv += rem * (int) Math.pow(b, pow);
            pow += 1;
        }

        return rv;
    }
}