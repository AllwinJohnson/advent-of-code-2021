package problem
import readInput

fun day03(){

    fun processInputPart1(input: List<String>): Int {
        val freq = StringBuilder()
        val rare = StringBuilder()
        for (i in input[0].indices) {
            val zeros = input.count { it[i] == '0' }
            val ones = input.size - zeros
            freq.append(if (zeros > ones) '0' else '1')
            rare.append(if (zeros <= ones) '0' else '1')
        }
        return freq.toString().toInt(2) * rare.toString().toInt(2)
    }


    fun processInputPart2(input: List<String>): Int {
        fun findOnly(mostFrequent: Boolean): Int {
            val copy = input.toMutableList()
            for (i in input[0].indices) {
                val zeros = copy.count { it[i] == '0' }
                val ones = copy.size - zeros
                val toKeep =
                    if (zeros <= ones) if (mostFrequent) '1' else '0'
                    else if (mostFrequent) '0' else '1'
                copy.removeIf { it[i] != toKeep }
                if (copy.size == 1) return copy.first().toInt(2)
            }
            error("Didn't find the only element")
        }

        return findOnly(true) * findOnly(false)
    }

    /*
    * Part 1
    * */
    println("---------- PART 1 --------------")
    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("Day03_test")
    check(processInputPart1(testInput1) == 198)
    println("Answer part 1 test -->  " + processInputPart1(testInput1))

    val actualInput1 = readInput("Day03_actual")
    println("Answer part 1 actual--> " + processInputPart1(actualInput1)) //150

    /*
    * Part 2
    * */
    println("---------- PART 2 --------------")

    // test if implementation meets criteria from the description, like:
    val testInput2 = readInput("Day03_test")
    check(processInputPart2(testInput2) == 230)
    println("Answer part 1 test -->  " + processInputPart2(testInput2))

    val actualInput2 = readInput("Day03_actual")
    println("Answer part 2 actual--> " + processInputPart2(actualInput2)) // 2138382217
}