class Day3 {

    companion object {
        private val day = 3
        val data = DataSource.getDataAsList(3)
        val rank = mapOf(
            "a" to 1,
            "b" to 2,
            "c" to 3,
            "d" to 4,
            "e" to 5,
            "f" to 6,
            "g" to 7,
            "h" to 8,
            "i" to 9,
            "j" to 10,
            "k" to 11,
            "l" to 12,
            "m" to 13,
            "n" to 14,
            "o" to 15,
            "p" to 16,
            "q" to 17,
            "r" to 18,
            "s" to 19,
            "t" to 20,
            "u" to 21,
            "v" to 22,
            "w" to 23,
            "x" to 24,
            "y" to 25,
            "z" to 26,
            "A" to 27,
            "B" to 28,
            "C" to 29,
            "D" to 30,
            "E" to 31,
            "F" to 32,
            "G" to 33,
            "H" to 34,
            "I" to 35,
            "J" to 36,
            "K" to 37,
            "L" to 38,
            "M" to 39,
            "N" to 40,
            "O" to 41,
            "P" to 42,
            "Q" to 43,
            "R" to 44,
            "S" to 45,
            "T" to 46,
            "U" to 47,
            "V" to 48,
            "W" to 49,
            "X" to 50,
            "Y" to 51,
            "Z" to 52
        )

        fun puzzleA() {
            var sum = 0
            for (bag in data) {
                val arr = bag.toCharArray()
                val com1 = arr.copyOfRange(0, arr.size / 2)
                val com2 = arr.copyOfRange(arr.size / 2, arr.size)
                for (letter in com1) {
                    if (com2.contains(letter)) {
                        sum += rank[letter.toString()] ?: 0
                        break;
                    }
                }
            }
            println(sum)
        }

        fun puzzleB() {
            var sum = 0
            var count = 0;
            while (count < data.size - 1) {
                val bag1 = data[count]
                val bag2 = data[count + 1]
                val bag3 = data[count + 2]

                for (letter in bag1) {
                    if (bag2.contains(letter)) {
                        if (bag3.contains(letter)) {
                            sum += rank[letter.toString()] ?: 0
                            break;
                        }
                    }
                }

                count += 3
            }
            println(sum)
        }

    }
}
