import MyComputer.Companion.myComputer
import MyGrandpa.Companion.myGrandpa

class AlsoDemo {
    // also - используется когда нужно совершить над каким либо объектом еще одно или несколько действий,
    // и вернуть исходный объект и возможно совершить еще какие-нибудь действия

    //1 пример
    val anotherCrashedComputer = myComputer.also {
        //теперь вы дедушка и хотите что-нибудь сделать с компьютером
        myGrandpa.installVirusOn(it)
    }.crash()

    // 2ой пример
    class AppleBasket {
        private var weight = 0
        private val basket = mutableListOf<Apple>()

        // also - используется когда необходимо применение apply, но есть необходимость не перекрывать ссылку this
        // в данном примере видно что, weight есть и у корзины, и у яблока. Но в данном контексте this - это корзина,
        // а it - это яблоко.
        fun addFrom(appleTree: AppleTree) {
            val apple = appleTree.pick().also {
                this.weight += it.weight
                add(it)
            }
        }

        fun add(apple: Apple) = basket.add(apple)
    }

}