/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
문제 풀이시 주의할점
1. 부모 자식 노드간의 값이 root1과 root2가 같아야됌
2. 같은 레벨에 있는 형제노드 개수가 root1과 root2가 같아야됌 
*/
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        ArrayList<TreeNode> arr1= new ArrayList<>(); //tree1 node 저장할 리스트
        ArrayList<TreeNode> arr2= new ArrayList<>(); //tree2 node 저장할 리스트
        
        ArrayList<String> val1 = new ArrayList<>(); //tree1 부모 자식간의 value 저장할 리스트
        ArrayList<String> val2 = new ArrayList<>(); //tree2 부모 자식간의 value 저장할 리스트
        
        if(root1==null && root2==null){   // tree 1,2 모두 값이 없을때 참
            return true;
        }else if((root1==null && root2!=null) || (root1!=null && root2==null)) {
            return false;   // tree 1,2 둘 중 하나가 값이 없을때 거짓
        }
                            // 이외에 tree 1,2 가 모두 값이 있으면 아래 로직 실행
        arr1.add(root1);    // tree1의 root node 저장
        arr2.add(root2);    // tree2의 root node 저장
        val1.add("p=-1,"+root1.val);  // tree1의 parent-child 값 저장
        val2.add("p=-1,"+root2.val);  // tree2의 parent-child 값 저장
        
        while(arr1.size()!=0 || arr2.size()!=0){  // bfs 로 진행
                                                  // tree 1,2 둘다 같은 level에 있는 모든 노드를 리스트에 저장 
            int size1=arr1.size(); //현 level에서 tree1의 parent 개수
            int size2=arr2.size(); //현 level에서 tree2의 parent 개수
            
            for(int i=0; i<size1;i++){   //tree1의 왼쪽자식 있으면 추가 (부모-자식간 값도 저장 )
                if(arr1.get(i).left!=null){
                    arr1.add(arr1.get(i).left);
                    val1.add("p="+arr1.get(i).val+","+arr1.get(i).left.val);
                }
                if(arr1.get(i).right!=null){ //tree1의 오른쪽자식 있으면 추가 (부모-자식간 값도 저장)
                    arr1.add(arr1.get(i).right);
                    val1.add("p="+arr1.get(i).val+","+arr1.get(i).right.val);
                }
            }
            
            for(int i=0; i<size1;i++){ // tree1 부모노드 제거
                arr1.remove(0);
                val1.remove(0);
            }
            Collections.sort(val1);  // 부모 자식 노드간의 값을 저장한 리스트를 정렬한다.
            
            for(int j=0; j<size2;j++){   //tree2의 왼쪽자식 있으면 추가 (부모-자식간 값도 저장 )
                if(arr2.get(j).left!=null){
                    arr2.add(arr2.get(j).left);
                    val2.add("p="+arr2.get(j).val+","+arr2.get(j).left.val);
                }
                if(arr2.get(j).right!=null){ //tree2의 오른쪽자식 있으면 추가 (부모-자식간 값도 저장)
                    arr2.add(arr2.get(j).right);
                    val2.add("p="+arr2.get(j).val+","+arr2.get(j).right.val);
                }
            }
            
            for(int j=0; j<size2;j++){ //tree2 부모노드 제거
                arr2.remove(0);
                val2.remove(0);             
            }
            Collections.sort(val2); //부모 자식 노드간의 값을 저장한 리스트를 정렬한다.
            
            if(val1.size()!=val2.size()){
                return false;   //부모 자식 노드간의 값의 사이즈가 다르면 거짓
            }
            for(int k=0; k<Math.max(val1.size(),val2.size());k++){
                
                if(!val1.get(k).equals(val2.get(k))){ // tree 1,2 정렬한 부모 자식간의 값이 다르면 거짓
                    return false;
                }
            }          
        }
        return true;
    }
}