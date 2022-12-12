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
                var arr = IntArray(split.size)
                var expRow = BooleanArray(split.size)
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
            var innerCount = 0
            var leftAdd = 1
            var rightSubtract = 2
            var exitCount = 1
            println("Height Size ${heights.size}")
            while (innerCount < (heights[0].size - 1) / 2) {
                // Number of rounds to check tree
                while (y < heights.size - 3) {
                    //y-height progression
                    while (exitCount < 3) {
                        //x-width progression check
                        println("X: $x Y: $y")
                        visible(x, y)
                        x = heights[0].size - rightSubtract
                        exitCount++
                    }
                    if (rightSubtract == heights.size / 2) {
                        exitCount = 2
                    } else {
                        exitCount = 1
                    }
                    
                    x = leftAdd
                    y++
                }
                y = 1
                leftAdd++
                rightSubtract++
                x = leftAdd
                innerCount++
            }
            println("")
            println(expCount)
            println(heights[0].size)
        }
        //guesses: 488, 423, 466, 468


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
