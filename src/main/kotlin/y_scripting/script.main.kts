package y_scripting

println("Hello, scripting!")
if (args.isEmpty()) {
    println("[no args]")
} else {
    println("Args:\n ${args.joinToString("\n ")}")
}

