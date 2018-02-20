

public class LargestSubsetSum {
    public static void main(String[] args) throws Exception {
        long[] ret = maxSubsetSum(new int[] {2, 4, 5, 7, 8, 9, 12});

    }

    static long[] maxSubsetSum(int[] k) throws Exception {


        if (! (1 <= k.length && k.length <= (Math.pow(10,3))))
            throw new Exception("number of element should be 1 ≤ k ≤ 10 ^ 3");

        long[] ret = new long[k.length];

        for (int i = 0; i < k.length; i++) {
            if (! (1 <= k[i] && k[i] <= (Math.pow(10,9))))
                throw new Exception("data value should be 1 ≤ k[i] ≤ 10 ^ 9");
            ret[i] = sum(k[i]);
        }
        return ret;
    }


    public static long sum(long x){
        StringBuilder sb = new StringBuilder();
        sb.append(x + " :   ");
        long sum = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                sum += i;
                sb.append( i + " + ");
            }
        }
        sb.setLength(sb.length() - 2);
        sb.append(" => " + sum);

        System.out.println(sb);

        return sum;

    }


}
