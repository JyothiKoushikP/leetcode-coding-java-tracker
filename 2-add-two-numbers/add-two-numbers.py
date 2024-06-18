# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        carry = 0
        prev = ListNode(-1)
        pointer = prev
        fn,sn = l1,l2
        while fn is not None or sn is not None or carry != 0:
            fv = fn.val if fn is not None else 0
            sv = sn.val if sn is not None else 0
            value = (fv + sv + carry) % 10
            carry = (fv + sv + carry) / 10
            new_node = ListNode(value)
            pointer.next = new_node
            pointer = pointer.next
            fn = fn.next if fn is not None else None
            sn = sn.next if sn is not None else None
        
        return prev.next
        