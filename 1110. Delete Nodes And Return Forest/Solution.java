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
    
    // 꼭 여러번 풀어보자!!!
    
    ArrayList<TreeNode> al = new ArrayList<TreeNode>(); //최종결과 저장할 리스트 생성
    
    public boolean check(int val,int[] delete){ // 지워야하는 목록에 노드값이 있는지 확인하는 함수
        for(int i=0; i<delete.length;i++){
            if(val==delete[i]){
                return false; //있으면 거짓
            }
        }
        return true;     //없으면 참
    }
    
    public TreeNode postOrder(TreeNode node,int[] delete){ // 노드를 후위순회하며 조건이 맞으면 포레스트 생성
  
        if(node.left!=null ){  // 왼쪽 자식노드 탐색
            node.left=postOrder(node.left,delete);
        }
        if(node.right!=null ){ // 오른쪽 자식노드 탐색
            node.right=postOrder(node.right,delete);
        }
        if(!check(node.val,delete)){ // 해당노드가 지워야하는 목록에 속할때 
            //System.out.println(node.val);
            if(node.left!=null ){  // 노드의 왼쪽 자식노드가 있으면 포레스트
                al.add(node.left);
            }
            if(node.right!=null ){ // 노드의 오른쪽 자식노드가 있으면 포레스트
                al.add(node.right);
            }
            node=null;  // 해당노드 지움
        }
        return node; 
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
                
        TreeNode r=postOrder(root,to_delete);
        if(r!=null){    //반환값이 null일 경우 삽입하지 않음
            al.add(r);
        }
        return al;
    }
}