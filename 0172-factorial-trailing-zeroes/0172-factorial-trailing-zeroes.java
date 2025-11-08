// Trailing zeroes means the no of the zeroes exists at the end of a number
// the no of the trailing zeroes are the no of the 5's present in the final factorial number.

// class Solution {
//     public int trailingZeroes(int n) {
//         int f = fac(n);
//         int count =0;
//         while(f %10 ==0){
//             count++;
//             f = f/10;
//         }

//         return count;

//     }

//     public int fac(int a){
//         if(a ==0 || a==1){
//             return 1;
//         }

//         return a * fac(a -1);
//     }
// }

// we do not use the above approach due to if we use that things then we write the factorial which is very big number  like 100 factorial

// class Solution {
//     public int trailingZeroes(int n) {

//         int count =0;

//         while(n >0){
//             n = n/5;
//             count = count +n;
//         }
//         return count;
//     }
// }


// using recurrsion

// jo bhi number 2 ya 2 se bada hoga ys me to hoga hi 2 in the factorail, so we trailing zeroes is made by the (2,5), as 2 is always be there after 2 and on 2 so if we find the no of the 5 thene there be the pair of(2,5) we get, that give us the trailing zeroes.

class Solution {
    public int trailingZeroes(int n) {
        // base case
        if (n == 0) return 0;

        // n/5 is captured just one 5 then we add to call its own function and like if we have n =100,

// trailingZeroes(100)
// = 100/5 + trailingZeroes(20)
// = 20 + (20/5 + trailingZeroes(4))
// = 20 + (4 + (4/5 + trailingZeroes(0)))
// = 20 + (4 + (0 + 0))
// = 24
        return (n / 5) + trailingZeroes(n / 5);
    }
}