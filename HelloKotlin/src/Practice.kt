fun main() {
    repeat(1){
        println(whatShouldIDoToday("sad"))
        println(whatShouldIDoToday("sad", "rainy", 40))
    }
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {

        isSadAndRainy(mood, weather) -> "look from window"
        isHot(temperature) -> "go Swiming"
        mood == "sad" -> "stay at home"
        mood == "happy" -> "go for a walk"
        else -> "dont go outside"
    }
}

fun isHot(temperature: Int): Boolean {
    return temperature > 30
}

fun isSadAndRainy(mood: String, weather: String): Boolean {
    return mood == "sad" && weather == "rainy"

}
