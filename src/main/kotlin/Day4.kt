class Day4 {

    companion object {
        private val day = 4
        val data = DataSource.getDataAsList(4)
        var count = 0
        fun puzzleA() {
            for (pair in data) {
                val elves = pair.split(",")
                if (elves.size < 2) {
                    break
                }
                val elf1 = elves[0].split("-")
                val elf2 = elves[1].split("-")

                if (elf1[0].toInt() <= elf2[0].toInt() && elf1[1].toInt() >= elf2[1].toInt()) {
                    count++
                } else if (elf2[0].toInt() <= elf1[0].toInt() && elf2[1].toInt() >= elf1[1].toInt()) {
                    count++
                }
            }
            println(count)
        }

        fun puzzleB() {
            for (pair in data) {
                val elves = pair.split(",")
                if (elves.size < 2) {
                    break
                }
                val elf1 = elves[0].split("-") //2 - 6 4 - 8
                val elf2 = elves[1].split("-") //2 - 6 8 - 10

                if (elf1[0].toInt() <= elf2[0].toInt() && elf1[1].toInt() >= elf2[1].toInt()) {
                    count++
                } else if (elf2[0].toInt() <= elf1[0].toInt() && elf2[1].toInt() >= elf1[1].toInt()) {
                    count++
                } else if (elf1[0].toInt() == elf2[0].toInt() || elf1[1].toInt() == elf2[1].toInt() || elf1[0].toInt() == elf2[1].toInt() || elf1[1].toInt() == elf2[0].toInt()) {
                    count++
                } else if (elf2[0].toInt() < elf1[0].toInt() && elf1[0].toInt() < elf2[1].toInt()) {
                    count++
                } else if (elf2[0].toInt() < elf1[1].toInt() && elf1[1].toInt() < elf2[1].toInt()) {
                    count++
                } else if (elf1[0].toInt() < elf2[1].toInt() && elf2[1].toInt() < elf1[1].toInt()) {
                    count++
                } else if (elf1[0].toInt() < elf2[0].toInt() && elf2[0].toInt() < elf1[1].toInt()) {
                    count++
                }
            }
            println(count)
        }

    }
}
