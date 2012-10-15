package org.adscale.KarateChop1

/**
 * Copyright AdScale GmbH, Germany, 2007
 */
class Chop {

    int chop(int needle, List<Integer> haystack) {
        if (haystack.isEmpty()) {
            return -1
        }
        if (haystack[0] > needle) {
            return -1
        }
        if (haystack[haystack.size()-1] < needle) {
            return -1
        }
        if (haystack[0] == needle) {
            return 0
        }
        if (haystack[haystack.size() - 1] == needle) {
            return haystack.size() - 1
        }
        if (haystack.size() <= 2) {
            return -1
        }
        int middle = haystack.size() / 2
        if (haystack[middle] == needle) {
            return middle
        }
        if (notAtEitherEnd(middle, haystack)) {
            return haystack[middle]
        }
        if (needle < haystack[middle]) {
            return chop(needle, haystack.subList(0, middle))
        }
        else {
            return middle + chop(needle, haystack.subList(middle, haystack.size()))
        }
    }


    private boolean notAtEitherEnd(int middle, List<Integer> haystack) {
        middle == 0 || middle == haystack.size() - 1
    }
}
