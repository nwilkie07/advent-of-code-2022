import java.util.ArrayDeque


class Day8 {

    companion object {
        private val day = 8
        val data = DataSource.getDataAsList(8)
        var heights = mutableListOf<IntArray>()
        var exposed = mutableListOf<BooleanArray>()
        var expCount = 0
        fun puzzleA() {
            var x: Int
            var y = 0
            println(data.size)
            for (line in data) {
                val split = line.split("")
                var arr = IntArray(split.size - 2)
                var expRow = BooleanArray(split.size - 2)
                x = 0
                for (tree in split) {
                    if (tree != "") {
                        arr[x] = tree.toInt()
                        if (x == 0 ||
                            y == 0 ||
                            x == split.size - 3 ||
                            y == split.size - 3
                        ) {
//                            println("x: $x y: $y")
                            expRow[x] = true
                            expCount++
                            
                        } else {
                            expRow[x] = false
                        }
                        x++
                    }
                }
                heights.add(arr)
                exposed.add(expRow)
                y++
            }
            
            x = 1
            y = 1
            var add = 1
            var skip = 3
            var exit = 1
            while (y < heights.size - 2) {
                while (exit < 3) {
                    visible(x, y)
                    x += heights[0].size - skip
                    exit++
                }
                add++
                skip += 2
                exit = 1
                x = add
                y++
            }
            for (element in heights[0]) {
                print(element)
            }
            println("")
            for (element in heights[1]) {
                print(element)
            }
            println("")
            println(expCount)
        }

        fun visible(x: Int, y: Int) {
            if (!exposed[y][x]) {
                var curTree = heights[y][x]
                val up: Boolean = curTree > heights[y - 1][x] && exposed[y - 1][x]
                val left: Boolean = curTree > heights[y][x - 1] && exposed[y][x - 1]
                val down: Boolean = curTree > heights[y + 1][x] && exposed[y + 1][x]
                val right: Boolean = curTree > heights[y][x + 1] && exposed[y][x + 1]
                if (y <= heights.size / 2) {
                    if (x <= heights[0].size / 2) {
                        if (up || left || down) {
                            expCount++
                            exposed[y][x] = true
                        }
                    } 
                } else {
                    if (x >= heights[0].size / 2) {
                        if (right || up || down) {
                            expCount++
                            exposed[y][x] = true
                        }
                    } 
                }
            }
        }

        fun puzzleB() {


        }
    }
}
