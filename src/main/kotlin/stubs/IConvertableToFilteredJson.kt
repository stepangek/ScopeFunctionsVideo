package stubs

/**
 * Интерфейс позволяет сконвертировать определенный объект в JsonObject со значениями, переданными в options.fields
 */
@Suppress("SpreadOperator")
interface IConvertableToFilteredJson {
    /**
     * Функция, реализующая конвертацию обьекта в JsonObject со значениями, переданными в options.fields
     */
    fun toFilteredJsonObject(options: SpecialRenderParameters) : JsonObject {
        return JsonObject()
    }


}

class SpecialRenderParameters(val filter: String) {

}

class JsonObject {
   val entries = hashMapOf<String, Int>()
}

fun filterValuesInObj(json: List<JsonObject>, filterStr: String): List<JsonObject> {
    return mutableListOf()
}

fun sortValuesInObj(json: JsonObject, header: List<String>): JsonObject {
    return JsonObject()
}