class Day7 {

    companion object {
        private val day = 7
        val data = DataSource.getDataAsList(7)
        var root = TreeNode(0, "root")
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
                                "/" -> {}
                                else -> {
                                    for (a in root.children) {
                                        if (a.name == process[2]) {
                                            root = a
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                if (process[0].toIntOrNull() != null) {
                    root.value += root.value + process[0].toInt()
                }
                if (process[0] == "dir") {
                    if (process[1].toIntOrNull() != null) {
                        root.value = process[1].toInt()
                    } else {
                        if (!root.children.contains(TreeNode(0, process[1])))
                            root.addChild(TreeNode(0, process[1]))
                    }

                }
            }

            while (root.parent != null) {
                root = root.parent!!
            }
            printTree(root)
        }

        fun printTree(t: TreeNode<String>) {
            println(t.name)
            if (t.value != 0) {
                println(t.value)
            }

            for (child in t.children) {
                printTree(child)
            }
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
