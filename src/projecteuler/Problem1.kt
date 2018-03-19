package projecteuler

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfMultiplesTest {
    /**
     * Multiples of 3 and 5
     *
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */

    val s = SumOfMultiples();

    @Test
    fun testNaturalsBelow10() {
        assertEquals(23, s.sumOfMult(listOf(3,5), (1..9).toList()))
    }

    @Test
    fun testNaturalsBelow100() {
        assertEquals(2318, s.sumOfMult(listOf(3,5), (1..99).toList()))
    }

    @Test
    fun testNaturalsBelow1000() {
        assertEquals(233168, s.sumOfMult(listOf(3,5), (1..999).toList()))
    }
}

class SumOfMultiples {

    fun sumOfMult(possibleDivisors: List<Int>, dividends: List<Int>): Int {
        /**
         * The list "dividends" contains all numbers we will possibly get the sum at the end.
         * We filter it by checking if there is a number on "possibleDivisors" which is an actual
         * divisor of any of its elements.
         */
        return dividends.filter { dividend ->
            /**
             * Here "dividend" represents an element of "dividends". To check if there is an element
             * on "possibleDivisors" that actually divides it, we take all the non-divisors and count them.
             * If the number of non-divisors is less the number of possible divisors, then at least one
             * is an actual divisor.
             */
            possibleDivisors.takeWhile { divisor -> dividend % divisor != 0 }.size < possibleDivisors.size
        }.sum()
    }

}