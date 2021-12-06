import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun dayThreePartOne(input: File) {
    val binariesMap = mutableMapOf<Int, MutableMap<Char, Int>>()
    var gammaRate = ""
    var epsilonRate = ""

    input.forEachLine { binary ->
        binary.forEachIndexed { index, digit ->
            if (binariesMap[index] == null) {
                binariesMap[index] = mutableMapOf(digit to 1)
            } else {
                binariesMap[index]!![digit] = binariesMap[index]?.get(digit)?.plus(1) ?: 1
            }
        }
    }

    binariesMap.forEach { key, value ->
        val max = binariesMap[key]?.maxByOrNull { it.value }?.key
        val min = binariesMap[key]?.minByOrNull { it.value }?.key
        gammaRate += max
        epsilonRate += min
    }

    gammaRate.toInt(2) * epsilonRate.toInt(2)
}

fun dayThreePartTwo(): Int {
    val input = Files.readAllLines(Paths.get("input_day3.txt"))
    val oxgenRating = findOxygen(input, 0)[0]
    val co2Rating = findCo2(input, 0)[0]

    return oxgenRating.toInt(2) * co2Rating.toInt(2)
}

private fun findOxygen(input: MutableList<String>, index: Int): MutableList<String> {
    val startWithZeros: MutableList<String> = mutableListOf()
    val startWithOnes: MutableList<String> = mutableListOf()

    input.forEach {
        if (it[index] == '0') {
            startWithZeros.add(it)
        } else {
            startWithOnes.add(it)
        }
    }

    val result = if (startWithOnes.size >= startWithZeros.size) startWithOnes else startWithZeros
    return if (result.size == 1) result else findOxygen(result, index + 1)
}

private fun findCo2(input: MutableList<String>, index: Int): MutableList<String> {
    val startWithZeros: MutableList<String> = mutableListOf()
    val startWithOnes: MutableList<String> = mutableListOf()

    input.forEach {
        if (it[index] == '0') {
            startWithZeros.add(it)
        } else {
            startWithOnes.add(it)
        }
    }

    val result = if (startWithZeros.size <= startWithOnes.size) startWithZeros else startWithOnes
    return if (result.size == 1) result else findCo2(result, index + 1)
}
