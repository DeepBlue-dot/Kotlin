import kotlin.random.Random

fun main() {
    val random = Random
    val randomInt = random.nextInt(100)
    var guess: Int?
    var attempts: Int = 0

    println("Welcome to the Number Guessing Game!")

    do{
        println("Enter your guess:")
        guess = readLine()?.toIntOrNull()

        if (guess == null) {
            println("Please enter a valid number.")
            continue
        }

        attempts++

        when {
            guess < randomInt -> println("Too low! Try again.")
            guess > randomInt -> println("Too high! Try again.")
            else -> println("Congratulations! You've guessed the number in $attempts attempts.")
        }

    }while(guess != randomInt)

}
