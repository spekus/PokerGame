package Books.Book

import kotlin.random.Random

const val MAX_NUMBER_BOOKS =8
var borrowedBooks = 0

fun main(){
    val allBooks = setOf("Antony and Cleopatra", "Coriolanus", "Hamlet", "Julius Caesar", "King Lear")
    val library : Map<String, Set<String>> = mutableMapOf(Pair("Shekspyras", allBooks))
    println(library.getValue("Shekspyras").contains("Hamlet"))
    val map = mutableMapOf<String, String>()

    println(map.getOrPut("x") { "labas" }) // 2
    library.any {it.component1().contains("Shekspyras")}
    val book = Book("Winter is Comming", "Martin", 2006)
    val puppy = Puppy()
    println(book.getWeight())
    println(book.tearPages(20))
    println(book.getWeight())
    while (book.pages > 0){
        println(puppy.playWithBook(book))
        println(book.getWeight())
    }

}

open class Book (val title : String,val author: String, val year : Int =2000, var pages: Int = 200){

    companion object{
        const val BASE_URL ="www/fsdfsdf/sdf"
    }


    private var currentPage : Int = 0
    open fun readPage(){
        currentPage++
    }
    fun getTitleAndAuthor() : Pair<String, String>{
        return title to author
    }
    fun getTitleAuthorAndYear() : Triple<String, String, Int>{
        return Triple (title, author, year)
    }
    fun canBorrow(): Boolean{
        return borrowedBooks <= MAX_NUMBER_BOOKS
    }
    fun printUrl(){
        println("BASE_URL$title")

    }
}
class EBook(title : String, author: String,var format : String = "text"):Book(title, author){
    private var wordCount = 0
    override fun readPage(){
        wordCount += 250
    }

}
fun Book.getWeight() : Double{
    return this.pages * 1.5
}

fun Book.tearPages(numberOfPages : Int){
    this.pages -= numberOfPages;
}
class Puppy{
    fun playWithBook(book : Book){
        book.tearPages(Random.nextInt(book.pages +1))
    }
}

