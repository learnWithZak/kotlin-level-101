package m_classes

class MovieList(val name: String, val movies: MutableList<String> = mutableListOf()) {

    fun print() {
        println("Movie List: $name")
        movies.forEach {
            println(it)
        }
    }
}

class User(val lists: MutableMap<String, MovieList> = mutableMapOf()) {

    fun addList(list: MovieList) {
        lists[list.name] = list
    }

    fun list(name: String): MovieList? {
        return lists[name]
    }
}

fun main() {
    val jane = User()
    val john = User()
    val actionList = MovieList(name = "Action")

    jane.addList(actionList)
    john.addList(actionList)

    // Add Jane's favorites
    jane.lists["Action"]?.movies?.add("Rambo")
    jane.lists["Action"]?.movies?.add("Terminator")

    // Add John's favorites
    john.lists["Action"]?.movies?.add("Die Hard")

    // See John's list:
    john.lists["Action"]?.print()

    println("-------")
    // See Jane's list:
    jane.lists["Action"]?.print()

    // the two instances reference the same object
    println(john.lists["Action"] === jane.lists["Action"])

    println("-------Challenge 2----------")

    data class TShirt(val size: Int, val color: String, val price: Float, val image: String?)
    data class Address(val name: String, val street: String, val city: String, val zipCode: String)
    class ShoppingCart(val currentOrder: List<TShirt> = mutableListOf(),
                       val shippingAddress: Address) {

        fun cost(): Double {
            var totalPrice = 0.0
            currentOrder.forEach {
                totalPrice += it.price
            }
            return totalPrice
        }
    }
    data class User(val name: String, val email: String, val shoppingCart: ShoppingCart)
}