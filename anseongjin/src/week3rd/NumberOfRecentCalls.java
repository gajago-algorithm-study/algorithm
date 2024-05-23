package week3rd;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    static class RecentCounter {

        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            Integer peek = q.peek();
            while (t - peek > 3000) {
                q.poll();
                peek = q.peek();
            }
            return q.size();
        }

        @Override
        public String toString() {
            return "RecentCounter{" +
                    "q=" + q +
                    '}';
        }
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);
        recentCounter.ping(100);
        recentCounter.ping(3001);
        recentCounter.ping(3002);
        System.out.println("recentCounter = " + recentCounter);
    }
}
