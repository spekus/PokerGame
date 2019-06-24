package Spices

class SimpleSpice {
    var nameOfSPice: String = "curry"
    var spiciness: String = "mild"

    val heat : Int
        get() = when(spiciness){
            "mild" -> 5
            else -> 0
        }




}