class LabeledReturnDemo {
    fun labeledReturnCall() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // локальный возврат внутри лямбды, то есть к циклу forEach
            print(it)
        }
        print(" выполнится с использованием неявной метки(forEach@)")
    }
}