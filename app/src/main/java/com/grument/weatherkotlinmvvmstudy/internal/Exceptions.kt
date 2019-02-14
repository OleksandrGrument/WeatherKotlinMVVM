package com.grument.weatherkotlinmvvmstudy.internal

import java.io.IOException
import java.lang.Exception

class NoConnectivityException : IOException()
class LocationPermissionNotGrantedException: Exception()
class DateNotFoundException: Exception()