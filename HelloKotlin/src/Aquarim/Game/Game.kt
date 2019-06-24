package Aquarim.Game

fun main(){
    val game = Game()
    north(game.Pathth)
    south(game.Pathth)
    west(game.Pathth)
    east(game.Pathth)
    println(game.Pathth)
}
enum class Directions {
    NORTH, EAST, WEST, SOUTH, START, END
}

class Game {
    fun makeMove(argument : String?): Unit{
        when{
            Directions.WEST.toString().equals(argument!!.capitalize()) -> move(west)
            Directions.EAST.toString().equals(argument!!.capitalize()) -> move(east)
            Directions.NORTH.toString().equals(argument!!.capitalize()) -> move(north)
            Directions.SOUTH.toString().equals(argument!!.capitalize()) -> move(south)
        }
    }
    var path = mutableListOf<Directions>(Directions.START)
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = { path.add(Directions.END); println("Game Over: $path"); path.clear(); false }
}

fun move(where : () -> Boolean){
    where()
}
