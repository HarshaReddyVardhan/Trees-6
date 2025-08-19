// TC : O(N)
// SC : O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("#,");
            } else {
                q.add(curr.left);
                q.add(curr.right);
                sb.append(curr.val);
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if (data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        int n = arr.length;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < n) {
            TreeNode curr = q.poll();
            if (!arr[i].equals("#")) {
                TreeNode newNode = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = newNode;
                q.add(newNode);
            }
            i++;
            if (!arr[i].equals("#")) {
                TreeNode newNode = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = newNode;
                q.add(newNode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
