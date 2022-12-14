import stubs.*

class ChainExamples {
    // Комбинация повторного использования let
    // проведя цепочку преобразований в sum попадет результат работы цепочки функций:
    // 1. первый let просуммирует значения объекта MyObj
    // 2. второй let сконвертирует значение из первого let в double и домножит на 8
    // в sum в результате будет храниться результат выполнения двух операций


    fun exampleOne() : Double = MyObj(3, 5)
            .let { it.x + it.y }
            .let { it.toDouble() * 8 }


     // Аналогичный пример с also. Результат будет такой же,
    // но при выводе будет напечатана строка с промежуточным значением из первого let
    fun examapleTwo() {
        val sum = MyObj(3, 5)
            .let { it.x + it.y }
            .also { println("debug: $it") }
            .let { it.toDouble() * 8 }
    }


    // Пример shadowing. Видно, что it повторяется три раза и это проблема понимания контекста для читающего
    // гораздо проще было бы понять, что есть что если бы параметр лямбды был именованный
    fun exampleThreeShadowed(obj: MyObj, filterStr: String) {
        return obj.let {
            if (it.x > 0 && it.y > 0) {
                it.let {
                    it.x.toDouble() + it.y.toDouble()
                }
            } else it.x
        }
    }

    fun exampleThree(obj: MyObj, filterStr: String): Any {
        return obj.let { srcObj ->
            if (srcObj.x > 0 && srcObj.y > 0) {
                srcObj.let { passIfObj ->
                    passIfObj.x.toDouble() + passIfObj.y.toDouble()
                }
            } else srcObj.x
        }
    }




    // Пример вложенной обработки в kotlin-стиле
    // 1. Функция начинается с return и вся обработка после
    // 2. если строка фильтра пришла не пустая, то над списком json при помощи let фильтруются объекты,
    //    попадающие под условие value(без кавычек) == str, иначе возвращаться исходное значение
    // Т.о. комбинирование операторов помогает сразу получить конечный "полезный" результат
    // не храня промежуточные значения.
    // Так же в этом примере показана реализация, как ссылка it внутри let замененена на objects
    // это нужно для того, чтобы многоуровневая вложенность контекста не сбивала с толку
    // и не наткнуться на shadowing.
    fun exampleFour(json: List<JsonObject>, filterStr: String): List<JsonObject> {
        return if (filterStr.isNotBlank()) {
            json.let { objects ->
                objects.filter { obj ->
                    obj.entries.any { entry ->
                        entry.value.toString().replace("\"", "") == filterStr
                    }
                }
            }
        } else json
    }

    // Пример shadowing. Хорошо видно, что it повторяется три раза и это проблема понимания контекста для
    // читающего гораздо проще было бы понять, что есть что если бы параметр лямбды был именованный
    fun exampleFourShadowed(json: List<JsonObject>, filterStr: String): List<JsonObject> {
        return if (filterStr.isNotBlank()) {
            json.let {
                it.filter {
                    it.entries.any {
                        it.value.toString() == filterStr
                    }
                }
            }
        } else json
    }
}
