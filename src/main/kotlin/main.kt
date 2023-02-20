 data class Datas(val name: String, var currentMoney: Int, var healthPoints: Int, var heals: Int, var lottery: Int)

fun main() {
    println("Введите свое имя в качестве игрока")
    val lotteryNums = 1
    val player = Datas("Max", 0, 100, 2, lotteryNums)
    val enemies = listOf(1,2,3)
    val boostChoice = (1..5).random()
    val boost: Int = when (boostChoice) {
        1 -> 1
        else -> 0
    }

    println("Вас зовут ${player.name}. У вас 100 здоровья... \nУ вас есть зелья, которые лечал вас по 40 здоровья \nВы решили пойти в подземелье, где есть 10 уровней, смотря на вашу удачи и тактику, посмотрим сможете ли вы выжить... \nНа каждом этаже есть 3 прохода, в одной из них затаился враг, способный нанести вам 35 здоровья... Будьте осторожны с выбором прохода...")

    for (i in 1..10) {
        println("\nВы вошли в $i уровень... Видите перед с собой 3 прохода к следующему уровню, выберете один из 3...")
        val playerPosition :Int = readLine()!!.toInt()
        val enemyPosition = enemies.random()
        if (playerPosition == enemyPosition) {
            player.healthPoints -= 35
            println("О нет! Это проход был с врагом! Ваше здоровье составляет - ${player.healthPoints}")
        }
        if (player.heals == 0) {
            println("У ВАС ЗАКОНЧИЛИСЬ ЗЕЛЬЯ ЛЕЧЕНИЯ!")
        }
        while (player.healthPoints < 100 && player.healthPoints > 0 && player.heals > 0) {
            println("У вас есть зелья! Вы хотите их использовать? Yes or No?")
            val answer = readLine()
            if (answer == "Yes") {
                if (100 - player.healthPoints > 40) {
                    player.healthPoints += 40
                    println("Вы восстановили здоровье до ${player.healthPoints}")
                    player.heals -= 1
                    break
                } else {
                    player.healthPoints = 100
                    println("Вы восстановили здоровье полностью")
                    player.heals -= 1
                    break
                }
            }
            if (answer == "No") {
                break
            }
        }

        if (i == 5) {
            println("Вы дошли до стадии ЛОТЕРЕИ!!! У вас есть шанс 1/5 выиграть классные призы!")
            if (player.lottery == boost) {
                println("Вам повезло! Вы выиграли лотерею! В качестве это мы лечим вам до полного здоровья либо выдаем вам награду в воде 200 монет!")
                if (player.healthPoints == 100) {
                    player.currentMoney += 200
                } else {
                    player.healthPoints = 100
                }
            } else {
                println("Вам не повезло(")
            }
        }

        if (player.healthPoints > 1 && playerPosition == enemyPosition) {
            player.currentMoney += 50
            println("За очистку уровня с врагом вы получаете 50 монет!")
        }  else if (player.healthPoints > 1 && playerPosition != enemyPosition) {
            println("За безопасную очистку вы получаете 30 монет!")
            player.currentMoney += 30
        }

        if (player.healthPoints < 1) {
            println("\nВас убили! Вы дошли до $i уровня!")
            println("У вас ${player.currentMoney} монет!")
            println("Ваше здоровье - 0")
            break
        }
        if (player.healthPoints > 1 && i == 10) {
            println("\nВы дошли до $i уровня! Вы прошли игру!")
            println("У вас ${player.currentMoney} монет!")
            println("Ваше здоровье - ${player.healthPoints}")
            break
        }
        if (player.healthPoints < 1 && i == 10) {
            println("\nВы дошли до $i уровня! Вы почти прошли игру!")
            println("У вас ${player.currentMoney} монет!")
            println("Ваше здоровье - 0")
            break
        }
        println("Ваше здоровье - ${player.healthPoints}")
        println("Монеты - ${player.currentMoney}")
    }
}