fun main() {
    val board = Array(3) { Array(3) { 0 } }
    val players = mapOf(1 to "X", 2 to "O")
    var turn = 1
    var choice: String

    println("Welcome to Tic Tac Toe!")

    do {
        printBoard(board)
        println("Player ${players[turn]}, enter a number to play (1-9) or \"q\" to Exit:")

        choice = readLine() ?: ""

        if (choice == "q") break

        val position = choice.toIntOrNull()

        if (position != null && position in 1..9) {
            val (row, col) = positionToIndex(position)
            if (board[row][col] == 0) {
                board[row][col] = turn
                if (checkWin(board, turn)) {
                    printBoard(board)
                    println("Player ${players[turn]} wins!")
                    return
                }
                if (board.flatten().none { it == 0 }) {
                    printBoard(board)
                    println("It's a draw!")
                    return
                }
                turn = if (turn == 1) 2 else 1
            } else {
                println("Cell already taken. Choose another cell.")
            }
        } else {
            println("Invalid input. Enter a number between 1 and 9.")
        }
    } while (true)
}

fun printBoard(board: Array<Array<Int>>) {
    println(" ${board[0][0].toSymbol()} | ${board[0][1].toSymbol()} | ${board[0][2].toSymbol()}")
    println("---+---+---")
    println(" ${board[1][0].toSymbol()} | ${board[1][1].toSymbol()} | ${board[1][2].toSymbol()}")
    println("---+---+---")
    println(" ${board[2][0].toSymbol()} | ${board[2][1].toSymbol()} | ${board[2][2].toSymbol()}")
}

fun Int.toSymbol(): String {
    return when (this) {
        1 -> "X"
        2 -> "O"
        else -> " "
    }
}

fun positionToIndex(position: Int): Pair<Int, Int> {
    return ((position - 1) / 3) to ((position - 1) % 3)
}

fun checkWin(board: Array<Array<Int>>, player: Int): Boolean {
    // Check rows
    for (row in board) {
        if (row.all { it == player }) return true
    }

    // Check columns
    for (col in 0..2) {
        if (board.all { it[col] == player }) return true
    }

    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true

    return false
}
