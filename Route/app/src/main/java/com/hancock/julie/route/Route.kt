package com.hancock.julie.route

class Route {

    private fun List<Int>.sumList(): Int { //O(N)
        if (this.isEmpty()) return 0
        return reduceRight { b, c ->
            b + c
        }
    }

    private fun List<Int>.removeAndReturn(index: Int): List<Int> { //O(N)
        val l = this.toMutableList()
        l.removeAt(index)
        return l
    }


    //all ints >= 0
    //subset size: 1+
    fun subsetSum(a: List<Int>, b: Int): Boolean {
        val sum = a.sumList() //O(N)
        if (sum == b) return true
        if (sum < b) return false

        a.forEachIndexed { index, _ -> //O(N)
            if (subsetSum(a.removeAndReturn(index), b)) return true //O(N)
        }
        return false
    }
}
