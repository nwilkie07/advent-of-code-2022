class Day2 {

    companion object {
        private val day = 2
        val data = DataSource.getDataAsList(2)
        fun puzzleA() {
            val game = mapOf(
                "A X" to 3 + 1,
                "A Y" to 6 + 2,
                "A Z" to 0 + 3,
                "B X" to 0 + 1,
                "B Y" to 3 + 2,
                "B Z" to 6 + 3,
                "C X" to 6 + 1,
                "C Y" to 0 + 2,
                "C Z" to 3 + 3,
            )
            var points = 0;

            for (a in data) {
                points += game.get(a) ?: 0
            }
            println(points)
        }

        fun puzzleB() {
            val game = mapOf(
                "A X" to 0 + 3,
                "A Y" to 3 + 1,
                "A Z" to 6 + 2,
                "B X" to 0 + 1,
                "B Y" to 3 + 2,
                "B Z" to 6 + 3,
                "C X" to 0 + 2,
                "C Y" to 3 + 3,
                "C Z" to 6 + 1,
            )
            var points = 0;

            for (a in data) {
                points += game.get(a) ?: 0
            }
            println(points)
        }

    }
}
