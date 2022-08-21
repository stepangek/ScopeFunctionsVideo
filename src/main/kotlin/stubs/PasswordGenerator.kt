package stubs

import java.math.BigInteger
import java.security.MessageDigest
import kotlin.random.Random

const val STRING_LENGTH = 10


class PasswordGenerator{
    var seed: String? = null
    var hash: String? = null
    var hashRepetitions: Int? = null

    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun generate() : String = (1..STRING_LENGTH)
                              .map{ i -> Random.nextInt(0, charPool.size) }
                              .map(charPool::get)
                              .joinToString("")
}

fun someHash(string: String): String = md5(string)

fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}
