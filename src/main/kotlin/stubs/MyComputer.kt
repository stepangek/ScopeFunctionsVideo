class MyComputer {
    fun installFancyApps() : String = "apps installed"

    fun crash() = CrashedComputer()

    companion object {
        val myComputer = MyComputer()
    }
}

class CrashedComputer

class MyGrandpa {
    fun installVirusOn(comp: MyComputer): String = "virus installed"

    companion object {
        val myGrandpa = MyGrandpa()
    }
}

