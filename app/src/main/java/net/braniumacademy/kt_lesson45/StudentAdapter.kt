package net.braniumacademy.kt_lesson45

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val context: Context,
    private val students: MutableList<Student>
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageAvartar: ImageView
        var textId: TextView
        var textFullName: TextView
        var textGpa: TextView

        init {
            imageAvartar = itemView.findViewById(R.id.img_avartar)
            textGpa = itemView.findViewById(R.id.text_gpa)
            textId = itemView.findViewById(R.id.text_student_id)
            textFullName = itemView.findViewById(R.id.text_full_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.textId.text = student.studentId
        holder.textGpa.text = student.gpa.toString()
        holder.textFullName.text = student.getFullName()
        holder.imageAvartar.setImageDrawable(
            Utils.getDrawable(context, student.gender)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setStudents(students: List<Student>?) {
        this.students.clear()
        this.students.addAll(students!!)
        notifyDataSetChanged()
    }
}