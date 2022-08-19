import MyComputer.Companion.myComputer
import MyGrandpa.Companion.myGrandpa
import stubs.processString

class LetDemo {
    // let - аналог run, но внутри вместо this ссылка it

    // 1 пример
    val grandpaResult = myComputer.let {
        myGrandpa.installVirusOn(it)
    }

    // 2 пример
    fun exampleTwo(){
        val str: String = "Hello"
        val length = str.let {
            println("Вызов функции let() для $it")
            processString(it)      // OK: 'it' не может быть null внутри конструкции '?.let { }'
            it.length
        }
    }



    fun nullableLetUsage(){
        // let часто используется для избегания проверок на null

        // ниже приведен пример такого использования -> совмещенное использование safecall-оператора и let.
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