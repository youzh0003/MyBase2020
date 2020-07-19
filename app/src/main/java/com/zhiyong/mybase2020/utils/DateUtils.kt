package com.zhiyong.mybase2020.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    const val PATTERN_YYYY_MM_DD_HH_MM_1 = "yyyy/MM/dd HH:mm"
    const val PATTERN_YYYY_MM_DD_HH_MM_2 = "yyyy-MM-dd HH:mm"
    const val PATTERN_MMM_dd_COMMA_YYYY = "MMM dd, yyyy"

    fun formatDateTime(time: Date?, PATTERN: String): String {
        if (time == null) return ""
        val sdf =
            SimpleDateFormat(PATTERN, Locale.getDefault())
        return sdf.format(time)
    }

    fun formatDateTime(time: Long?, PATTERN: String): String {
        if (time == null) return ""
        val sdf =
            SimpleDateFormat(PATTERN, Locale.getDefault())
        return sdf.format(time)
    }

    fun formatDateTimeWithPrefixPattern(
        date: Date?,
        prefix: String,
        PATTERN: String
    ): String {
        var prefix = prefix
        if (date == null) {
            return ""
        }
        prefix =
            if (prefix.isEmpty()) PATTERN else "$prefix $PATTERN"
        return formatDateTime(date, prefix)
    }

    fun formatDateTimeWithPrefixPattern(
        date: Long?,
        prefix: String,
        PATTERN: String
    ): String {
        var prefix = prefix
        if (date == null) {
            return ""
        }
        prefix =
            if (prefix.isEmpty()) PATTERN else "$prefix $PATTERN"
        return formatDateTime(date, prefix)
    }

    val currentTimeMillis: Long
        get() = System.currentTimeMillis()
}