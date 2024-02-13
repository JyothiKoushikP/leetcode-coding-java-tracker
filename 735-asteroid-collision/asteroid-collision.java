class Solution {
public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collision = new Stack<>();
        for(int i : asteroids) {
            if(collision.isEmpty()) {
                collision.push(i);
            } else {
                boolean didExplode = false;

                while(!collision.isEmpty() && !didExplode && (isPositive(collision.peek()) && isNegative(i)))  {
                    int top = collision.peek();
                    if(didExplode) break;
                    if(Math.abs(top) > Math.abs(i)) {
                        didExplode = true;
                        break;
                    } else if(Math.abs(top) < Math.abs(i)) {
                        collision.pop();
                    } else {
                        collision.pop();
                        didExplode = true;
                    }
                }

                if(!didExplode) {
                    collision.push(i);
                }
            }
        }
        int[] res = new int[collision.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = collision.pop();
        }
        return res;
    }

    public static boolean isNegative(int asteroid) {
        return asteroid < 0;
    }

    public static boolean isPositive(int asteroid) {
        return asteroid > 0;
    }
}