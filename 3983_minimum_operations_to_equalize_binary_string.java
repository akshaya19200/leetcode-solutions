import java.util.*;

class Solution {

    public int minOperations(String s, int k) {
        int n = s.length();

        // count zeros
        int z0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') z0++;
        }

        // sets of unvisited states by parity
        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd  = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 0) even.add(i);
            else odd.add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(z0);

        // mark start visited
        if ((z0 & 1) == 0) even.remove(z0);
        else odd.remove(z0);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int t = 0; t < size; t++) {
                int z = q.poll();

                // 🎯 Goal: all '1'
                if (z == 0) return steps;

                // i range
                int minI = Math.max(0, k - (n - z));
                int maxI = Math.min(k, z);

                // z' range
                int minZ = z + k - 2 * maxI;
                int maxZ = z + k - 2 * minI;

                int parity = (z + k) & 1;
                TreeSet<Integer> set = (parity == 0) ? even : odd;

                // jump only to valid unvisited z'
                Integer cur = set.ceiling(minZ);
                while (cur != null && cur <= maxZ) {
                    int next = cur;
                    q.add(next);
                    set.remove(next);   // mark visited
                    cur = set.ceiling(minZ);
                }
            }
            steps++;
        }

        return -1;
    }
}