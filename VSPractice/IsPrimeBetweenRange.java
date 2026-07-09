import java.util.Scanner;

public class IsPrimeBetweenRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lowest number: ");
        int low = sc.nextInt();

        System.out.println("Enter highest1 number: ");
        int high = sc.nextInt();

        for(int n = low; n <= high; n++){
            int count = 0;

            // try to divide n and increase count 
            for(int div = 2; div * div <= n; div++){
                if(n % div == 0){
                    count++;
                    break;
                }
            }

            if(count == 0) System.out.println(n);
        }
    }
}
