// class Solution {
//     public int climbStairs(int n) {
//         // Base cases
//         if (n == 1) return 1;
//         if (n == 2) return 2;

//         // Recursive case
//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }

// It is solve(run) but on submit, it give us the Time limit exceed

// ----------------------------

// using the Iterative DP

class Solution {
    public int climbStairs(int n) {

        if (n <= 2) return n;

        int oneStepBefore = 2;  // ways to reach step 2
        int twoStepsBefore = 1; // ways to reach step 1

        int ways = 0;

        for (int i = 3; i <= n; i++) {
            ways = oneStepBefore + twoStepsBefore;

            twoStepsBefore = oneStepBefore;
            oneStepBefore = ways;
        }

        return ways;
    }
}