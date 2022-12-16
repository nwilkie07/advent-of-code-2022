import kotlin.math.abs

class Day9 {

    companion object {
        private val count = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        fun puzzleA(data: List<String>): Int {
            val visited = mutableListOf<Cell>()
            val head = Cell(0, 0)
            val tail = Cell(0, 0)
            visited.add(Cell(head.x, head.y))
            for (line in data) {
                if (line != "") {
                    val instr = line.split(" ")
                    val dir = instr[0]
                    var move = instr[1].toInt()

                    while (move > 0) {
                        val prev = Cell(head.x, head.y)
                        when (dir) {
                            "U" -> {
                                head.y += 1
                                move--
                            }

                            "D" -> {
                                head.y -= 1
                                move--
                            }

                            "L" -> {
                                head.x -= 1
                                move--
                            }

                            "R" -> {
                                head.x += 1
                                move--
                            }
                        }
                        //sqrt((head.x - tail.y).pow(2) + (head.y - tail.y).pow(2)) > 1
                        if (abs(head.x - tail.x) > 1 || abs(head.y - tail.y) > 1) {
                            tail.x = prev.x
                            tail.y = prev.y
                            if (!visited.contains(tail)) {
                                visited.add(Cell(tail.x, tail.y))
                            }
                        }

                    }
                }
            }

//            for (cell in visited) {
//                println("Visited: X:${cell.x} Y: ${cell.y}");
//            }
            return (visited.size)
        }

        fun puzzleB(data: List<String>): Int {
            val rope = mapOf(
                0 to Cell(0, 0),
                1 to Cell(0, 0),
                2 to Cell(0, 0),
                3 to Cell(0, 0),
                4 to Cell(0, 0),
                5 to Cell(0, 0),
                6 to Cell(0, 0),
                7 to Cell(0, 0),
                8 to Cell(0, 0),
                9 to Cell(0, 0),
            )
            val visited = mutableListOf<Cell>()
            visited.add(Cell(rope[0]!!.x, rope[0]!!.y))
            for (line in data) {
                if (line != "") {
                    val instr = line.split(" ")
                    val dir = instr[0]
                    var move = instr[1].toInt()

                    while (move > 0) {
                        when (dir) {
                            "U" -> {
                                rope[0]!!.y += 1
                                move--
                            }

                            "D" -> {
                                rope[0]!!.y -= 1
                                move--
                            }

                            "L" -> {
                                rope[0]!!.x -= 1
                                move--
                            }

                            "R" -> {
                                rope[0]!!.x += 1
                                move--
                            }
                        }

                        for (num in count) {
                            var vertical = mapOf(0 to (abs(rope[num]!!.x - rope[num - 1]!!.x) > 0), 1 to (abs(rope[num]!!.x - rope[num - 1]!!.x) > 1))
                            var horizontal = mapOf(0 to (abs(rope[num]!!.y - rope[num - 1]!!.y) > 0), 1 to (abs(rope[num]!!.y - rope[num - 1]!!.y) > 1))
                            
                            //if it was a horizontal move only
                            if (horizontal[1]!! && !vertical[0]!!) {
                                applyX(rope,num)
                                break
                            } else if (vertical[1]!! && !horizontal[0]!!) {
                                applyY(rope,num)
                            } else if (horizontal[0]!! && vertical[0]!!) {
                                applyX(rope,num)
                                applyY(rope,num)
                            }
                        }
                        if (!visited.contains(rope[9])) {
                            visited.add(Cell(rope[9]!!.x, rope[9]!!.y))
                        }
                    }
                    println(rope)
                    println(visited)
                    println()
                }
            }
//            for (cell in rope) {
//                println("Visited: X:${cell.value.x} Y: ${cell.value.y}");
//            }
            return (visited.size)

        }
    }
}

fun applyX (rope: Map<Int,Cell>, num: Int) {
    if (rope[num - 1]!!.x > rope[num]!!.x) {
        rope[num]!!.x += 1
    } else {
        rope[num]!!.x -= 1
    }
}

fun applyY (rope: Map<Int,Cell>, num: Int) {
    if (rope[num - 1]!!.y > rope[num]!!.y) {
        rope[num]!!.y += 1
    } else {
        rope[num]!!.y -= 1
    }
}

data class Cell(var x: Int, var y: Int)