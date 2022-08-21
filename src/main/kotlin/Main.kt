import stubs.MyObj

//Все эти функции используются для переключения контекста между текущей функцией / переменной
//Они используются для хранения связанных инструкций вместе в одном месте(наиболее часто для инициализации)
fun main(args: Array<String>) {
    // let часто используется для избегания проверок на null

    // ниже приведен пример такого использования -> совмещенное использование safecall-оператора и let.
    // код внутри лямбды выполнен не будет, т.к. в apple = null.
    var apple : Apple? = null
    val eatedApple = apple?.let {
        println("У меня есть яблоко, я сейчас его сьем!")
        it.eat()
    }

    println(eatedApple)

    // этот код будет выполнен, так как apple != null
    apple = Apple()
    val eatedApple2 = apple?.let {
        println("У меня есть яблоко, я сейчас его сьем!")
        it.eat()
    }

    println(eatedApple2)


    MyObj(3, 5)
        .let { it.x + it.y }
        .let { it.toDouble() * 8 }
        .also { println(it) }

}
