class Solution {
    public int fun(String s) {
        int MOD = 1000000007;
        long a = 0, ab = 0, abc = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                a = (2 * a + 1) % MOD;
            } else if (ch == 'b') {
                ab = (2 * ab + a) % MOD;
            } else if (ch == 'c') {
                abc = (2 * abc + ab) % MOD;
            }
        }
        return (int) abc;
    }
}
