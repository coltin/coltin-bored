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
    ENTJ(listOf(Te, Ni, Se, Fi)),
    ENTP(listOf(Ne, Ti, Fe, Si)),
    ENFJ(listOf(Fe, Ni, Se, Ti)),
    ENFP(listOf(Ne, Fi, Te, Si)),
    ESTJ(listOf(Te, Si, Ne, Fi)),
    ESTP(listOf(Se, Ti, Fe, Ni)),
    ESFJ(listOf(Fe, Si, Ne, Ti)),
    ESFP(listOf(Se, Fi, Te, Ni));

    val unconscious get() = valueOf(invertLetter(name[0]) + name[1] + name[2] + invertLetter(name[3]))
    fun nemesis() = functions[0].invert()
    fun critic() = functions[1].invert()
    fun trickster() = functions[2].invert()
    fun demon() = functions[3].invert()

    val subconscious get() = valueOf(invertLetter(name[0]) + invertLetter(name[1]) + invertLetter(name[2]) + invertLetter(name[3]))
    fun physics() = functions[3]
    fun morality() = functions[2]
    fun rationale() = functions[1]
    fun willpower() = functions[0]

    val superego get() = valueOf(name[0] + invertLetter(name[1]) + invertLetter(name[2]) + name[3])
    fun duty() = functions[3].invert()
    fun ethics() = functions[2].invert()
    fun logic() = functions[1].invert()
    fun metaphysics() = functions[0].invert()

    private fun invertLetter(letter: Char) = when (letter) {
        'I' -> "E"
        'E' -> "I"
        'N' -> "S"
        'S' -> "N"
        'T' -> "F"
        'F' -> "T"
        'J' -> "P"
        'P' -> "T"
        else -> ""
    }

    fun egoFunctions() =
            StringBuilder()
                    .append("Ego - ").append(name)
                    .append("\n\tHero \t\t").append(functions[0].name)
                    .append("\n\tParent \t\t").append(functions[1].name)
                    .append("\n\tChild \t\t").append(functions[2].name)
                    .append("\n\tInferior \t").append(functions[3].name)
                    .append("\n\t  / Aspirational")
                    .toString()

    fun unconciousFunctions() = unconscious.let {
        StringBuilder()
                .append("Unconscious - ").append(it.name)
                .append("\n\tNemesis \t").append(it.functions[0].name)
                .append("\n\tCritic \t\t").append(it.functions[1].name)
                .append("\n\tTrickster \t").append(it.functions[2].name)
                .append("\n\tDemon \t\t").append(it.functions[3].name)
                .toString()
    }

    fun subconciousFunctions() = subconscious.let {
        StringBuilder()
                .append("Subconscious - ").append(it.name)
                .append("\n\tPhysics \t").append(it.functions[0].name)
                .append("\n\tMorality \t").append(it.functions[1].name)
                .append("\n\tRationale \t").append(it.functions[2].name)
                .append("\n\tWillpower \t").append(it.functions[3].name)
                .toString()
    }

    fun superegoFunctions() = superego.let {
        StringBuilder()
                .append("Superego - ").append(it.name)
                .append("\n\tDuty \t\t").append(it.functions[0].name)
                .append("\n\tEthics \t\t").append(it.functions[1].name)
                .append("\n\tLogic \t\t").append(it.functions[2].name)
                .append("\n\tMetaphysics ").append(it.functions[3].name)
                .toString()
    }
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