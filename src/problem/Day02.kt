package problem
import readInput
import readInputAsInt

fun day02() {

    fun processInputPart1(input: List<String>): Int {
        var depth = 0;
        var horizontalPosition = 0;
        val instructions = input.map { it.split(' ') }
        for ((direction, amountString) in instructions) {
            val amount = amountString.toInt()
            when (direction) {
                "forward" -> horizontalPosition += amount
                "up" -> depth -= amount
                "down" -> depth += amount
            }
        }
        return horizontalPosition * depth
    }


    fun processInputPart2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        val instructions = input.map { it.split(' ') }
        for ((direction, amountString) in instructions) {
            val amount = amountString.toInt()
            when (direction) {
                "forward" -> {
                    horizontalPosition += amount
                    depth += (aim * amount)
                }
                "up" -> aim -= amount
                "down" -> aim += amount
            }
        }
        return horizontalPosition * depth
    }

    /*
    * Part 1
    * */
    println("---------- PART 1 --------------")
    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("Day02_test")
    check(processInputPart1(testInput1) == 150)
    println("Answer part 1 test -->  " + processInputPart1(testInput1))

    val actualInput1 = readInput("Day02_actual")
    println("Answer part 1 actual--> " + processInputPart1(actualInput1)) //150

    /*
    * Part 2
    * */
    println("---------- PART 2 --------------")

    // test if implementation meets criteria from the description, like:
    val testInput2 = readInput("Day02_test")
    check(processInputPart2(testInput2) == 900)
    println("Answer part 1 test -->  " + processInputPart2(testInput2))

    val actualInput2 = readInput("Day02_actual")
    println("Answer part 2 actual--> " + processInputPart2(actualInput2)) // 2138382217

}
