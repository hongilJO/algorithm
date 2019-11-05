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
    //중위순회로 읽은 숫자값 저장할 리스트 생성 
    ArrayList<Integer> al= new ArrayList<>();
   
    //recursive 함수 inorder 생성 
    //중위순회로 노드별 값 읽어서 리스트 저장  (중위순회는 좌-중-우 순서로 탐색)
    public void inorder(TreeNode node){        
        if(node.left!=null){
            inorder(node.left);
        }
        if(node!=null){
            al.add(node.val);
        }
        if(node.right!=null){
            inorder(node.right);
        }
       
    }
    // 리스트에서 순서대로 저장된 값을 읽어 오른쪽에만 기울어진 트리를 생성 (매우 비효율적인 트리다 ㄷ;)
    public TreeNode makeTree(){
        TreeNode node=new TreeNode(al.get(0)); // 트리 루트 생성
        TreeNode result=node;// 나중에 리턴하기위해 변수에 저장
        for(int i=1; i<al.size();i++){ //루트의 오른쪽 자식노드에 순서대로 저장된 값 넣어 붙임
            node.right=new TreeNode(al.get(i));
            node=node.right;
        }
        return result; //루트노드 반환
    }
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode node=makeTree();
        return node;
    }
}