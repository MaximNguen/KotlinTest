fun main(args: Array<String>) {
    println("Введите свое имя в качестве игрока")
    val name = readLine()
    var healthPoints = 100
    var heals = 2
    var currentMoney :Int = 0
    val enemies = listOf(1,2,3)

    println("Вас зовут $name. У вас 100 здоровья... \nУ вас есть зелья, которые лечал вас по 40 здоровья \nВы решили пойти в подземелье, где есть 10 уровней, смотря на вашу удачи и тактику, посмотрим сможете ли вы выжить... \nНа каждом этаже есть 3 прохода, в одной из них затаился враг, способный нанести вам 35 здоровья... Будьте осторожны с выбором прохода...")

    for (i in 1..10) {
        println("\nВы вошли в $i уровень... Видите перед с собой 3 прохода к следующему уровню, выберете один из 3...")
        val playerPosition :Int = readLine()!!.toInt()
        val enemyPosition = enemies.random()
        if (playerPosition == enemyPosition) {
            healthPoints -= 35
            println("О нет! Это проход был с врагом! Ваше здоровье составляет - $healthPoints")
        }
        if (heals == 0) {
            println("У ВАС ЗАКОНЧИЛИСЬ ЗЕЛЬЯ ЛЕЧЕНИЯ!")
        }
        while (healthPoints < 100 && healthPoints > 0 && heals > 0) {
            println("У вас есть зелья! Вы хотите их использовать? Yes or No?")
            val answer = readLine()
            if (answer == "Yes") {
                if (100 - healthPoints > 40) {
                    healthPoints += 40
                    println("Вы восстановили здоровье до $healthPoints")
                    heals -= 1
                    break
                } else {
                    healthPoints = 100
                    println("Вы восстановили здоровье полностью")
                    heals -= 1
                    break
                }
            }
            if (answer == "No") {
                break
            }
        }
        if (healthPoints > 1 && playerPosition == enemyPosition) {
            currentMoney += 50
            println("За очистку уровня с врагом вы получаете 50 монет!")
        }  else if (healthPoints > 1 && playerPosition != enemyPosition) {
            println("За безопасную очистку вы получаете 30 монет!")
            currentMoney += 30
        }

        if (healthPoints < 1) {
            println("\nВас убили! Вы дошли до $i уровня!")
            println("У вас $currentMoney монет!")
            println("Ваше здоровье - 0")
            break
        }
        if (healthPoints > 1 && i == 10) {
            println("\nВы дошли до $i уровня! Вы прошли игру!")
            println("У вас $currentMoney монет!")
            println("Ваше здоровье - $healthPoints")
            break
        }
        if (healthPoints < 1 && i == 10) {
            println("\nВы дошли до $i уровня! Вы почти прошли игру!")
            println("У вас $currentMoney монет!")
            println("Ваше здоровье - 0")
            break
        }
        println("Ваше здоровье - $healthPoints")
        println("Монеты - $currentMoney")
    }
}