import java.util.Arrays;

public class BuyingShowTicket {
    public static void main(String[] args) throws Exception {
        int ret = waitingTime(new int[] {2, 6, 3, 4, 5}, 2);
        ret = waitingTime(new int[] {1, 1, 1, 1}, 0);
        ret = waitingTime(new int[] {5, 5, 2, 3}, 3);
    }

    static int waitingTime(int[] input, int p) throws Exception {
        if (! (0 <= p && p < input.length))
            throw new Exception("jesse's position should be within the queue");

        for (int i = 0; i < input.length; i++) {
            if (! (1 <= input[i] && input[i] <= (Math.pow(10,9))))
                throw new Exception("tickets value should be 1 ≤ tickets[i] ≤ 10 ^ 9");
        }

        int totalTickets;
        totalTickets = Arrays.stream(input).reduce(0, (x,y) -> x+y);
        System.out.println(String.format("totalTickets : %d" ,totalTickets));


        int ticketsIssued = 0;
        int index = 0;

        while (ticketsIssued < totalTickets && input[p] > 0) {

            boolean boolTicketIssued = false;
            if (input[index] > 0) {
                input[index]--;
                ticketsIssued++;
                boolTicketIssued = true;
            }
            System.out.println(String.format("%s ticketsIssued : %s", Arrays.toString(input),
                    boolTicketIssued ? Integer.toString(ticketsIssued) : ""));


            if (index < input.length - 1)
                index++;
            else
                index = 0;
        }

        System.out.println(String.format("Final answer : Jesse's waiting time is %d seconds", ticketsIssued));

        return ticketsIssued;

    }




}
