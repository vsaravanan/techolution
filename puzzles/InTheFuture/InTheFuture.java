

public class InTheFuture {
    public static void main(String[] args) throws Exception {
        int ret = minNum(3, 5, 1);
        ret = minNum(4, 5, 1);
        ret = minNum(5, 5, 1);
        ret = minNum(3, 4, 10);
//        ret = minNum(3, 5, -1);
//        ret = minNum(0, 5, 1);
//        ret = minNum(3, 0, 1);
    }

    static int minNum(int a, int k, int p) throws Exception {
        if (! (1 <= a &&  a <= 100))
            throw new Exception("A should be 1 ≤ A ≤ 100");
        if (! (1 <= k &&  k <= 100))
            throw new Exception("K should be 1 ≤ K ≤ 100");
        if (! (0 <= p &&  p <= 100))
            throw new Exception("P should be 0 ≤ P ≤ 100");

        int daysPassed = 1;
        int sumOfA = a;
        int sumOfK = k;
        System.out.println(String.format(
            "a %d, k %d, p %d", a, k, p
            ));
        if (a >= k)
            daysPassed = -1;
        else {
            while ((sumOfA + p) >= sumOfK) {
                daysPassed++;
                sumOfA += a;
                sumOfK += k;
                System.out.println(String.format(
                        "daysPassed %d, sumOfA %d, sumOfK %d", daysPassed, sumOfA, sumOfK
                ));
                if ((sumOfA + p) < sumOfK )
                    break;
                if ( daysPassed > 10)
                    break;
            }

        }

        System.out.println(String.format(
                "Return value : daysPassed %d", daysPassed
        ));
        return daysPassed;
    }





}
