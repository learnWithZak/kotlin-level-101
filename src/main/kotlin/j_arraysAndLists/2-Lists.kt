package j_arraysAndLists

/**
 * Lists
 */

// List is an interface
// Arrays are more efficient than lists in terms of performance
// lists are dynamically sized

/**
 * Creating lists
 */

val innerPlanets: List<String> = listOf("Mercury", "Venus", "Earth", "Mars")
// if you want to it to have the type ArrayList
val innerPlanetsArrayList = arrayListOf("Mercury", "Venus", "Earth", "Mars")

val subscribers = listOf<String>()

/**
 * Mutable lists
 */
val outerPlanets = mutableListOf("Jupiter", "Saturn", "Uranus", "Neptune")
val exoPlanets = mutableListOf<String>()