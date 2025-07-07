package array_or_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextJustification {
    /*
        Leetcode (24/150)
        https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        Output:
        [
            "This    is    an",
            "example  of text",
            "justification.  "
        ]
        
        Example 2:
        Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
        Output:
        [
            "What   must   be",
            "acknowledgment  ",
            "shall be        "
        ]
    */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length, left = 0;

        while (left < n) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }   
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left, n = words.length;
        int sum = words[right++].length();

        while (right < n && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        return right-1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) {
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
        
        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++) {
            result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        }
        return padResult(result.toString().trim(), maxWidth);
    }
    
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }
        return wordsLength;
    }
    
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        int maxWidth = sc.nextInt();
        sc.close();
        
        List<String> result = new TextJustification().fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println(line);
        }
    }
}
