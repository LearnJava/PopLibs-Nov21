package ru.fylmr.poplibs_nov21.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserModel(
    val login: String
): Parcelable