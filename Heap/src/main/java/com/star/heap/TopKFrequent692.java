package com.star.heap;

import org.junit.Test;

import java.util.*;

/**
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以O(n log k) 时间复杂度和O(n) 空间复杂度解决
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 05-20-2021 22:39
 */
public class TopKFrequent692 {

    /**
     * 对于前 k大或前 k 小这类问题，一个通用的解法：优先队列。
     * 优先队列可以在 O(logn) 的时间内完成插入或删除元素的操作（其中 n 为优先队列的大小），
     * 并可以 O(1) 地查询优先队列顶端元素。
     *
     * @param words
     * @param k
     * @return
     */

    public List<String> topKFrequent(String[] words, int k) {
        // 先用哈希表统计单词出现的频率
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 构建小根堆
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s1).equals(map.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return map.get(s1) - map.get(s2);
            }
        });

        // 依次向堆加入元素
        for (String s : map.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                // 当堆中元素个数大于 k 个的时候，需要弹出堆顶最小的元素
                minHeap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (minHeap.size() > 0) {
            res.add(minHeap.poll());
        }
        // 注意最后需要反转元素的顺序
        Collections.reverse(res);
        return res;
    }


    @Test
    public void topKFrequentTest() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

}
