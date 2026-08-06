class Solution {

    public int rob(TreeNode root) {
        int[] result = dfs(root);

        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] result = new int[2];

        result[0] = node.val + left[1] + right[1];

        // 현재 노드를 훔치지 않은 경우
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }
}