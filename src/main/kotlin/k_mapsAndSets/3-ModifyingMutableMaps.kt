package k_mapsAndSets

fun main() {

    /**
     * Adding pairs
     */
    val bobData = mutableMapOf(
        "name" to "Bob",
        "profession" to "CardPlayer",
        "country" to "USA"
    )
    bobData["city"] = "San Francisco"

    /**
     * Mini-exercise
     */
    fun printCityAndCountry(player: Map<String, String>) {
        println(player["country"])
        println(player["city"])
    }
    printCityAndCountry(bobData)

    /**
     * Updating values
     */
    val oldValue = bobData.put("name", "Bobby") // returns the old value
    println(oldValue)
    bobData["profession"] = "Mailman"

    val pair = "nickname" to "Bobby D"
    bobData += pair
    println(bobData)

    /**
     * Removing pairs
     */
    bobData.remove("city")
    bobData.remove("state", "CA")
    bobData.remove("nickname", "toto")
    println(bobData)
}