fun main(args: Array<String>) {
    val hasSteed = (0.. 2).toList()
    val num = hasSteed.random()
    println("Введите имя игрока!")
    val name = readLine()
    println("У $name нет питомца, так что он пошел искать себе питомца!")
    if (num == 1)
        println("У $name есть МИНОТАВР")
    else if (num == 2)
        println("У $name есть ДРАКОН")
    else
        println("$name не нашел себе питомца(((")

    // Будет выполнятьс, если у игрока нет питомца
    if (num == 0) {
        var money = 50
        println()
        println("Next Task")
        println()
        println("Добро Пожаловать в наш Трактир! Желаете купить конюшню?")
        println("$name отвечает: Нет, спасибо, у меня нет скакуна, но есть 50 монет, желаю купить у вас напитки")
        println("Что желаете? Мед - 5, вино - 10, пиво - 7")
        val drink = (0.. 2).toList()
        val x = drink.random()
        if (x == 0) {
            money -= 5
            println("$name купил мед... У него осталось $money")
        }
        else if (x == 1) {
            money -= 10
            println("$name купил вино... У него осталось $money")
        }
        else if (x == 2) {
            money -= 7
            println("$name купил пиво... У него осталось $money")
        }
    }


}