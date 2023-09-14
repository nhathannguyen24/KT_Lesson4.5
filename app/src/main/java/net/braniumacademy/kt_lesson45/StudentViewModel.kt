package net.braniumacademy.kt_lesson45

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel() : ViewModel() {
    private val liveDataStudent: MutableLiveData<List<Student>> = MutableLiveData()

    val students: LiveData<List<Student>>
        get() = liveDataStudent

    fun loadData(context: Context?) {
        val parser = JSonParser()
        val jsonString = parser.getJSONFromFile(context!!)
        val studentList = parser.getStudents(jsonString)
        if (studentList != null) {
            liveDataStudent.value = studentList
        }
    }

    companion object {
        var instance: StudentViewModel? = null
            get() {
                if (field == null) {
                    field = StudentViewModel()
                }
                return field
            }
            private set
    }
}