import java.io.File
import java.lang.Math.abs

fun main(args: Array<String>) {
    val input = File("input_day3.txt").readText()

    val a = intArrayOf(5, 7, 8, 9, -1, 3, 3, 8)

    val t = a.toMutableSet()

    val prefixSum = IntArray(a.size)
    for (i in a.indices) {
        prefixSum[i] = a[i]
        if (i > 0) prefixSum[i] += prefixSum[i - 1]
    }
    val str = "Kotlin!"
    for (i in 0 until str.length - 1) {
        println(str[i])
    }

    val str = "Kotlin!"
    for (c in str) {
        println(c)
    }
}

/*fun maxSubArray(nums: IntArray): Int {
    if (nums.size == 0) {
        return 0;
    }

    var maxSum = nums[0]
    var currentMaxSum: Int

    for (i in 0 until nums.size) {
        currentMaxSum = 0
        for (j in i until nums.size) {
            currentMaxSum += nums[j]
            if (currentMaxSum > maxSum) {
                maxSum = currentMaxSum
            }
        }
    }
    return maxSum
}*/

/*
fun maxSubArray(nums: IntArray): Int {
    var maxCurrent = nums[0]
    var maxGlobal = nums[0]

    for (i in 1 until nums.size) {
        maxCurrent = maxOf(nums[i], maxCurrent + nums[i])
        if (maxCurrent > maxGlobal) {
            maxGlobal = maxCurrent
        }
    }
    return maxGlobal
}*/

fun getTotalTransactionVolume() {
    val PAGE_SIZE = 5

    var currentPage = 1
    val result = getTransactions(currentPage, PAGE_SIZE)
    var currentAmountOfTransactions = result.transactions.size
    var currentTransactions = result.transactions

    while (currentAmountOfTransactions < result.total) {
        currentPage += 1
        val response = getTransactions(currentPage, PAGE_SIZE)
        currentTransactions += response.transactions
        currentAmountOfTransactions += response.transaction.size
    }

    var transactionVolume = currentTransactions.reduce { acc, amount -> acc as Float + abs(amount) }

    println("Amount: $currentAmountOfTransactions and total: $transactionVolume")
}