class Day8_2 {

    companion object {
        private val day = 8
        var heights = mutableListOf<IntArray>()
        var expCount = 0
        fun puzzleA(data: List<String>): Int {
            var x: Int
            var y = 0

            //builds int array
            for (line in data) {
                if (line != "") {
                    val split = line.split("")
                    var arr = IntArray(split.size - 1)
                    x = 0
                    for (tree in split) {
                        if (tree != "") {
                            arr[x] = tree.toInt()
                            x++
                        }
                    }
                    heights.add(arr)
                    y++
                }
            }

            x = 0
            y = 0
            println(heights.size)
            println(heights[0].size)
            for (row in heights) {
                for (tree in row) {
                    if (x == 0 || y == 0 || y == heights.size - 2 || x == row.size - 1) {
                        expCount++
                        println("X: $x Y: $y Count: $expCount")
                    } else {
                        visible(x, y)
                    }
                    x++
                }
                x = 0
                y++
            }

            return(expCount)
        }
        //guesses: 488, 423, 466, 468, 1179, 990


        fun visible(x: Int, y: Int) {
            var curX = x
            var curY = y
            var value = heights[y][x]
            while (curX < heights[0].size - 1) {
                curX++
                if (value <= heights[y][curX]) {
                    break
                } else {
                    value = heights[y][curX]
                }
            }
            if (curX == heights[0].size - 1) {
                expCount++
                return
            }
            curX = x
            value = heights[y][x]
            while (curX > 0) {
                curX--
                if (value <= heights[y][curX]) {
                    break
                } else {
                    value = heights[y][curX]
                }
            }
            if (curX == 0) {
                expCount++
                return
            }
            value = heights[y][x]
            while (curY > 0) {
                curY--
                if (value <= heights[curY][x]) {
                    break
                } else {
                    value = heights[curY][x]
                }
            }
            if (curY == 0) {
                expCount++
                return
            }
            curY = y
            value = heights[y][x]
            while (curY < heights.size - 1) {
                curY++
                if (value <= heights[curY][x]) {
                    break
                } else {
                    value = heights[curY][x]
                }
            }
            if (curY == heights.size - 1) {
                expCount++
                return
            }
        }

        fun puzzleB() {


        }
    }
}
