package april4th;

import java.util.*;
import java.util.stream.Collectors;

public class DesignTwitter {
    static class Twitter {
        static class Post {
            int id;
            int idx;
            public Post(int id, int idx) {
                this.id = id;
                this.idx = idx;
            }
        }
        private int idx = 0;
        private Map<Integer, List<Integer>> followings;
        private Map<Integer, List<Post>> tweets;

        public Twitter() {
            followings = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweets.computeIfAbsent(userId, k -> new ArrayList<>());
            List<Post> posts = tweets.get(userId);
            posts.add(new Post(tweetId, idx++));
            tweets.put(userId, posts);
        }

        public List<Integer> getNewsFeed(int userId) {
            tweets.computeIfAbsent(userId, k -> new ArrayList<>());
            followings.computeIfAbsent(userId , k -> new ArrayList<>());
            List<Post> posts = tweets.get(userId);
            List<Integer> followingUsers = followings.get(userId);
            List<Post> result = new ArrayList<>();
            if (!posts.isEmpty()) {
                result.addAll(posts);
            }
            if (!followingUsers.isEmpty()) {
                followingUsers.forEach(it -> {
                    List<Post> p = tweets.get(it);
                    if (p != null && !p.isEmpty())
                        result.addAll(p);
                });
            }
            if (result.isEmpty()) return new ArrayList<>();
            return result.stream()
                    .sorted(Comparator.comparingInt((Post post) -> post.idx).reversed())
                    .limit(10)
                    .map(it -> it.id)
                    .collect(Collectors.toList());
        }

        public void follow(int followerId, int followeeId) {
            followings.computeIfAbsent(followerId, k -> new ArrayList<>());
            List<Integer> f = followings.get(followerId);
            if (!f.contains(followeeId)) {
                f.add(followeeId);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            followings.computeIfAbsent(followerId, k -> new ArrayList<>());
            List<Integer> f = followings.get(followerId);
            if (f.contains(followeeId)) {
                f.removeIf(it -> it.intValue() == followeeId);
            }
        }

        public void printAll() {
            System.out.println("followings = " + followings);
            System.out.println("tweets = " + tweets);
        }
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        //case1
//        twitter.postTweet(1, 5);
//        List<Integer> newsFeed = twitter.getNewsFeed(1);
//        System.out.println("newsFeed = " + newsFeed);
//
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        List<Integer> newsFeed1 = twitter.getNewsFeed(1);
//        System.out.println("newsFeed1 = " + newsFeed1);
//
//        twitter.unfollow(1, 2);
//        List<Integer> newsFeed2 = twitter.getNewsFeed(1);
//        System.out.println("newsFeed2 = " + newsFeed2);

        //case2
//        twitter.postTweet(1, 5);
//        twitter.postTweet(1, 3);
//        List<Integer> newsFeed = twitter.getNewsFeed(1);
//        System.out.println("newsFeed = " + newsFeed);

        //case3
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        System.out.println("newsFeed = " + newsFeed);
//        twitter.printAll();
    }
}
