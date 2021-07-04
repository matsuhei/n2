package main

import (
	"fmt"
)

func main() {
	var s string
	fmt.Scanf("%s", &s)
	count := 0
	for i := 0; i < len(s); i++ {
		if s[i] == '1' {
			count++
		}
	}
	fmt.Println(count)
}
