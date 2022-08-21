import MyComputer.Companion.myComputer

class WithDemo {
    // with - совершает над обьектом, который
    // передается в качестве параметра определенные
    // действия и возвращает результат лямбды(как let)

    //1 пример
    fun computerInstall(): String = with(myComputer) {
        //вы компьютер, вы устанавливаете программы на себя
        installFancyApps()
    }

    //2 пример
    fun eatApple(){
        val apple = Apple()
        val eatedApple = with(apple) {
            eat()
        }
    }


}