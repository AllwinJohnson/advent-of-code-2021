fun day01() {

    fun processInputPart1(input: List<Int>): Int {
        println("Total lines --> " + input.size)
        return input.windowed(2).count{
                (a,b) -> a < b
        }
    }

    fun processInputPart2(input: List<Int>): Int {
        println("Total lines --> " + input.size)
        return input.windowed(3).windowed(2).count {
            (a,b) -> a.sum() < b.sum()
        }
    }

    /*
    * Part 1*/
    println("---------- PART 1 --------------")

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInputAsInt("day01_test")
    check(processInputPart1(testInput1) == 7)
    println("Answer part 1 test -->  " + processInputPart1(testInput1))

    val actualInput1 = readInputAsInt("day01_actual")
    println("Answer part 1 actual--> " + processInputPart1(actualInput1)) // 1665


    /*
    * Part 2*/
    println("---------- PART 2 --------------")

    // test if implementation meets criteria from the description, like:
    val testInput2 = readInputAsInt("day01_test")
    check(processInputPart2(testInput2) == 5)
    println("Answer part 1 test -->  " + processInputPart2(testInput2))

    val actualInput2 = readInputAsInt("day01_actual")
    println("Answer part 2 actual--> " + processInputPart2(actualInput2)) // 1702
}
