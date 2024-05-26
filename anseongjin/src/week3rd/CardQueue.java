package week3rd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CardQueue {
    static class Solution {

        private Queue<Integer> q;

        public Solution(int n) {
            q = new LinkedList<>();
            IntStream.range(1, n + 1).forEach(i -> {
                q.add(i);
            });
        }
        public int getLastCard() {
            int i = 0;
            while (q.size() != 1) {
                Integer item = q.poll();
                if (i % 2 == 1) {
                    q.add(item);
                }
                i++;
            }
            return q.poll();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Solution(n);
        int lastCard = solution.getLastCard();
        System.out.println(lastCard);

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        Queue<Integer> q = new LinkedList<>();
//        IntStream.range(1, n + 1).forEach(i -> q.add(i));
//
//        int i = 0;
//        while (q.size() != 1) {
//            Integer item = q.poll();
//            if (i % 2 == 1) {
//                q.add(item);
//            }
//            i++;
//        }
//        System.out.println(q.poll());
    }
}
