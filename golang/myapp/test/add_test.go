package main

import "testing"
import "time"

func add(a, b int) int {
	time.Sleep(time.Duration(a+b) * time.Second)
	return a + b
}

func Test_add(t *testing.T) {
	type args struct {
		a int
		b int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"normal_1", args{1, 2}, 3},
		{"normal_2", args{2, 3}, 5},
		{"normal_3", args{3, 4}, 7},
	}
	//for _, tt := range tests {
	//	t.Run(tt.name, func(t *testing.T) {
	//		if got := add(tt.args.a, tt.args.b); got != tt.want {
	//			t.Errorf("add() = %v, want %v", got, tt.want)
	//		}
	//	})
	//}

	for _, tt := range tests {
		tt := tt
		t.Run(tt.name, func(t *testing.T) {
			t.Parallel()
			if got := add(tt.args.a, tt.args.b); got != tt.want {
				t.Errorf("add() = %v, want %v", got, tt.want)
			}
		})
	}
}