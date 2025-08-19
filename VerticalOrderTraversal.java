// TC : O(N)
// SC : O(N)

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        q.add(root);
        col.add(0);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min=0,max=0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int num = col.poll();
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
            min = min < num ? min : num;
            max = max > num  ? max : num;
            map.get(num).add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
                col.add(num-1);
            }
            if(curr.right != null){
                q.add(curr.right);
                col.add(num+1);
            }
        }
        for(int i = min;i<= max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}
