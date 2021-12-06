import java.io.File

fun dayOnePartOne(input: File): Int {
    var previousDepth = 0
    var nrOfIncrease = 0

    input.forEachLine {
        val currentDepth = it.toInt()
        if (previousDepth != 0 && currentDepth > previousDepth) {
            nrOfIncrease += 1
        }
        previousDepth = currentDepth
    }
    return nrOfIncrease
}

fun dayOnePartTwo(input: File): Int {
    var nrOfIncrease = 0
    var previousSum = 0
    var pastElement = 0
    var nextToPastElement = 0

    input.forEachLine { current ->
        val currentElement = current.toInt()
        if (pastElement != 0 && nextToPastElement != 0) {
            val currentSum = currentElement + pastElement + nextToPastElement
            if (currentSum > previousSum && previousSum != 0) {
                nrOfIncrease += 1
            }
            previousSum = currentSum
        }
        nextToPastElement = pastElement
        pastElement = currentElement
    }

    return nrOfIncrease
}