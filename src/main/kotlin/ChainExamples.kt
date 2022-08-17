import stubs.*

class ChainExamples {
    // комбинация повторного использования let и map.
    // проведя цепочку преобразований в values попадет результат работы цепочки функций:
    // 1. map сконвертирует все обьекты в jsonObject с полями из specials
    // 2. первый let отфильтрует обьекты, удовлетворяющие specials.filter
    // 3. второй let отсортирует значения в jsonObj соответственно столбцам из header, чтобы при выводе
    //    стобцы заголовка соответствовали данным
    //TODO: вопрос для quiz: на какую функцию можно безболезненно заменить применение let в текущем контексте
    //      изменив только ссылку внутри let?

    // сейчас эта функция ничего не возвращает, но можно легко сделать из нее однострочную функцию
    // с возвращаемым значением (показываю как)
    fun exampleOne(data: List<IConvertableToFilteredJson>, specials: SpecialRenderParameters, header: List<String>){
        val values = data
            .map { it.toFilteredJsonObject(specials) }
            .let { filterValuesInObj(it, specials.filter) }
            .let { it.map { sortValuesInObj(it, header) } }
    }

    // пример обработки в kotlin-стиле
    // 1. функция начинается с return и вся обработка после
    // 2. если строка фильтра пришла не пустая, то над списком json при помощи let фильтруются обьекты,
    //    попадающие под условие value(без кавычек) == str, иначе возвращется исходное значение
    // Т.о. комбинирование операторов помогает сразу получить конечный "полезный" результат
    // не храня промежуточные значения.
    // так же в жтом примере показана реализация, как ссылка it внутри let замененена на objects
    // это нужно для того, чтобы многоуровневая вложенность контекста не сбивала с толку и не наткнуться на shadowing
    //TODO: вопрос для quiz: какая функция из exampleOne реализована в exampleTwo?
    fun exampleTwo(json: List<JsonObject>, filterStr: String): List<JsonObject>{
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

    // пример shadowing. здесь хорошо видно, что it повторяется три раза и это было бы проблемой
    // если бы idea не подсвечивала все ссылки на что ссылается в начале открываюейся фигурной скобки
    // к сожелению, это тоже сбивает с толку, и правильынй нейминг параметра очень важен для
    // легкого понимания кода людьми, которые будет его читать после вас
    fun badExampleThree(json: List<JsonObject>, filterStr: String): List<JsonObject>{
        return if (filterStr.isNotBlank()) {
            json.let {
                it.filter {
                    it.entries.any {
                        it.value.toString().replace("\"", "") == filterStr
                    }
                }
            }
        } else json
    }
}
