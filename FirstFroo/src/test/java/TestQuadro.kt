import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

internal open class TestQuadro {

    @Test
    open fun `Test TwoRootsMock`() {
        val mockObj = Mockito.mock(Quadro::class.java)
        Mockito.`when`(mockObj.getA()).thenReturn(1.0)
        Mockito.`when`(mockObj.getB()).thenReturn(3.0)
        Mockito.`when`(mockObj.getC()).thenReturn(2.0)
        val tL = mutableListOf<Double>((-1.0), (-2.0))
        assertEquals(tL[0], Read(mockObj).declaim()[0])
        assertEquals(tL[1], Read(mockObj).declaim()[1])
    }

    @Test
    open fun `Test OneRootsMock` (){
        val mockObj = Mockito.mock(Quadro::class.java)
        Mockito.`when`(mockObj.getA()).thenReturn(1.0)
        Mockito.`when`(mockObj.getB()).thenReturn(12.0)
        Mockito.`when`(mockObj.getC()).thenReturn(36.0)
        val tL = mutableListOf<Double>((-6.0))
        assertEquals(tL[0],Read(mockObj).declaim()[0])
    }
    @Test
    open fun `Test NoRootsMock`(){
        val Obj = Mockito.mock(Quadro::class.java)
        Mockito.`when`(Obj.getA()).thenReturn(10.0)
        Mockito.`when`(Obj.getB()).thenReturn(0.0)
        Mockito.`when`(Obj.getC()).thenReturn(45.0)
        val tL = mutableListOf<Double>((-0.0))
        assertEquals(tL[0],Read(Obj).declaim()[0])
    }

    @Test
    fun `Discriminant More Than Zero`() {

        val equation = Read(2.0, 1.0, -3.0)
        assertEquals(1.0, equation.declaim()[0])
        assertEquals(-1.5, equation.declaim()[1])
    }
}