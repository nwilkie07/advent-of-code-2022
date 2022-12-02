class Day2 {

    companion object {
        private val day = 2
        val data = DataSource.getDataAsList(day)

        // A/B/C means Rock/Paper/Scissors
        val outcomes = mapOf(
            // 0/3/6 for loss/draw/win
            // + 1/2/3 for picking X/Y/Z
            "A X" to 3 + 1,
            "A Y" to 6 + 2,
            "A Z" to 0 + 3,
            "B X" to 0 + 1,
            "B Y" to 3 + 2,
            "B Z" to 6 + 3,
            "C X" to 6 + 1,
            "C Y" to 0 + 2,
            "C Z" to 3 + 3
        )

        val strategy = mapOf(
            // X/Y/Z means you have to lose/draw/win
            // so find the value of the correct shape (1/2/3 for rock/paper/scissors)
            // plus score to lose,draw,win
            "A X" to 3 + 0,
            "A Y" to 1 + 3,
            "A Z" to 2 + 6,
            "B X" to 1 + 0,
            "B Y" to 2 + 3,
            "B Z" to 3 + 6,
            "C X" to 2 + 0,
            "C Y" to 3 + 3,
            "C Z" to 1 + 6
        )

        fun puzzleA() {
            var score = 0
            for (line in data) {
                score += outcomes[line] ?: 0
            }
            println(score)
        }

        fun puzzleB() {
            var score = 0
            for (line in data) {
                score += strategy[line] ?: 0
            }
            println(score)
        }
    }
}
