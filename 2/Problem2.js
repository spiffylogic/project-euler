#!/usr/local/bin/node

// Find the sum of even terms of Fibonacci sequence not exceeding 4 million
// The sequence is 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
MAX = 4000000;

// 1. Naive solution
var a = 0;
var b = 1;
var sum = 0;
while (b <= MAX) {
	if (b % 2 == 0) {
		sum += b;
	}
	temp = a+b;
	a = b;
	b = temp;
}


// 2. Improved solution: notice that every third term is even and the rest are odd (easily proven by induction
// using the fact that odd + odd = even and even + odd = odd).
a = 1;
b = 1;
c = a+b;
sum = 0;
while (c <= MAX) {
	sum += c;
	a = b+c;
	b = c+a;
	c = a+b;
}
// We are doing 1/3 as many iterations although slightly more work each time.

// 3. Best solution: observe a pattern in the subsequence of even terms: 0, 2, 8, 34, 144, ...
// F(n) = 4*F(n-1) + f(n-2)
a = 0;
b = 2;
sum = 0;
while (b <= MAX) {
	sum += b;
	temp = 4*b+a;
	a = b;
	b = temp;
}

console.log(sum);


