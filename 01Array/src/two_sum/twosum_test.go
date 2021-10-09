package two_sum

import (
	"fmt"
	"testing"
)

type question struct {
	para
	ans
}

type para struct {
	nums   []int
	target int
}

type ans struct {
	one []int
}

func TestTwoSum(t *testing.T) {
	qs := []question{
		{
			para{[]int{3, 2, 4}, 6},
			ans{[]int{1, 2}},
		},
	}
	for _, q := range qs {
		_, p := q.ans, q.para
		fmt.Printf("【input】:%v       【output】:%v\n", p, TwoSum(p.nums, p.target))
	}
}

func TwoSum(nums []int, target int) []int {
	ht := make(map[int]int)
	for i, x := range nums {
		if p, ok := ht[target-x]; ok {
			return []int{p, i}
		}
		ht[x] = i
	}
	return nil
}
