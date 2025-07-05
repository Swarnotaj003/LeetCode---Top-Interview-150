package array_or_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HIndex {
    /*
        Leetcode (11/150)
        https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example :
        Input: citations = [3,0,6,1,5]
        Output: 3
        Explanation: Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
    */ 

    public int hIndex(int[] citations) {
        int papers = citations.length;
        int[] count = new int[papers + 1];

        for (int citation : citations) {
            count[Math.min(citation, papers)]++;
        }

        int hIndex = 0;
        int cumulativePapers = 0;
        for (int i = papers; i >= 0; i--) {
            cumulativePapers += count[i];
            if (cumulativePapers >= i) {
                hIndex = i;
                break;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        BufferedReader br;
        int n, nums[] = new int[0];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i]);
            }
            br.close();
        } catch (NumberFormatException | IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        
        int ans = new HIndex().hIndex(nums);
        System.out.println(ans);
    }
}
