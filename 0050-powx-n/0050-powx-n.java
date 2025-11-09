// the pow function is use for raise the power.
// it is return in the double data types.

// class Solution {
//     public double myPow(double x, int n) {
//         return Math.pow(x, n);
//     }
// }

// without math function

// class Solution {
//     // x is the base and n is power or exponents: x^n
//     public double myPow(double x, int n) {

//         long N = n; // handle overflow for -2147483648
//         // if the power is the -ve
//         if (N <0){
//             x = 1/x;
//             N = -1* N; // now n is positive
//         }

//         double ans =1;
//         while (N > 0) {
//             if (N % 2 == 1) {
//                 ans = ans* x;   // multiply once when exponent is odd
//             }   
//             x = x* x;          // square the base
//             N = N/ 2;          // halve the exponent
//         }
//         return ans;
//     }
// }

// using the Recursive 

// https://drive.google.com/file/d/1NGmaJ7mMu16VOCGuuBX7vRkHN3WUrWZP/view?pli=1

// Instead of: 2 * 2 * 2 * 2 * ... (10 times) --> that is the slow
// We do:
// 2¹⁰ = (2⁵)²
// 2⁵ = (2²)² * 2
// 2² = (2¹)²
// 2¹ = 2

class Solution {
    public double myPow(double x, int n) {
        // Convert n to long to avoid overflow when n = -2^31
        long N = n;
        if (N < 0) {
            return 1 / power(x, -N);
        }
        return power(x, N);
    }

    public double power(double x, long n) {
        // Base case
        if (n == 0) return 1;

        // Recursive step: compute x^(n/2)
        double half = power(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd
        else {
            return half * half * x;
        }
    }
}