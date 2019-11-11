class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode copy=head; // 노드 맨 처음 위치를 복사 
        int count=0;  // 리스트의 총 노드 개수나타냄
        
        while(head!=null){     // 리스트의 맨 마지막까지 반복문을 돌려 노드 개수 확인
            head=head.next;
            count++;           
        }
        
        int mid=(count/2)+1;   // 총 노드개수를 반으로 나누고 1을 더함,이를 통해 middle node가 몇번째인지 알아냄,  
        int rotate=1;        // middle 노드를 가기위한 인덱스
        
        while(rotate<mid){  // 인덱스 값이 mid 값이랑 같을때까지 이동
            copy=copy.next;
            rotate++;
        }
        return copy;  // 미들노드 반환
    }
}