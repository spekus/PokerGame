package Aquarim

abstract class AquariumFish {
    abstract val color : String
}

class Shark :AquariumFish(), FishAction{
    override fun eat() {
        println("I am hunting for fish")
    }

    override val color = "grey"
}

interface FishAction{
    fun eat()
}

interface FishColor {
    val color: String
}
class Plecostomus : FishAction,
    FishColor by GoldColor{
    override fun eat() {
        println("eat algaee")
    }
}

object GoldColor: FishColor{
    override val color = "gold"
}