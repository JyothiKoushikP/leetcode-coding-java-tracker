class Solution(object):
    def findSmallestRegion(self, regions, region1, region2):
        hierarchy_map = {}
        for region in regions:
            parent = region[0]
            child = region[1:]
            if parent not in hierarchy_map:
                hierarchy_map[parent] = None
            for child_state in child:
                hierarchy_map[child_state] = parent

        if hierarchy_map[region2] == region1 or hierarchy_map[region1] is None:
            return region1
        if hierarchy_map[region1] == region2 or hierarchy_map[region2] is None:
            return region2

        upper_states_r1 = set()
        upper_states_r2 = set()

        cr = region1
        while cr is not None:
            upper_states_r1.add(cr)
            cr = hierarchy_map[cr]
        
        while region2 is not None:
            if region2 in upper_states_r1:
                return region2
            region2 = hierarchy_map[region2]
        
        return None
        
        
        