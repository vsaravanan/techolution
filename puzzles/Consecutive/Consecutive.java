public class Consecutive {

    public static void main(String[] args) throws Exception {

        gcd(8, 20);
        System.out.println(String.format("Final result is %d ", consecutive(15)));
/*
        for (int i = 0; i < 100; i++) {
            System.out.println(i+1 + "  " + consecutive(i+1));
        }
*/
    }

    static int consecutive(long num) throws Exception{
        if (! (1 <= num && num <= (Math.pow(10,12))))
            throw new Exception("input should be 1 ≤ num ≤ 10 ^ 12");

        int count = 0;
        String line = new String(new char[30]).replace("\0","=");
        for (int i = 1; i < num; i++) {
            count += checkSum(num, i);
            System.out.println(String.format("%s> count %d ", line, count));
        }
        System.out.println(String.format("Result is %d",count));
        return count;
    }

    static int checkSum(long num, int i) {
        int count = 0;
        int sum = 0;
        StringBuilder str = new StringBuilder();
        for (int j = i; j < num && sum+j <= num; j++) {
            sum += j;
            str.append(j + " + ");
            if (sum == num)
                count++;
            System.out.println(String.format(" %s = sum %d ", str.substring(0, str.length() - 3), sum));
        }
        return count;
    }

    public static long gcd(long a, long b){
        if(a == 0) {
            System.out.println(" " + b);
            return b;
        }
        if(b == 0) {
            System.out.println(" " + a);
            return a;
        }
        if(a > b) {
            System.out.println(String.format("1 a %d  b %d ", a, b));

            return gcd(b, a % b);
        }

        System.out.println(String.format("2 a %d  b %d ", a, b));
        return gcd(a, b % a);

    }

}
