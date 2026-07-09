public class FindPair {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7};
        int target = 9;

        int start = 0, end = arr.length - 1;

        while(start < end){
            if(arr[start] + arr[end] == target){
                System.out.println("[" + arr[start] + "," + arr[end] + "]");
                return;
            } else if((arr[start] + arr[end]) < target){
                start++;
            } else{
                end--;
            }
        }
    }
}
