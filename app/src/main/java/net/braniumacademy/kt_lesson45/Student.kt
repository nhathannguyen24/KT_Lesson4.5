package net.braniumacademy.kt_lesson45

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Student(
    @JsonProperty("id") var studentId: String?,
    @JsonProperty("address") var address: String?,
    @JsonProperty("gender") var gender: String?,
    @JsonProperty("email") var email: String?,
    @JsonProperty("major") var major: String?,
    @JsonProperty("gpa") var gpa: Float = 0f,
    @JsonProperty("year") var year: Int = 1,
    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utils.DATE_FORMAT)
    var birthDate: Date?
) {
    private var fullName: FullName? = null

    @JsonProperty("full_name")
    private fun unpackFullName(fullName: Map<String, Any>) {
        this.fullName = FullName(
            fullName["first"].toString(),
            fullName["last"].toString(),
            fullName["midd"].toString()
        )
    }

    fun getFullName(): String {
        return (fullName!!.lastName + " " + fullName!!.middName + " " + fullName!!.firstName)
    }

    override fun hashCode(): Int {
        return studentId?.hashCode() ?: 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (studentId != other.studentId) return false

        return true
    }


    internal data class FullName(
        @JsonProperty("first") var firstName: String?,
        @JsonProperty("last") var lastName: String?,
        @JsonProperty("midd") var middName: String?
    )
}