import java.util.Scanner;

public class DiffOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st array numbers:");
        int n1 = sc.nextInt();

        int arr1[] = new int[n1];

        for(int i=0;i<arr1.length;i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the 2nd array numbers:");
        int n2 = sc.nextInt();

        int arr2[] = new int[n2];

        for(int i=0;i<arr2.length;i++){
            arr2[i] = sc.nextInt();
        }

        int[] diffArr = new int[n1 > n2 ? n1 : n2];
        int c = 0;

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diffArr.length - 1;

        while(k >= 0){
            int diff = 0;
            if(arr2[j] + c >= arr1[i]){
                diff = arr2[j] + c - arr1[i];
                c = 0;
            } else {
                diff = arr2[j] + c + 10 - arr1[j];
                c = -1;
            }

            diffArr[k] = diff;
            i--;
            j--;
            k--;

        }
    }
}
