import MyComputer.Companion.myComputer
import MyGrandpa.Companion.myGrandpa

class LetDemo {
    // let - аналог run, но внутри вместо this ссылка it

    // 1 пример
    val grandpaResult = myComputer.let {
        myGrandpa.installVirusOn(it)
    }





    fun nullableLetUsage(){
        // let часто используется для избегания проверок на null

        // ниже приведен пример использования данной функции -> совмещенное использование safecall-оператора и let.
        // код внутри лямбды выполнен не будет, т.к. в apple = null.
        var apple : Apple? = null
        val eatedApple = apple?.let {
            println("У меня есть яблоко, я сейчас его сьем!")
            it.eat()
        }

        // этот код будет выполнен, так как apple != null
        apple = Apple()
        val eatedApple2 = apple?.let {
            println("У меня есть яблоко, я сейчас его сьем!")
            it.eat()
        }
    }
}