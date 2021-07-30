package main

import (
	"fmt"
)

func main() {
	var a, b, c, x int
	fmt.Scanf("%d", &a)
	fmt.Scanf("%d", &b)
	fmt.Scanf("%d", &c)
	fmt.Scanf("%d", &x)

	var result int

	if c > 0 {
		for i := 1; i <= c; i++ {
			c2 := i * 50

			if x == c2 {
				result++
			}

			if b > 0 {
				for j := 1; j <= b; j++ {
					b2 := j * 100
					if x == b2+c2 {
						result++
					}

					if a > 0 {
						for k := 1; k <= a; k++ {
							a2 := k * 500
							if x == a2+b2+c2 {
								result++
							}
						}
					}
				}
			}

			if a > 0 {
				for k := 1; k <= a; k++ {
					a2 := k * 500
					if x == a2+c2 {
						result++
					}
				}
			}

		}
	}

	if b > 0 {
		for j := 1; j <= b; j++ {
			b2 := j * 100

			if x == b2 {
				result++
			}

			if a > 0 {
				for k := 1; k <= a; k++ {
					a2 := k * 500
					if x == a2+b2 {
						result++
					}
				}
			}
		}
	}

	if a > 0 {
		for j := 1; j <= a; j++ {
			a2 := j * 500
			if x == a2 {
				result++
			}
		}
	}
	fmt.Println(result)
}
