package machine

const val WATER = 400
const val MILK = 540
const val BEANS = 120
const val CUP = 9
const val MONEY = 550
var state = mutableListOf(WATER, MILK, BEANS, CUP, MONEY)

class CoffeeMachine {
    fun action() {
        while (true) {
            println("Write action (buy, fill, take, remaining, exit):")
            val act = readln()
            when (act){
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> remainingCMachine()
                "exit" -> break
            }
        }
    }

    fun buy(){
        println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val typeOfCoffee = readln()
        when (typeOfCoffee) {
            "1" -> espresso()
            "2" -> latte()
            "3" -> cappuccino()
            "back" -> return
        }
    }

    fun espresso() {
        val esp = stateCoffeeMachine(state).toMutableList()
        if (esp[0] - 250 >=0) {
            if (esp[2] - 16 >= 0) {
                if (esp[3] - 1 >= 0) {
                    println("I have enough resources, making you a coffee!")
                    esp[0] -= 250 // water
                    esp[2] -= 16 // beans
                    esp[3] -= 1 // disCups
                    esp[4] += 4 // money
                    println()
                    state = stateCoffeeMachine(esp) as MutableList<Int>
                } else println("Sorry, not enough disposable cups!\n")
            } else println("Sorry, not enough beans!\n")
        } else println("Sorry, not enough water!\n")
    }

    fun latte(){
        val ltt = stateCoffeeMachine(state).toMutableList()
        if (ltt[0] - 350 >= 0) {
            if (ltt[1] - 75 >= 0 ) {
                if (ltt[2] - 20 >= 0) {
                    if (ltt[3] - 1 >= 0) {
                        println("I have enough resources, making you a coffee!")
                        ltt[0] -= 350 // water
                        ltt[1] -= 75 // milk
                        ltt[2] -= 20 // beans
                        ltt[3] -= 1 // disCups
                        ltt[4] += 7 // money
                        println()
                        state = stateCoffeeMachine(ltt) as MutableList<Int>
                    } else println("Sorry, not enough disposable cups!\n")
                } else println("Sorry, not enough beans!\n")
            } else println("Sorry, not enough milk!\n")
        } else println("Sorry, not enough water!\n")
    }

    fun cappuccino() {
        val cpc = stateCoffeeMachine(state).toMutableList()
        if (cpc[0] - 200 >= 0) {
            if (cpc[1] - 100 >= 0 ) {
                if (cpc[2] - 12 >= 0) {
                    if (cpc[3] - 1 >= 0) {
                        println("I have enough resources, making you a coffee!")
                        cpc[0] -= 200 // water
                        cpc[1] -= 100 // milk
                        cpc[2] -= 12 // beans
                        cpc[3] -= 1 // disCups
                        cpc[4] += 6 // money
                        println()
                        state = stateCoffeeMachine(cpc) as MutableList<Int>
                    } else println("Sorry, not enough disposable cups!\n")
                } else println("Sorry, not enough beans!\n")
            } else println("Sorry, not enough milk!\n")
        } else println("Sorry, not enough water!\n")
    }

    fun fill(){
        val fillState = stateCoffeeMachine(state).toMutableList()
        println("\nWrite how many ml of water you want to add:")
        fillState[0] += readln().toInt() // water
        println("Write how many ml of milk you want to add:")
        fillState[1] += readln().toInt() // milk
        println("Write how many grams of coffee beans you want to add:")
        fillState[2] += readln().toInt() // beans
        println("Write how many disposable cups you want to add:")
        fillState[3] += readln().toInt() // disCups
        state = fillState
        println()
    }

    fun take(){
        val money = stateCoffeeMachine(state).toMutableList()
        println("\nI gave you $${money[4]}")
        money[4] = 0
        state = money
        println()
    }

    fun printState(stateMachine: List<Int>)
    {
        println("\nThe coffee machine has:")
        println("${stateMachine[0]} ml of water")
        println("${stateMachine[1]} ml of milk")
        println("${stateMachine[2]} g of coffee beans")
        println("${stateMachine[3]} disposable cups")
        println("$${stateMachine[4]} of money")
    }

    fun stateCoffeeMachine(state: List<Int>): List<Int> {
        val nowState = state
        return nowState
    }

    fun remainingCMachine(){
        printState(stateCoffeeMachine(state))
        println()
    }
}



fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.action()

//    val availableSupplies = listOf(
//        milk / 50,
//        water / 200,
//        beans / 15
//    )
//    val availableCups = min(availableSupplies)
//
//    println(when {
//        availableCups == cups -> "Yes, I can make that amount of coffee"
//        availableCups > cups -> "Yes, I can make that amount of coffee (and even ${availableCups - cups} more than that)"
//        availableCups < cups -> "No, I can make only $availableCups cups of coffee"
//        else -> ""
//    })
}




