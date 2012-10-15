import org.junit.Test

import static org.junit.Assert.assertEquals

import org.adscale.KarateChop1.Chop

class KarateChop_Test {

    def chopper = new Chop();

    @Test
    void emptyHaystack_returnsMinus1() {
        checkKarateChop(-1, 1, [])
    }

    @Test
    void haystack_withNeedleToLeft_returnsMinus1() {
        checkKarateChop(-1, 1, [2])
    }

    @Test
    void haystack_withNeedleToRight_returnsMinus1() {
        checkKarateChop(-1, 3, [2])
    }

    @Test
    void haystack_withNeedleInMiddle_returnsMinus1() {
        checkKarateChop(-1, 3, [2, 4])
    }

    @Test
    void haystack_withoutNeedle_returnsMinus1() {
        checkKarateChop(-1, 1, [2])
    }

    @Test
    void haystackOfOne_withNeedle_returns0() {
        checkKarateChop(0, 1, [1])
    }

    @Test
    void haystackOfTwo_withNeedleFirst_returns0() {
        checkKarateChop(0, 1, [1, 2])
    }

    @Test
    void haystackOfTwo_withNeedleLast_returnsLengthMinus1() {
        checkKarateChop(0, 1, [1, 2])
        checkKarateChop(2, 3, [1, 2, 3])
    }

    @Test
    void haystackOfOddNumber_withNeedleMiddle_returnsOffset() {
        checkKarateChop(1, 2, [1, 2, 3])
    }

    @Test
    void largish_haystack_withOddNUmberOfStraws_works() {
        def haystack = [1, 2, 3, 4, 5]
        checkKarateChop(-1, 0, haystack)
        checkKarateChop(0, 1, haystack)
        checkKarateChop(1, 2, haystack)
        checkKarateChop(2, 3, haystack)
        checkKarateChop(3, 4, haystack)
        checkKarateChop(4, 5, haystack)
    }

    @Test
    void largish_haystack_withEvenNumberOfStraws_works() {
        def haystack = [1, 2, 3, 4, 5, 6]
        checkKarateChop(-1, 0, haystack)
        checkKarateChop(0, 1, haystack)
        checkKarateChop(1, 2, haystack)
        checkKarateChop(2, 3, haystack)
        checkKarateChop(3, 4, haystack)
        checkKarateChop(4, 5, haystack)
        checkKarateChop(5, 6, haystack)
    }

    private void checkKarateChop(int expected, int needle, ArrayList<Integer> haystack) {
        assertEquals(expected, chopper.chop(needle, haystack))
    }

}