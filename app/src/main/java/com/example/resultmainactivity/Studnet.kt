package com.example.resultmainactivity

import java.io.Serializable

class Studnet : Serializable {
    private val serialVersionUID = 1L
    var name = "未命名"
    var eng = -1
    var math = -1

    constructor(name: String, eng: Int, math: Int) {

        this.name = name
        this.eng = eng
        this.math = math
    }

    override fun toString(): String {
        return "Student(name='$name', eng=$eng, math=$math)"
    }
}
