package Spices

open abstract class Spice(var name: String = "Spice", var spiciness: String = "mild") {
    abstract  fun prepareSpice()
    var color =""
    val heat: Int
        get() = when (spiciness) {
            "spicy" -> 10
            "mild" -> 5
            else -> 0
        }

    //    fun makeSalt() = Spice("salt", "not spicy")
    init {
        println(" name is $name spiciness is $spiciness and heat is $heat ")
    }
    class Curry( spiceColor: SpiceColor = YellowSpiceColor, name: String = "Curry"): SpiceColor by YellowSpiceColor
        , grinder{
        fun prepareSpice() {
            println("make some curry")
        }

    }

    interface grinder{
        fun grind(things: String){
            println(" I am grinding $things")
        }
    }

    interface SpiceColor {
        val color: Color
    }

    object YellowSpiceColor : SpiceColor {
        override val color = Color.YELLOW
    }

    data class SpiceContainer(val spice: Spice){
        val label = spice.name
    }

    enum class Color(val rgb: Int) {
        RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00)
    }

}