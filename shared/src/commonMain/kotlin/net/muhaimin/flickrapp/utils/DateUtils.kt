package net.muhaimin.flickrapp.utils

import kotlinx.datetime.*

class DateUtils {

    fun currentDateTime(): String {
        val currentMoment: Instant = Clock.System.now()
        return currentMoment.toLocalDateTime(TimeZone.UTC).toString()
    }
}