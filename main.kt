package converter
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode


fun main() {
    var exit = " "
    var numberOrBack = " "

    while (exit != "/exit") {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit)")
        exit = readLine()!!
        if (exit == "/exit") {
            break
        } else {
            val fromTo = exit.split(" ")
            while (true) {
                println("Enter number in base ${fromTo[0]} to convert to base ${fromTo[1]} (To go back type /back)")
                numberOrBack = readLine()!!
                // add number have "."
                if (numberOrBack == "/back") {
                    break
                } else {
                    println("Conversion result:" + k(fromTo[0], fromTo[1], numberOrBack))
                }
            }
        }
    }
}

fun k(from: String, to: String, n: String): String {
    var result = ""
    if (from == "10"){
        result = kalkulator(n, to.toInt())    // n to Integer
    } else {
        result = toKalkulator(n, from.toInt(), to)
    }
    return result
}
    fun kalkulator(first: String, second: Int): String {
        return fromDecToAnother(first, second)
    }
    fun toKalkulator(num: String, second: Int, to: String): String {  //n, from.toInt(), to
        return kalkulator(changToDec(num, second),to.toInt())
    }

fun fromDecToAnother(first: String, second: Int): String {
    var first = first
    var fragPart = ""
    var chack = false
    for (i in first){
        if (i == '.') {
            val numberPart = first.split(".")
            first = numberPart[0].toString()
            fragPart += numberPart[1].toString()
            chack = true
        }
    }
    if (chack){
        fragPart = fractions("0.$fragPart", second.toString())
    }
    var liczbaSzes = ""
    var s = arrayListOf<String>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F","G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    var new_s = arrayOf<String>()
    var superCounter = -1
    for (i in s){
        superCounter += 1
        if (superCounter < second)
            new_s += i
    }
    var z = BigInteger(first)
    var newSecond = BigInteger.valueOf(second.toLong())
    var conter = -1
    var y = 0
    while (z > BigInteger.ZERO) {
        y = (z % newSecond).toInt()
        for (i in new_s) {
            conter++
            if (conter.toString() == y.toString()) {
                liczbaSzes += i
            }
            if (conter == second - 1) {
                conter = -1
            }
        }
        z = z / newSecond
    }
    var noweWord = mirror(liczbaSzes)
    return noweWord + fragPart
}
    fun mirror(normal: String): String {
        return normal.reversed()
    }

fun changToDec(num: String, second: Int): String {

    var num = num
    var fragPart = ""
    var chack = false
    for (i in num){
        if (i == '.') {
            val numberPart = num.split(".")
            num = numberPart[0].toString()
            fragPart += numberPart[1].toString()
            chack = true
        }
    }
    if (chack){
        fragPart = frabmentbintoDec("0.$fragPart", second.toString())
    }

    val mBin = mirror(num).toString().toUpperCase()
    val xd = (mBin.length).toInt()
    var tab = arrayOf("1")  // Array<String>(xd)
    var c2 = -1
    var s3 = BigInteger.ZERO
    repeat(xd) {
        c2 += 1
        if (c2 == 0) {
            s3 = BigInteger.ONE
        }
        if (c2 == 1) {
            tab += second.toString()
            s3 = BigInteger(second.toString())
        }
        if (c2 > 1) {
            s3 *= BigInteger(second.toString())
            tab += s3.toString()
        }
    }
    var c = -1
    var con1 = -1
    val xs = IntArray(mBin.length)
    var s = arrayListOf<String>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F","G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    var new_s = arrayOf<String>()
    var superCounter = -1
    for (i in s){
        superCounter += 1
        if (superCounter < second)
            new_s += i
    }
    for (j in mBin) {
        c += 1
        for (l in new_s) {
            con1 += 1
            if (j.toString() == l) {
                xs[c] = con1
            }
        }
        con1 = -1
    }
    var c12 = -1
    var s2 = BigInteger.ZERO
    for (i in tab) {
        c12 += 1
        var k = xs[c12].toString()
        var df = BigInteger(k) * BigInteger(i)
        s2 += df
    }
    return s2.toString() + fragPart
}
fun fractions(number:String, to: String): String{
    var fractionPaart = arrayOf("0", "0", "0", "0", "0")
    var part1 = number.split(".")
    val x = "0."
    var y = x + part1[1]
    for (i in 0..4){
        var result = BigDecimal(y) * BigDecimal(to)
        var part1 = result.toString().split(".")
        fractionPaart[i] = part1[0]
        y = x + part1[1]
    }
    var s = arrayListOf<String>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F","G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

    var newPart1 = ""
    for (i in fractionPaart){
        if (i.toInt() > 9){
            newPart1 += s[i.toInt()]
        } else {
            newPart1 += i
        }
    }
    return ".$newPart1"
}

fun frabmentbintoDec(number:String, to: String): String {
    var s = arrayListOf<String>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f","g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    var superCounter = -1
    var part1 = number.split(".")
    var part01 = part1[1]
    var tab = arrayOf("0")
    for (i in 0..part01.length) {
        tab += powBigDecimal(to.toDouble(), i)
    }
    var fragmentDecimal = BigDecimal("0.00000")
    var conter = 1
    for (i in part01) {
        conter += 1
        for (j in s) {
            if (part01 == "00000"){
                break
            }
            superCounter += 1
            var g = "$i"
            if (j == g){
                fragmentDecimal += BigDecimal(tab[conter]) * BigDecimal(superCounter.toString())
                break
            }
        }
        superCounter = -1
    }
    val newFD =fragmentDecimal.setScale(5, RoundingMode.DOWN)
    var afterKropka = newFD.toString().split(".")
    var xr = ".${afterKropka[1]}"
    return xr
}

fun powBigDecimal(to:Double, i:Int):String{
    val divider = BigDecimal(1 / to)
    var result = divider
    if(i > 0) {
        repeat(i - 1) {
            result *= divider
            if (result < BigDecimal("0.0000001")) {
                result = BigDecimal("0.0000001")
            }
        }
        return result.toString()
    }
    else {
        return "0"
    }
}
