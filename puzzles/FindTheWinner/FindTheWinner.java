public class FindTheWinner {
    public static void main(String[] args) throws Exception {
        String ret = winner(new int[] {1,2,3}, new int[] {2,1,3}, "Even");
         ret = winner(new int[] {1,2,3}, new int[] {2,1,3}, "Odd");

    }

    static String winner(int[] andrea, int[] maria, String s) throws Exception {

        int andreaPoints = 0;
        int mariaPoints = 0;
        if (! (2 <= andrea.length && andrea.length <= (Math.pow(10,5))))
            throw new Exception("andrea number of elements should be 2 ≤ n ≤ 10 ^ 5");
        if (! (2 <= maria.length && maria.length <= (Math.pow(10,5))))
            throw new Exception("maria number of elements should be 2 ≤ n ≤ 10 ^ 5");
        if (andrea.length != maria.length)
            throw new Exception("number of elements are not equal between andrea and maria");


        for (int i = 0; i < andrea.length; i++) {
            if (! (1 <= andrea[i] && andrea[i] <= (Math.pow(10,3))))
                throw new Exception("andrea data value should be 1 ≤ a , m ≤ 10 ^ 3");
            if (! (1 <= maria[i] && maria[i] <= (Math.pow(10,3))))
                throw new Exception("maria data value should be 1 ≤ a , m ≤ 10 ^ 3");
            boolean doit = false;
            if ("Even".equalsIgnoreCase(s))
                doit = (i+1) % 2 == 0;
            else if ("Odd".equalsIgnoreCase(s))
                doit = (i+1) % 2 != 0;

            if (doit) {
                andreaPoints += andrea[i] - maria[i];
                mariaPoints += maria[i] - andrea[i];
            }
            System.out.println(String.format(" andrea %d points %d total %d maria %d points %d total %d   %s",
                    andrea[i],
                    andrea[i] - maria[i],
                    andreaPoints,
                    maria[i],
                    maria[i] - andrea[i],
                    mariaPoints,
                    ! doit ? "skipped" : ""
            ));

        }
        String ret;
        if ( andreaPoints > mariaPoints)
            ret = "Maria";
        else if (mariaPoints > andreaPoints)
            ret = "Andrea";
        else
            ret = "Tie";

        System.out.println(ret);

        return ret;

    }
}
