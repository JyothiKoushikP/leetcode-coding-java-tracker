class Solution(object):
    def findSmallestRegion(self, regions, region1, region2):
        hierarchy_map = {}
        for region in regions:
            parent = region[0]
            children = region[1:]
            if parent not in hierarchy_map:
                hierarchy_map[parent] = None
            for child in children:
                hierarchy_map[child] = parent

        if region1 not in hierarchy_map or region2 not in hierarchy_map:
            return None

        if hierarchy_map[region2] == region1 or hierarchy_map[region1] is None:
            return region1
        if hierarchy_map[region1] == region2 or hierarchy_map[region2] is None:
            return region2

        upper_states_r1 = set()
        current_region1 = region1
        while current_region1 is not None:
            upper_states_r1.add(current_region1)
            current_region1 = hierarchy_map[current_region1]

        current_region2 = region2
        while current_region2 is not None:
            if current_region2 in upper_states_r1:
                return current_region2
            current_region2 = hierarchy_map[current_region2]

        return None  

        
        
        