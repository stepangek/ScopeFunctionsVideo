class MyComputer {
    fun installFancyApps() : String = "apps installed"

    fun crash() {}

    companion object {
        val myComputer = MyComputer()
    }
}

class MyGrandpa {
    fun installVirusOn(comp: MyComputer): String = "virus installed"

    companion object {
        val myGrandpa = MyGrandpa()
    }
}

