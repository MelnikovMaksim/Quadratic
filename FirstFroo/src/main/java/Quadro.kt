import java.util.*

interface Quadro{
    fun getA():Double
    fun getB():Double
    fun getC():Double
}

class Read(var A:Double, var B:Double, var C:Double, val zero:Double = 1e-15){
    constructor(Read:Quadro):this(Read.getA(),Read.getB(),Read.getC()){
        A=Read.getA()
        B=Read.getB()
        C=Read.getC()
    }

    private fun sqr(x:Double) = x*x
    private fun discriminant():Double = sqr(B) - 4*A*C
    val res:Double = discriminant()
    val qr:Double = Math.sqrt(res)
    private fun x1():Double=(-B+qr)/(2*A)
    private fun x2():Double=(-B-qr)/(2*A)
    private fun x():Double=(-B)/(2*A)
    
    fun declaim(): List<Double>{
        if(Math.abs(A) < zero)
            throw IllegalArgumentException("A should`n be a zero")
        val tally = mutableListOf<Double>()

        if(res > zero){
                    tally.add(x1())
                    tally.add(x2())
            return tally
        }else if(res < zero){
            tally.add(x())
            return tally
        }else{
            return tally
        }
    }
}
