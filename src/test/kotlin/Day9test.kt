import org.junit.Test

class Day9Test {
    private val aData = """R 4,U 4,L 3,D 1,R 4,D 1,L 5,R 2""".split(",")
    private val bData = """R 5,U 8,L 8,D 3,R 17,D 10,L 25,U 20""".split(",")
    @Test
    fun puzzleACorrect() {
        val actual = Day9.puzzleA(aData)
        println(actual)
        assert(13 == actual)
    }

    @Test
    fun puzzleBCorrect() {
        val actual2 = Day9.puzzleB(bData)
        println(actual2)
        assert(36 == actual2)
    }

}