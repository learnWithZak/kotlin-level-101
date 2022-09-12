package o_properties

class Car(val make: String, val color: String)
class Contact(var fullName: String, var emailAddress: String)
class Contact2(var fullName: String, val emailAddress: String)
class Contact3(var fullName: String, val emailAddress: String, var type: String = "Friend")

fun main() {
    val contact = Contact(
        fullName = "Grace Murray",
        emailAddress = "grace@murray.com"
    )

    val name = contact.fullName
    val email = contact.emailAddress

    contact.fullName = "Grace Hopper"
    val grace = contact.fullName

    var contact2 = Contact2(
        fullName = "Grace Murray",
        emailAddress = "grace@murray.com"
    )
    // contact2.emailAddress = "toto@titi.com" // Error

    /**
     * Default values
     */

    var contact3 = Contact3(
        fullName = "Grace Murray",
        emailAddress = "grace@murray.com"
    )
    contact3.type = "Work"

    var workContact = Contact3(
        fullName = "Grace Murray",
        emailAddress = "grace@murray.com",
        type = "Work"
    )
}
