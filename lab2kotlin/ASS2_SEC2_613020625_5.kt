package com.example.labkotlin.lab2kotlin

data class Subject(val id: String, val name: String, val credit: Int)
open class Person(fName: String, lName: String, deptName: String){
    val firstName: String = fName.capitalize()
    val lastName: String = lName.capitalize()
    protected val department: String = "$deptName, Faculty of Science."
    open fun showDetail(){
        println("$firstName is at $department")
    }
    companion object{
        fun showCompanion(first_Name: String, last_Name: String, age: Int){
            println("Person is called from companion object : $first_Name $last_Name is $age years old.")
        }
    }
}
class Teacher(fName: String, lName: String, deptName: String, year: Int):Person(fName, lName, deptName){
    private var salary: Int = 0
    private val yearClass: Int = year
    private var creditClass: Int = 0
    override fun showDetail() {
        println("$firstName is a teacher for $yearClass years at $department.")
    }
    fun calSalary(){
        salary = when{
            yearClass < 5 -> 25000 + (2000 * yearClass)
            yearClass < 10 -> 36000 + (2000 * (yearClass - 5))
            yearClass < 15 -> 47000 + (2000 * (yearClass - 10))
            yearClass < 20 -> 58000 + (2000 * (yearClass - 15))
            else -> 60000 + (2000 * (yearClass - 20))
        }
        println("$firstName's salary is $salary bath")
    }
    fun teach(subj: Subject){
        println(subj.toString())
        this.creditClass += subj.credit
    }
    fun displayCredit(){
        println("$firstName teaches $creditClass credits.")
    }
}
object Singleton_Person{
    val first_Name = "Carlos"
    val last_Name = "silva"
    var age = 23
    fun showCompanion(){
        println("Person is calles from singleton object : $first_Name $last_Name is $age years old.")
    }
}
class Student(firstName: String, lastName: String, department: String) : Person(firstName, lastName, department){
    var creditClass: Float = 0F
    var gradeValue: Float = 0F
    override fun showDetail() {
        println("$firstName is a student at $department")
    }
    fun gradeEnroll(subj: Subject, score: Int){
        this.creditClass += subj.credit
        this.gradeValue += when (score){
            in 80..100 -> {
                println(" Score : $score Grade : A")
                (subj.credit * 4).toFloat()
            }
            in 75..79 -> {
                println(" Score : $score Grade : B+")
                (subj.credit * 3.5).toFloat()
            }
            in 70..74 -> {
                println(" Score : $score Grade : B")
                (subj.credit * 3.0).toFloat()
            }
            in 65..69 -> {
                println(" Score : $score Grade : C+")
                (subj.credit * 2.5).toFloat()
            }
            in 60..64 -> {
                println(" Score : $score Grade : C")
                (subj.credit * 2.0).toFloat()
            }
            in 55..59 -> {
                println(" Score : $score Grade : D+")
                (subj.credit * 1.5).toFloat()
            }
            in 50..54 -> {
                println(" Score : $score Grade : D")
                (subj.credit * 1.0).toFloat()
            }
            else -> {
                println(" Score : $score Grade : F")
                0F
            }
        }
    }
    fun displayGPA(){
        println("$firstName's GPA is ${String.format("%.2f",gradeValue/creditClass)}")
    }
}
fun main(){
    var subject1 = Subject("342267", "Mobile Device Programming", 3)
    var subject2 = Subject("342233", "Database", 3)
    var subject3 = Subject("342233", "Seminar in Information Technology", 1)
    var person3 = Student("Nattasit", "Pattane", "Information Technology")
    println("Member NO 5 : ${person3.firstName} ${person3.lastName}")
    person3.showDetail()
    print(subject1)
    person3.gradeEnroll(subject1, 74)
    print(subject2)
    person3.gradeEnroll(subject2, 89)
    print(subject3)
    person3.gradeEnroll(subject3, 57)
    person3.displayGPA()
}