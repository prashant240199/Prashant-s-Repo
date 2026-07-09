import java.util.Scanner;

public class IsPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0;i<t;i++){
            int n = sc.nextInt();

            if(n <= 1){
                System.out.println("Not prime");
                continue;
            }
            
            int count = 0;
            for(int div = 2; div * div <= n; div++){
                if(n % div == 0){
                    count++;
                    break;
                }
            }

            if(count == 0){
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
