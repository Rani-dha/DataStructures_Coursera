import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
    this.type = type;
    this.position = position;
    }

    // boolean Match(char b, char c) {
    //     if (b == '[' && c == ']')
    //         return true;
    //     if (b == '{' && c == '}')
    //         return true;
    //     if (b == '(' && c == ')')
    //         return true;
    //     return false;
    // }
    boolean Match(char c) {
    if (this.type == '[' && c == ']')
    return true;
    if (this.type == '{' && c == '}')
    return true;
    if (this.type == '(' && c == ')')
    return true;
    return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        //Bracket obj = new Bracket();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        int position;
        for (position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(next,position);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (opening_brackets_stack.Match(opening_brackets_stack.peek(), next))
                    opening_brackets_stack.pop();
                else {
                    break;
                }
            }
            // Printing answer, write your code here
        }

        if (opening_brackets_stack.isEmpty())
            System.out.println("success");
        else
            System.out.println((position + 1));
    }
}
