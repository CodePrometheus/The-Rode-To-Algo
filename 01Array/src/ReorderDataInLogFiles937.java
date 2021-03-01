import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * <p>
 * 有两种不同类型的日志：
 * <p>
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 * 示例 2：
 * <p>
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 中，字与字之间都用 单个 空格分隔
 * 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字
 *
 * @Author: zzStar
 * @Date: 03-01-2021 19:03
 */
public class ReorderDataInLogFiles937 {

    /**
     * 字母日志先于数字日志；
     * 字母日志按字母数字顺序排列，先按内容排序，再按标识符排序；
     * 数字日志的顺序保持不变。
     */
    public String[] reorderLogFiles(String[] logs) {
        // 泛型，第二个参数重新定义排序规则
        Arrays.sort(logs, (log1, log2) -> {
            // 将log1 按分隔符“ ” ，分成2份，即把标识符分开来
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            // 判断除标识符外的第一个字符是数字true，字母false
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            // 如果两个日志都是字母日志
            if (!isDigit1 && !isDigit2) {
                // 先比较内容字母split1>split2则返回1，等于返0，小于返-1
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                // 若内容字母相同则比较标识符
                return split1[0].compareTo(split2[0]);
            }
            // 如果split1是数字字符，且split2是数字字符返回0，
            // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
            // 如果split1是字母字符，返回-1，
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    @Test
    public void reorderLogFilesTest() {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }
}
