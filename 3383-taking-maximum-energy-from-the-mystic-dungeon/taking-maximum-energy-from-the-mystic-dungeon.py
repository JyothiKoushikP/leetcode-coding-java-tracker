class Solution(object):
    def maximumEnergy(self, energy, k):
        """
        :type energy: List[int]
        :type k: int
        :rtype: int
        """
        for i in range(k,len(energy)):
            energy[i] = max(energy[i],energy[i] + energy[i-k])
        
        startPos = len(energy) - k
        maxEnergy = -(2**31)
        for i in range(startPos,len(energy)):
            maxEnergy = max(maxEnergy,energy[i])

        return maxEnergy
        