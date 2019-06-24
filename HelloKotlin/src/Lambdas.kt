import kotlin.random.Random

fun main (){
//    Function type notation is more readable, which reduces errors, clearly showing the what type is passed in and what type is returned.
    val rollDice : (Int)-> (Int) = {side -> Random.nextInt(side)}

    val rollDice2 = {side :Int -> Random.nextInt(side)}
    gamePlay(rollDice2(4))
}

fun gamePlay(diceRoll: Int) {
    println(diceRoll)
}
