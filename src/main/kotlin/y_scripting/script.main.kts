package y_scripting

import java.io.File

println("Hello, scripting!")
if (args.isEmpty()) {
    println("[no args]")
} else {
    println("Args:\n ${args.joinToString("\n ")}")
}

fun currentFolder(): File {
    return File("").absoluteFile
}

fun File.contents(): List<File> {
    return this.listFiles()?.toList() ?: emptyList()
}

fun File.fileNames(): List<String> {
    return this.files().map { it.name }
}

fun File.folders(): List<File> {
    return this.contents().filter { it.isDirectory }
}

fun File.files(): List<File> {
    return this.contents().filter { it.isFile }
}

fun File.folderNames(): List<String> {
    return this.folders().map { it.name }
}

fun File.printFolderInfo() {
    // 1
    println("Contents of `${this.name}`:")

    // 2
    if (this.folders().isNotEmpty()) {
        println("- Folders:\n   ${this.folderNames().joinToString("\n   ")}")
    }

    // 3
    if (this.files().isNotEmpty()) {
        println("- Files:\n   ${this.fileNames().joinToString("\n   ")}")
    }

    // 4
    println("Parent: ${this.parentFile.name}")
}

currentFolder().printFolderInfo()

fun valueFromArgsForPrefix(prefix: String): String? {
    val arg = args.firstOrNull { it.startsWith(prefix) }

    if (arg == null) return null

    val pieces = arg.split("=")
    return if (pieces.size == 2) {
        pieces[1]
    } else {
        null
    }
}

val folderPrefix = "folder="
val folderValue = valueFromArgsForPrefix(folderPrefix)

if (folderValue != null) {
    val folder = File(folderValue).absoluteFile
    folder.printFolderInfo()
} else {
    println("No path provided, printing working directory info")
    currentFolder().printFolderInfo()
}

