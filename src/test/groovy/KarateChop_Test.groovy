import org.junit.Test

import static org.junit.Assert.assertEquals

import org.adscale.KarateChop1.Chop

class KarateChop_Test {

    def chopper = new Chop();


    private final int NOT_FOUND = -1


    @Test
    void emptyHaystack_returnsMinus1() {
        checkKarateChop(NOT_FOUND, 1, [])
    }


    @Test
    void haystack_withNeedleToLeft_returnsMinus1() {
        checkKarateChop(NOT_FOUND, 1, [2])
    }


    @Test
    void haystack_withNeedleToRight_returnsMinus1() {
        checkKarateChop(NOT_FOUND, 3, [2])
    }


    @Test
    void haystack_withNeedleInMiddle_returnsMinus1() {
        checkKarateChop(NOT_FOUND, 3, [2, 4])
    }


    @Test
    void haystack_withoutNeedle_returnsMinus1() {
        checkKarateChop(NOT_FOUND, 1, [2])
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
        checkKarateChop(NOT_FOUND, 0, haystack)
        checkKarateChop(0, 1, haystack)
        checkKarateChop(1, 2, haystack)
        checkKarateChop(2, 3, haystack)
        checkKarateChop(3, 4, haystack)
        checkKarateChop(4, 5, haystack)
    }


    @Test
    void largish_haystack_withEvenNumberOfStraws_works() {
        def haystack = [1, 2, 3, 4, 5, 6]
        checkKarateChop(NOT_FOUND, 0, haystack)
        checkKarateChop(0, 1, haystack)
        checkKarateChop(1, 2, haystack)
        checkKarateChop(2, 3, haystack)
        checkKarateChop(3, 4, haystack)
        checkKarateChop(4, 5, haystack)
        checkKarateChop(5, 6, haystack)
    }


    @Test
    public void unfound_needles_odd_numbered_haystack() throws Exception {
        checkKarateChop("unknown needle to right", NOT_FOUND, 7, [1, 2, 4, 5, 6])
        checkKarateChop("unknown needle to left", NOT_FOUND, -1, [1, 2, 3, 4, 5, 6])
        checkKarateChop("unknown needle to right", NOT_FOUND, 0, [1, 2, 4, 5, 6])
        checkKarateChop("unknown needle in middle", NOT_FOUND, 3, [1, 2, 4, 5, 6])
    }


    @Test
    public void unfound_needles_even_numbered_haystack() throws Exception {
        def haystack = [1, 2, 4, 5, 6, 7]
        checkKarateChop("unknown needle to right", NOT_FOUND, 8, haystack)
        checkKarateChop("unknown needle to left", NOT_FOUND, -1, haystack)
        checkKarateChop("unknown needle to right", NOT_FOUND, 0, haystack)
    }


    private void checkKarateChop(int expected, int needle, ArrayList<Integer> haystack) {
        checkKarateChop("", expected, needle, haystack)
    }


    private void checkKarateChop(String errorMessage, int expected, int needle, ArrayList<Integer> haystack) {
        assertEquals(errorMessage, expected, chopper.chop(needle, haystack))
    }

}