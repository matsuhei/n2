package main

import (
	"fmt"
	"math"
	"math/cmplx"
	"math/rand"
	"time"
)

var (
	ToBe   bool       = false
	MaxInt uint64     = 1<<4 - 1
	z      complex128 = cmplx.Sqrt(-5 + 12i)
)

func main() {
	fmt.Println("Welcome to the playground!")

	// time 時間取得
	fmt.Println("The time is", time.Now())

	// rand seedに依存してる
	rand.Seed(10)
	fmt.Println("My favorite number is", rand.Intn(10))

	// math 算術系 絶対値、少数の扱いなど利用さまざま
	fmt.Printf("Now you have %g problems. \n", math.Sqrt(7))
	fmt.Println(math.Pi)

	fmt.Println(mul(11, 11))

	a, b := swap("A", "B")
	fmt.Println(a, b)

	fmt.Println(split(17))

	var i int
	var c, python, java = true, false, "no!"
	k := 3
	k++
	fmt.Println(i, k, c, python, java)

	fmt.Printf("Type: %T Value: %v\n", ToBe, ToBe)
	fmt.Printf("Type: %T Value: %v\n", MaxInt, MaxInt)
	fmt.Printf("Type: %T Value: %v\n", z, z)
}

// func mul(x int, y int) int {
func mul(x, y int) int {
	return x * y
}

func swap(a, b string) (string, string) {
	return b, a
}

// naked return ちょっと可読性低そう
func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return
}
