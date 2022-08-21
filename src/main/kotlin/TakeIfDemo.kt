import kotlin.random.Random

class takeIfDemo {

    fun takeIftakeUnlessCall() {
        val number = Random.nextInt(100)

        val evenOrNull = number.takeIf { it % 2 == 0 }
        val oddOrNull = number.takeUnless { it % 2 == 0 }
        println("четный: $evenOrNull, нечетный: $oddOrNull")
    }

    fun nullableReturnCall() {
        val str = "Hello"
        val caps = str.takeIf { it.isNotEmpty() }?.toUpperCase()
//        val caps = str.takeIf { it.isNotEmpty() }.toUpperCase() //compilation error
        println(caps)
    }

    fun chainWithTakeIf() {
        fun displaySubstringPosition(input: String, sub: String) {
            input.indexOf(sub).takeIf { it >= 0 }?.let {
                println("Подстрока $sub находится в $input.")
                println("Начинается с индекса $it.")
            }
        }

        displaySubstringPosition("010000011", "11")
        displaySubstringPosition("010000011", "12")
    }

    fun imperativeStyleChain() {
        fun displaySubstringPosition(input: String, sub: String) {
            val index = input.indexOf(sub)
            if (index >= 0) {
                println("Подстрок $sub находится в $input.")
                println("Начинается с индекса $index.")
            }
        }

        displaySubstringPosition("010000011", "11")
        displaySubstringPosition("010000011", "12")
    }
}