package net.braniumacademy.kt_lesson45

import android.content.Context
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer
import java.nio.charset.StandardCharsets

class JSonParser {
    // Đọc file JSON trả về String
    fun getJSONFromFile(context: Context): String {
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            context.resources.openRawResource(R.raw.student).use { inputStream ->
                val reader: Reader = BufferedReader(
                    InputStreamReader(inputStream, StandardCharsets.UTF_8)
                )
                var size: Int
                while (reader.read(buffer).also { size = it } != -1) {
                    writer.write(buffer, 0, size)
                }
            }
        } catch (ignored: IOException) {
        }
        return writer.toString()
    }

    fun getStudents(jsonString: String): List<Student>? {
        val mapper = jacksonObjectMapper()
        return try {
            return mapper.readValue<List<Student>>(jsonString)
        } catch (ignored: JsonParseException) {
            null
        }
    }
}