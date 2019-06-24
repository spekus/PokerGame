import java.time.DayOfWeek
import java.util.*

fun main(args: Array<String>){
    println(    canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))

}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 0, hasDecorations : Boolean = true): Boolean {
    return (tankSize * if(hasDecorations) 0.8 else 1.0) >= (currentFish.sum().plus(fishSize))
//
//    var totalSizeOfFish= 0
//    for (element in currentFish){
//        totalSizeOfFish = totalSizeOfFish.plus(element)
//    }
//    if(!hasDecorations){
//        return  tankSize > totalSizeOfFish +fishSize
//    }
//    return  tankSize.times(8).div(10) > totalSizeOfFish.plus(fishSize)
}



