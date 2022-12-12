import com.sun.source.tree.Tree
import java.util.StringJoiner

class Day7 {
    companion object {
        private val day = 7
        val data = DataSource.getDataAsList(7)
        var root = TreeNode(0, "root")
        val diskSpace = 70000000
        val requiredSpace = 30000000
        fun puzzleA() {
            for (line in data) {
                val process = line.split(" ")

                //if it is a command
                if (process[0] == "$") {
                    when (process[1]) {
                        "ls" -> {}
                        "cd" -> {
                            when (process[2]) {
                                ".." -> root = root.parent!!
                                "/" -> {
                                }

                                else -> {
                                    root = getNode(root, process[2])
                                }
                            }
                        }
                    }
                }
                if (process[0].toIntOrNull() != null) {
                    root.value = root.value + process[0].toInt()
                }
                if (process[0] == "dir") {
                    if (!contains(root, process[1]))
                        root.addChild(TreeNode(0, process[1]))

                }
            }

//            println("root: ${root.name}")
            while (root.parent != null) {
                root = root.parent!!
            }
            accumulateValues(root)
            while (root.parent != null) {
                root = root.parent!!
            }
            var totalUsage = root.value
            println(totalUsage)
            val freeSpace = diskSpace - totalUsage
            val needToRemove = requiredSpace - freeSpace
            println("Remove: $needToRemove")
            
            var dummyNode = TreeNode(1000000000, "dummy")
            var deleteMe = getToDelete(root, needToRemove, dummyNode)
//            printTree(root, 0)
            println("${deleteMe.name} ${deleteMe.value}")

        }

        fun printTree(t: TreeNode<String>, level: Int) {
            var count = 0
            var levelString = ""
            while (count < level) {
                levelString = "$levelString\t"
                count++
            }
            for (child in t.children) {
                println("$levelString ${child.name} Size: ${child.value}")
                printTree(child, level + 1)
            }
        }

        fun accumulateValues(t: TreeNode<String>): Int {
            for (child in t.children) {
//                println(child.value)
                t.value += accumulateValues(child)
            }
            return t.value
        }

        fun getSum(t: TreeNode<String>): Int {
            var result = 0
            for (child in t.children) {
                var temp = 0
                if (child.value in 1..100000) {
                    temp = child.value
                }
                result += temp + getSum(child)

            }
            return result
        }

        fun contains(t: TreeNode<String>, name: String): Boolean {
            for (child in t.children) {
                if (child.name == name) {
                    return true
                }
            }
            return false
        }

        fun getToDelete(t: TreeNode<String>, amount: Int, selected: TreeNode<String>): TreeNode<String> {
            var current: TreeNode<String> = selected
            for (child in t.children) {
                 //WRONG: pwtqzwv 4131645
                current = getToDelete(child, amount, current)
                if (child.value >= amount && current.value >= child.value) {
                    current = child
                    println(child.value)
                }
            }
            return current
        }

        fun getNode(t: TreeNode<String>, name: String): TreeNode<String> {
            for (child in t.children) {
                if (child.name == name) {
                    return child
                }
            }
            return t
        }


        fun puzzleB() {

        }
    }
}


class TreeNode<String>(value: Int, name: String) {
    var value: Int = value
    var name: String = name
    var parent: TreeNode<String>? = null

    var children: MutableList<TreeNode<String>> = mutableListOf()

    fun addChild(node: TreeNode<String>) {
        children.add(node)
        node.parent = this
    }
}
