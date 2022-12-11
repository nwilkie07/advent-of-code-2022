import java.util.ArrayDeque

class Day6 {

    companion object {
        private val day = 6
        val data = DataSource.getDataAsList(6)
        var current = ArrayDeque<String>()
        fun puzzleA() {
            var instr = data[0]?.split("")
            println(instr)
            var count = 0
            var letCount = 0
            if (instr != null) {
                for (letter in instr) {
                    if (letter != "") {
                        if (current.isEmpty() || !current.contains(letter)) {
                            current.addLast(letter)
                        } else {
                            current.addLast(letter)
                            var size = current.size
                            while (letCount < size) {
                                if (current.peek() == letter) {
                                    current.removeFirst()
                                    break
                                }
                                current.removeFirst()
                                letCount++
                            }
                        }
                        letCount = 0
                        if (current.size == 14) {
                            println(current)
                            println(count)
                            break
                        }
                    }
                    count++
                }
            }
        }


        fun puzzleB() {


        }
    }
}
