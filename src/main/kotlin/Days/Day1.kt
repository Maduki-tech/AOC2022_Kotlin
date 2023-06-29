package Days

import java.io.File

/**
 * Day 1: Calorie Counting
 * https://adventofcode.com/2022/day/1
 */
fun day1() {
    // Read the File
    val file = File("src/main/resources/day1.txt")
    val input = file.readLines()

    // split list at empty line
    val lists = input.fold(mutableListOf(mutableListOf<Int>())) { acc, s ->
        if (s.isBlank()) {
            acc.add(mutableListOf())
        } else {
            acc.last().add(s.toInt())
        }
        acc
    }

    val listOfMaxValues = mutableListOf<Int>()
    for (list in lists) {
        val sum = list.sum()
        listOfMaxValues.add(sum)
    }
    println("Sum of Max KCal: ${listOfMaxValues.maxOrNull()}")

    // get last 3 max values
    val listOfThreeMaxValues = mutableListOf<Int>()
    for (i in 0..2) {
        val max = listOfMaxValues.maxOrNull()
        listOfThreeMaxValues.add(max!!)
        listOfMaxValues.remove(max)
    }
    println("Sum of Max KCal of best 3: ${listOfThreeMaxValues.sum()}")
}
