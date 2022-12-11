import java.util.ArrayDeque

class Day5 {

    companion object {
        private val day = 5
        val data = DataSource.getDataAsList(5)
        fun puzzleA() {
            var stacks = mapOf(
                1 to ArrayDeque<String>(),
                2 to ArrayDeque<String>(),
                3 to ArrayDeque<String>(),
                4 to ArrayDeque<String>(),
                5 to ArrayDeque<String>(),
                6 to ArrayDeque<String>(),
                7 to ArrayDeque<String>(),
                8 to ArrayDeque<String>(),
                9 to ArrayDeque<String>(),
            )
            var mover = ArrayDeque<String>()
            var count = 0
            var arrCount = 1
            var process = false
            for (line in data) {
                if (line == "") {
                    process = true
                }
                if (!process) {
                    while (count < line.length - 1) {
                        if (line.substring(count + 1, count + 2) != " " && line.substring(count + 1, count + 2)
                                .toIntOrNull() == null
                        ) {
                            stacks[arrCount]?.push(line.substring(count + 1, count + 2))
                        }
                        arrCount++
                        count += 4
                    }
                    arrCount = 1
                    count = 0
                }
                
                

                if (process && line != "") {
                    val instructions = line.split(" ")
                    var move = instructions[1].toInt()
                    val start = instructions[3].toInt()
                    val end = instructions[5].toInt()
                    while (move > 0) {
                        if (stacks[start]?.size == 0) {break}
                        mover.push(stacks[start]?.removeLast())
                        move--
                    }
                    while (mover.size != 0) {
                        stacks[end]?.addLast(mover.removeFirst())
                    }
                }
            }

            count = 1
            while (count <= stacks.size) {
                if (stacks[count]?.size != 0) {
                    print(stacks[count]?.last)
                }
                count++
            }
            
            print(stacks)
        }


        fun puzzleB() {


        }
    }
}
