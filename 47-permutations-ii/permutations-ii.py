class Solution(object):
    def permuteUnique(self, nums):
        result, p_list = [], [nums[0]]
        self.all_permutations(nums,1,result,p_list)
        return result
    
    def all_permutations(self, nums, pointer, result, p_list):
        if pointer == len(nums):
            if p_list not in result:
                result.append(p_list)
            return
        
        ele = nums[pointer]
        for i in range(len(p_list) + 1):
            new_list = p_list[:i] + [ele] + p_list[i:]
            self.all_permutations(nums,pointer + 1,result,new_list)
        
        return 
        