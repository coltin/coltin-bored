package com.coltin.bored.mbti

import com.coltin.bored.mbti.Functions.*

enum class Mbti(val functions: List<Functions>) {
    INTJ(listOf(Ni, Te, Fi, Se)),
    INTP(listOf(Ti, Ne, Si, Fe)),
    INFJ(listOf(Ni, Fe, Ti, Se)),
    INFP(listOf(Fi, Ne, Si, Te)),
    ISTJ(listOf(Si, Te, Fi, Ne)),
    ISTP(listOf(Ti, Se, Ni, Fe)),
    ISFJ(listOf(Si, Fe, Ti, Ne)),
    ISFP(listOf(Fi, Se, Ni, Te)),
    ENTJ(listOf(Ne, Ti, Fe, Si)),
    ENTP(listOf(Te, Ni, Se, Fi)),
    ENFJ(listOf(Ne, Fi, Te, Si)),
    ENFP(listOf(Fe, Ni, Se, Ti)),
    ESTJ(listOf(Se, Ti, Fe, Ni)),
    ESTP(listOf(Te, Si, Ne, Fi)),
    ESFJ(listOf(Se, Fi, Te, Ni)),
    ESFP(listOf(Fe, Si, Ne, Ti));

    fun functions() =
            StringBuilder()
                    .append("Ego - ").append(name).append("\n")
                    .append("\tHero: ").append(functions[0].name).append(" ").append(functions[0]).append("\n")
                    .append("\tParent: ").append(functions[1].name).append(" ").append(functions[1]).append("\n")
                    .append("\tChild: ").append(functions[2].name).append(" ").append(functions[2]).append("\n")
                    .append("\tInferior: ").append(functions[3].name).append(" ").append(functions[3]).append("\n")
                    .append("\t  / Aspirational")
                    .toString()

    // Unconscious
    fun nemesis() = functions[0].invert()
    fun critic() = functions[1].invert()
    fun trickster() = functions[2].invert()
    fun demon() = functions[3].invert()

    // Subconscious
    fun physics() = functions[3]
    fun morality() = functions[2]
    fun rationale() = functions[1]
    fun willpower() = functions[0]

    // Superego
    fun duty() = functions[3].invert()
    fun ethics() = functions[2].invert()
    fun logic() = functions[1].invert()
    fun metaphysics() = functions[0].invert()
}

enum class Functions {
    Ni, Ne,
    Ti, Te,
    Fi, Fe,
    Si, Se;

    override fun toString(): String {
        return (if (name[1] == 'i') "Introverted " else "Extroverted ") +
                when (name[0]) {
                    'N' -> "Intuition"
                    'T' -> "Thinking"
                    'F' -> "Feeling"
                    else -> "Sensing"
                }
    }

    fun invert() = valueOf(name[0] + if (name[1] == 'i') "e" else "i")
}