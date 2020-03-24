package com.coltin.bored.mbti

import com.coltin.bored.mbti.Functions.*
import org.junit.Test

import org.junit.Assert.*

class FunctionsTest {

    @Test
    fun toString_Ni_CorrectString() = assertEquals("Introverted Intuition", Ni.toString())

    @Test
    fun toString_Fi_CorrectString() = assertEquals("Introverted Feeling", Fi.toString())

    @Test
    fun toString_Se_CorrectString() = assertEquals("Extroverted Sensing", Se.toString())

    @Test
    fun toString_Te_CorrectString() = assertEquals("Extroverted Thinking", Te.toString())
}