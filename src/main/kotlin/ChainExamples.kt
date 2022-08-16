import stubs.*

class ChainExamples {

    fun exampleOne(data: List<IConvertableToFilteredJson>, specials: SpecialRenderParameters, header: List<String>){
        val values = data
            .map { it.toFilteredJsonObject(specials) }
            .let { filterValuesInObj(it, specials.filter) }
            .let { it.map { sortValuesInObj(it, header) } }
    }

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
}

