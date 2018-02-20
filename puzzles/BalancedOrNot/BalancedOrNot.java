import java.util.function.BiFunction;
import java.util.function.Function;

public class BalancedOrNot {
    public static void main(String[] args) throws Exception  {
        int[] rets = balancedOrNot(new String[] {"<>>>", "<>>>>"}, new int[] {2,2});
        rets = balancedOrNot(new String[] {"<>", "<>><"}, new int[] {1,0});
    }

    static int[] balancedOrNot(String[] expressions, int[]
            maxReplacements) throws Exception {
        int[] ret = new int[maxReplacements.length];

        if (! (1 <= expressions.length && expressions.length <= (Math.pow(10,5))))
            throw new Exception("length of expressions should be 1 ≤ n ≤ 10 ^ 5");
        if (! (0 <= maxReplacements.length && maxReplacements.length <= (Math.pow(10,5))))
            throw new Exception("length of maxReplacements should be 0 ≤ n ≤ 10 ^ 5");


        Function<String, String> remaining = (src) -> src.replace("<>","");
        //Function<String, String> fixit = (src) -> src.equals("<") ? src.replace("<","<>") : src.replace(">","<>");
        BiFunction<String, Integer, Boolean> replaced = (src, count) -> src.length() <= count;

        for (int i = 0; i < expressions.length; i++) {
            String remained = remaining.apply(expressions[i]);
            ret[i] = replaced.apply(remained, maxReplacements[i]) ? 1 : 0;
            System.out.println(String.format("expressions  %s, max %d, result %d", expressions[i], maxReplacements[i], ret[i]));
        }

        return ret;
    }


}

