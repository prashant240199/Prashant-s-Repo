import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if(c == ')') {
                boolean b = handleClosing(st, '(');
                if(b == false) {
                    System.out.println(b);
                    return;
                }
            } else if(c == '}') {
                boolean b = handleClosing(st, '{');
                if(b == false) {
                    System.out.println(b);
                    return;
                }
            } else if(c == ']') {
                boolean b = handleClosing(st, '[');
                if(b == false) {
                    System.out.println(b);
                    return;
                }
            }
        }

        if(st.size() == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean handleClosing(Stack<Character> st, char corrOpenChar) {
        if(st.size() == 0){
            return false;
        } else if(st.peek() != corrOpenChar) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}
