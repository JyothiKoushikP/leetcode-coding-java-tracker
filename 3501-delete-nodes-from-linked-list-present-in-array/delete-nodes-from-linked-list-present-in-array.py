# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def modifiedList(self, nums, head):
        nums_set = set(nums)
        new_head = ListNode(-1)
        pointer = new_head
        while head:
            if head.val not in nums_set:
                pointer.next = ListNode(head.val)
                pointer = pointer.next
            head = head.next
        
        return new_head.next