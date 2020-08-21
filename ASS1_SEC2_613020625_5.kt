package com.example.labkotlin

fun main(){
    val subjectScore = arrayOf(55, 77, 89, 61, 75)
    println("There are ${subjectScore.size} subject in array.")
    //calGrade(subjectScore)
    CalGPAX(subjectScore)
}
/*
fun calGrade(subjectArr : Array<Int>){
    var i : Int = 1
    var grade : String
    for(value : Int in subjectArr){
        when{
            value < 50 -> grade = "F"
            value < 55 -> grade = "D"
            value < 60 -> grade = "D+"
            value < 65 -> grade = "C"
            value < 70 -> grade = "C+"
            value < 75 -> grade = "B"
            value < 80 -> grade = "B+"
            else -> grade = "A"
        }
        println("Grade of Subject Number $i = $grade")
        i++
    }
}
*/
fun CalGPAX(scoreArr : Array<Int>){
    var i : Int = 1
    var point: Float
    var gradeXcredit: Float
    var sumgradeXcredit: Float = 0.0f
    var gpax: Float
    var calPoint: String
    var showCalPoint: String = ""
    var plus: String = "+"
    for(value: Int in scoreArr) {
        when {
            value < 50 -> println("Grade of Subject Number $i = F : 0.0")
            value < 55 -> println("Grade of Subject Number $i = D : 1.0")
            value < 60 -> println("Grade of Subject Number $i = D+ : 1.5")
            value < 65 -> println("Grade of Subject Number $i = C : 2.0")
            value < 70 -> println("Grade of Subject Number $i = C+ : 2.5")
            value < 75 -> println("Grade of Subject Number $i = B : 3.0")
            value < 80 -> println("Grade of Subject Number $i = B+ : 3.5")
            else -> println("Grade of Subject Number $i = A : 4.0")
        }
        when {
            value < 50 -> point = 0.0f
            value < 55 -> point = 1.0f
            value < 60 -> point = 1.5f
            value < 65 -> point = 2.0f
            value < 70 -> point = 2.5f
            value < 75 -> point = 3.0f
            value < 80 -> point = 3.5f
            else -> point = 4.0f
        }
        i++
        gradeXcredit = point*3
        sumgradeXcredit += gradeXcredit
        if (i > scoreArr.size){
            plus = ""
        }
        calPoint = "($point*3)$plus"
        showCalPoint += calPoint
    }
    gpax = sumgradeXcredit/15
    println("GPAX = ($showCalPoint)/15 = $gpax")
}
