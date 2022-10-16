package com.moscow.travel.hack.core.ext

import timber.log.Timber

const val APP_TAG = "RUSSPASSS"

fun Any.log(msg: String?) = Timber.tag(APP_TAG).d(msg.toString())

fun log(msg: String?) = Unit.log(msg)
