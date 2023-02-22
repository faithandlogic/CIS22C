package stacknqueue;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String myString = input.nextLine();
        System.out.println(isPalindrome(myString));
        input.close();
    }

    public static boolean isPalindrome(String s) {
        LinkedStack<Character> stack = new LinkedStack<>();
        LinkedQueue<Character> queue = new LinkedQueue<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.enqueue(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue())
                return false;
        }
        return true;
    }
}
