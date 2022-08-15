//Все эти функции используются для переключения контекста между текущей функцией / переменной
//Они используются для хранения связанных инструкций вместе в одном месте(наиболее часто для инициализации)
fun main(args: Array<String>) {

    // run - возвращает все что угодно(результат лямбды) и оборачивает переменную в this внутри функции
    // в примере создается обьект PasswordGenerator, устанавливаются переменные и генерируется пароль с помощью generate()
    val password = PasswordGenerator().run {
        seed = "someString"
        hash = someHash(seed!!)
        hashRepetitions = 1000

        generate()
    }
    // так же функция run может быть применена без обьекта, на котором применяется, например
    // создание генератора паролей может происходить прямо внутри контекстной функции, но внутри ссылка this разумеется
    // не доступна. на глаз заметно увеличение громоздкости кода, хотя выражает он абсолютно одно и то же.
    val anotherPassword = run {
        val generator = PasswordGenerator()
        generator.seed = "someSeed"
        generator.hash = someHash(generator.seed!!)
        generator.hashRepetitions = 1000

        generator.generate()
    }


    // apply - в отличии от run возвращет обьект, на котором была применена. Часто используется для "донастройки"
    // различных обьектов, как это показано в примере. Так же данная особенность позволяет использовать apply как
    // замену паттерна Строитель, когда нужно переиспользовать созданную конфигурацию.
    val generator = PasswordGenerator().apply {
        seed = "someAnotherString"
        hash = someHash(seed!!)
        hashRepetitions = 1000
    }

    val passwordWithApply = generator.generate()


    // let - наиболее часто используется для избегания проверок на null, но так же используется как замена для run.
    // в отличии от run, текущий обьект представлен перменной it.
    val fruitBasket = mutableListOf<Apple>()


    // ниже приведен пример использования данной функции -> совмещенное использование safecall-оператора и let.
    // код внутри лямбды выполнен не будет, т.к. в apple = null.
    var apple : Apple? = null
    apple?.let {
        println("adding a apple!")
        fruitBasket.add(it)
    }

    // этот код будет выполнен, так как apple != null
    apple = Apple()
    apple?.let {
        println("adding a apple!")
        fruitBasket.add(it)
    }

    // with - прменяется аналогично с apply, однако обьект над которым совершается действие,
    // передается в качестве параметра. Тут мы просто сьели яблочко :)
    with(apple) {
        eat()
    }
}


class AppleBasket {
    private var weight = 0
    private val basket = mutableListOf<Apple>()

    // also - используется когда необходимо применение apply, но есть необходимость не перекрывать ссылку this
    // в данном примере видно что, weight есть и у корзины, и у яблока. но в данном контексте this - это корзина,
    // а it - это яблоко.
    fun addFrom(appleTree: AppleTree) {
        val apple = appleTree.pick().also {
            this.weight += it.weight
            add(it)
        }
    }

    fun add(apple: Apple) = basket.add(apple)
}