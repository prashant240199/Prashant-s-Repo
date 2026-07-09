import java.util.Scanner;

public class FindAnElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the count:");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the numbers:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number want to find:");
        int num = sc.nextInt();

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                System.out.println("Index:" + i);
                break;
            }
        }
    }
}
