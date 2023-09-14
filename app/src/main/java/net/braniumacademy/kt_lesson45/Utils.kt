package net.braniumacademy.kt_lesson45

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable

object Utils {
    @SuppressLint("UseCompatLoadingForDrawables")
    fun getDrawable(context: Context, gender: String?): Drawable? {
        val target = "nam";
        return if (gender?.lowercase()?.compareTo(target) == 0) {
            context.resources.getDrawable(R.drawable.ic_man_24)
        } else {
            context.resources.getDrawable(R.drawable.ic_woman_24)
        }
    }

    const val DATE_FORMAT = "dd/MM/yyyy"
}