class Solution {
    public int countNicePairs(int[] nums) {
        int mod=(int)Math.pow(10,9)+7;

        //Map to store the number of elements having the same difference.
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            Integer diff=diff(i);
            if(map.containsKey(diff))
            {
                int n=map.get(diff);
                map.put(diff,n+1);
            }
            else
            {
                map.put(diff,1);
            }
        }
        long ans=0;

        //Number of pairs = sum of natural numbers till the number of elements having the same difference
        for(int i:map.keySet())
        {
            long n=map.get(i);
            ans+=(n*(n-1))/2;
            ans%=mod;
        }
        return (int)ans;
    }

    //To calculate the difference between a number and it's reverse
    int diff(int n)
    {
        int a=0;
        int temp=n;
        while(temp>0)
        {
            a*=10;
            a+=temp%10;
            temp/=10;
        }
        return n-a;
    }
}