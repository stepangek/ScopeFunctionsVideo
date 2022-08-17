import MyComputer.Companion.myComputer

class WithDemo {
    // with - прменяется аналогично с apply, однако обьект над которым совершается действие,
    // передается в качестве параметра и вам не нужен контекстный обьект обратно в качестве
    // возвращаемого значения

    //1 пример
    fun eatApple(){
        val apple = Apple()
        with(apple) {
            eat()
        }
    }

    //2 пример
    fun computerInstall() {
        with(myComputer) {
            //вы компьютер, вы устанавливаете программы на себя
            installFancyApps()
        }
    }
}