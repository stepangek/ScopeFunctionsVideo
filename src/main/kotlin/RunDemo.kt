import MyComputer.Companion.myComputer
import stubs.PasswordGenerator
import stubs.someHash

class RunDemo {
    // run - возвращает все что угодно(результат лямбды) и оборачивает переменную в this внутри функции
    // 1ый пример
    fun runInstallation(): String = myComputer.run {
            //вы компьютер, вы сами устанавливаете программы и возвращаете результат
            installFancyApps()
        }

    // 2ой пример
    // в примере создается объект PasswordGenerator,
    // устанавливаются переменные и генерируется пароль с помощью generate()
    val password = PasswordGenerator().run {
        seed = "someString"
        hash = someHash(seed!!)
        hashRepetitions = 1000

        generate()
    }

    // так же функция run может быть применена без обьекта, на котором применяется, например
    // создание генератора паролей может происходить прямо внутри контекстной функции, но внутри ссылка this разумеется
    // не доступна. на глаз заметно увеличение громоздкости кода, хотя выражает он одно и тоже.
    val anotherPassword = run {
        val generator = PasswordGenerator()
        generator.seed = "someSeed"
        generator.hash = someHash(generator.seed!!)
        generator.hashRepetitions = 1000

        generator.generate()
    }
    //рассказать что это разные функции(залезть в исходинки и показать)

}