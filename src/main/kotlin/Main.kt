import kotlin.system.measureTimeMillis

fun main() {
    println("Advent of code: Day ....")
    val timeInMillis = measureTimeMillis {
        val data = DataSource.getDataAsList(9)
//        Day1.puzzleA()
//        Day2.puzzleB()
//        Day3.puzzleB()
//        Day4.puzzleB()
//        Day5.puzzleA()
//        Day6.puzzleA()
//        Day7.puzzleA()
//        Day8_2.puzzleA(data)
        println(Day9.puzzleA(data))
    }
    println("(The execution took $timeInMillis ms)")
}


