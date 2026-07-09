import java.util.Scanner;

public class InverseOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = sc.nextInt();

        System.out.println("Enter the times of rotation of a number:");
        int k = sc.nextInt();

        int temp = n;
        int nod = 0;
        while(temp > 0){
            temp = temp/10;
            nod++; 
        }

        k = k % nod;
        if(k < 0){
            k += nod;
        }

        int div = 1;
        int mult = 1;
        for(int i = 1;i <= nod;i++){
            if(i <= k){
                div *= 10;
            } else{
                mult *= 10;
            }
        }

        int q = n / div;
        int r = n % div;

        int rot = r * mult + q;
        System.out.println(rot);
    }
}
