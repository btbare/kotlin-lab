enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

//interface seen below
//stores no actual data, stateless
//can be used in both classes and functionsS
//used to define the naming conventions and methods in which developers interact (or interface) with yo stuff
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz: ProgressPrintable {

    override val progressText: String
    get() = "${answered} of ${total} answered"

    override fun printProgressBar(){
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(Quiz.progressText)
    }

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    Quiz().printProgressBar()
}