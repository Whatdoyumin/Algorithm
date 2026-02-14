import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 두 배열의 값을 곱해 누적합하고, 최종적으로 누적된 최솟값을 return하는 문제
        
        int length = A.length;
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < length; i++) {
            sum += A[i] * B[length - 1 - i];
        }
        
        return sum;
    }
}