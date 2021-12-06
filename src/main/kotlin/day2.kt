import java.io.File

fun dayTwoPartOne(input: File): Int {
    var horizontalPosition = 0
    var depthPosition = 0

    input.forEachLine { command ->
        val commandSplit = command.split(" ")
        val command = commandSplit[0]
        val units = commandSplit[1].toInt()

        when (command) {
            "forward" -> horizontalPosition += units
            "up" -> depthPosition -= units
            "down" -> depthPosition += units
            else -> println("incorrect input")
        }
    }

    return horizontalPosition * depthPosition
}

fun dayTwoPartTwo(input: File) {
    var horizontalPosition = 0
    var depthPosition = 0
    var aim = 0

    input.forEachLine { command ->
        val commandSplit = command.split(" ")
        val command = commandSplit[0]
        val units = commandSplit[1].toInt()

        when (command) {
            "down" -> aim += units
            "up" -> aim -= units
            "forward" -> {
                horizontalPosition += units
                depthPosition += (aim * units)
            }
            else -> println("incorrect input")
        }
    }
    horizontalPosition * depthPosition
}