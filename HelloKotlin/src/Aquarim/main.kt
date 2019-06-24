package Aquarim

fun main(){
    buildAquarium()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("lenght - ${myAquarium.length} , height ${myAquarium.height} , Width ${myAquarium.width}")

    myAquarium.height = 80
}
