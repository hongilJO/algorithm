/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
        // 리프노드를 찾기위해 후위 순회 실행
    public void postOrder(TreeNode node, ArrayList<TreeNode> tree){
        
        if(node.left!=null){     // 왼쪽 자식노드 탐색
            postOrder(node.left,tree);        
        }
        if(node.right!=null){    // 오른쪽 자식노드 탐색
            postOrder(node.right,tree);
        }
        
        if(node.left==null && node.right==null){ //자식 노드가 없으면 리프노드이므로 리스트에 삽입 
            tree.add(node);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<TreeNode> tree1 = new ArrayList<>(); // 두 리프노드 저장할 리스트 생성
        ArrayList<TreeNode> tree2 = new ArrayList<>();
        
        postOrder(root1,tree1); // 두 트리를 순회한다.
        postOrder(root2,tree2);
        
        for(int i=0; i<tree1.size();i++){
            if(tree1.get(i).val!=tree2.get(i).val){ // 순회후 얻은 리프노드들이 같은지 비교
                return false;
            }
        }
        return true;
    }
}