import java.util.Scanner;

public class SpanOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the count:");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the numbers:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i] < min) {
                min = arr[i];
            } 
            
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int diff = max - min;
        System.out.println("Result: "+diff);
    }
}
