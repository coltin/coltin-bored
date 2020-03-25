package com.coltin.bored

import com.coltin.bored.mbti.Mbti
import com.coltin.bored.mbti.Mbti.INTJ

class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            for (mbti in Mbti.values()) {
                println("================================")
                println(mbti.egoFunctions())
                println(mbti.unconciousFunctions())
                println(mbti.subconciousFunctions())
                println(mbti.superegoFunctions())
            }
        }
    }

}
