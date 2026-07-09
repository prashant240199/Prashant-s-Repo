public class Pattern4 {
    public static void main(String[] args) {
        int n = 5;

        for(int i=n;i>=1;i--){
            for(int j=n-i;j>=1;j--){
                System.out.print("\t");
            }

            for(int j=i;j>=1;j--){
                System.out.print("*\t");
            }

            System.out.println();
        }
    }
}
