# Note: must use ea Java option to enable assertions as follows.
# kotlinc -J-ea -script Problem1.kts

val MAX = 1000
val ANSWER = 233168

// Naive solution
var sum = 0
for (i in 0..MAX-1) {
	if (i % 3 == 0 || i % 5 == 0) {
		sum += i
	}
}
assert(sum == ANSWER)

// Efficient solution
fun mySum(n: Int): Int {
	val p = (MAX-1) / n
	return n * p * (p+1) / 2
}
sum = mySum(3) + mySum(5) - mySum(15)
assert(sum == ANSWER)

println(sum)
