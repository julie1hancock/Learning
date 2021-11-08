package com.hancock.julie.route

import org.junit.Assert.*
import org.junit.Test

class RouteTest {

    @Test
    fun test(){
        assertTrue(Route().subsetSum(mutableListOf(1,3,5), 6))
        assertFalse(Route().subsetSum(mutableListOf(1,3,5), 7))
        assertTrue(Route().subsetSum(mutableListOf(1,3,5), 9))
        assertTrue(Route().subsetSum(mutableListOf(1,2,3,2,5), 9))
        assertTrue(Route().subsetSum(mutableListOf(3), 3))
        assertTrue(Route().subsetSum(mutableListOf(), 0))

    }
}