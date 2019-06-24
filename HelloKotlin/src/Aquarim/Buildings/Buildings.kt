package Aquarim.Buildings




open class BaseBuildingMaterial{
    fun <T : BaseBuildingMaterial>isSmallBuilding(building: Building<T>){
        if(building.actualMaterialsNeeded <= 500) println("small building") else println("larger building")
    }
    open var numberNeeded = 1
}
class Wood() : BaseBuildingMaterial(){
    override var numberNeeded = 4
}
class Brick() : BaseBuildingMaterial(){
    override var numberNeeded = 8
    fun printLine() =  println("it is a brick");
}

class Building< out T : BaseBuildingMaterial> (val material : T){
    var baseMaterialsNeeded = 100
    var actualMaterialsNeeded = material.numberNeeded * baseMaterialsNeeded
    fun build() = println("you need $actualMaterialsNeeded of")
}
fun main(){
    val woodenHouse = Building<BaseBuildingMaterial>(Wood())
    val woodenHouse2 = Building<BaseBuildingMaterial>(Brick())
    woodenHouse.build()
    woodenHouse2.build()
}