class Solution {
    public String solution(String s) {
        String[] sarr = s.split(" ");
        int[] iarr = new int[sarr.length];
        for(int i = 0; i < sarr.length; i++) {
            iarr[i] = Integer.parseInt(sarr[i]);
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i : iarr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}