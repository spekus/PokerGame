package Aquarim.Dcoerations

fun main(){
    nakeDecorations()
}

fun nakeDecorations() {
    val decorations = Decorations("granite")
    println(decorations)
}

data class Decorations(val rocks : String){

}