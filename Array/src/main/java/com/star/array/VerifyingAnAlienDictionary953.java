package com.star.array;

import org.junit.Test;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在words[i]和order中的所有字符都是英文小写字母
 *
 * @Author: zzStar
 * @Date: 03-03-2021 18:42
 */
public class VerifyingAnAlienDictionary953 {

    /**
     * 只有每对相邻单词都是有序的，那么整个 words 才是有序的。因为有序性是可以传递的，例如，a <= b 和 b <= c 可以推出 a <= c。
     * 检查相邻单词 a 和 b 是否满足 a <= b。
     * 为了检查相邻单词 a，b 是否满足 a <= b，只需要检查它们第一个不同的字母就可以了。例如，对于"applying" 和 "apples"，第一个不同的字母是 y 和 e。之后只需要比较这两个字母在 order 中的下标就可以了。
     * 还需要考虑两个单词长度不等的情况。例如，当比较 "app" 和 "apply" 的时候，前三个字母都是相等的，但 "app" 比 "apply" 更短，所以满足 a <= b。
     */
    public boolean isAlienSorted(String[] words, String order) {

        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean continueCompare = true;

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()) && continueCompare;
                 k++) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    } else //已经比较出高下了
                    {
                        continueCompare = false;
                    }
                }
            }
            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (continueCompare && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void isAlienSortedTest() {
        String[] word = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(word, order));
    }
}
