import org.junit.Test;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * @Author: zzStar
 * @Date: 02-18-2021 22:39
 */
public class FirstUniqueCharacterInAString387 {

    /**
     * 遇到计数，不要犹豫，hash或者桶， 全是字母用桶更快
     */
    public int firstUniqChar(String s) {
        int[] buckets = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            buckets[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (buckets[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void firstUniqCharTest() {
        String s = "aabbccd";
        System.out.println(firstUniqChar(s));
    }
}
