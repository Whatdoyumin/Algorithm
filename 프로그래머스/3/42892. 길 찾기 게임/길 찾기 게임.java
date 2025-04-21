import java.util.*;

class Solution {
    static class Node {
        int x, y, index;
        Node left, right;

        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        void insert(Node child) {
            if (child.x < x) {
                if (left == null) left = child;
                else left.insert(child);
            } else {
                if (right == null) right = child;
                else right.insert(child);
            }
        }

        void preorder(List<Integer> list) {
            list.add(index);
            if (left != null) left.preorder(list);
            if (right != null) right.preorder(list);
        }

        void postorder(List<Integer> list) {
            if (left != null) left.postorder(list);
            if (right != null) right.postorder(list);
            list.add(index);
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);

        Arrays.sort(nodes, (a, b) -> b.y != a.y ? b.y - a.y : a.x - b.x);

        Node root = nodes[0];
        for (int i = 1; i < n; i++) root.insert(nodes[i]);

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        root.preorder(pre);
        root.postorder(post);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }
}