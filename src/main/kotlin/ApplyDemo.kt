import MyComputer.Companion.myComputer
import stubs.PasswordGenerator
import stubs.someHash

class ApplyDemo {
    // apply - возвращает объект, на котором была применена. Часто используется для "донастройки"
    // различных объектов, как это показано в 2 примере. Так же данная особенность позволяет использовать apply как
    // замену паттерна Строитель

    // 1 пример
    var crashedComputer = myComputer.apply {
        //вы компьютер, вы сами устнавливаете приложения и результат возвращается
        installFancyApps()
    }.crash()

    // 2 пример
    val generator = PasswordGenerator().apply {
        seed = "someAnotherString"
        hash = someHash(seed!!)
        hashRepetitions = 1000
    }
    val passwordWithApply = generator.generate()

}