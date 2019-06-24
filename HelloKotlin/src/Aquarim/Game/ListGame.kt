package Aquarim.Game

fun main(){
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    var doesThings = {number:Int -> number.rem(3)}
    var newList = myListManipulation(numbers, doesThings)
    println(newList)
}
fun myListManipulation( listasss: List<Int>, block : Int.()  -> Int): List<Int>{
    val returnList :MutableList<Int> = mutableListOf<Int>()
    for( number in listasss){
        var skaicius = 0;
        skaicius = number.block()
        if(skaicius == 0){
            returnList.add(number)
        }
    }
return returnList
}
class Listas(){
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
}
