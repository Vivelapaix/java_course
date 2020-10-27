
## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

```python
    def reverseList(self, head: ListNode) -> ListNode:
        prev, cur, next = None, head, None
        
        
        while cur is not None:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
            
        return prev  
```