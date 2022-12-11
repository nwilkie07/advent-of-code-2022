class Day1 {

    companion object {
        private val day = 1
        val data = DataSource.getDataAsList(1)
        fun puzzleA() {
            var elf = 0
            var high = 0
            for (a in data) {
                if (a != "") {
                    elf += a.toInt()
                } else {
                    if (elf > high) {
                        high = elf
                    }
                    elf = 0
                }
            }
            println(high)
        }

        fun puzzleB() {
            var elf = 0
            var high = mutableListOf<Int>()
            for (a in data) {
                if (a != "") {
                    elf += a.toInt()
                } else {
                    high.add(elf)
                    elf = 0
                }
            }
            high.sortDescending()
            println(high.take(3).sum())
        }
    }
}
