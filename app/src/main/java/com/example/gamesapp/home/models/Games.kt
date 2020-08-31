package com.example.gamesapp.home.models

import android.os.Parcelable
import android.text.TextUtils
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize
data class Games(var games: List<Game>?) : Parcelable

@Parcelize
class Game:Parcelable  {
    var gameId: String? = null
    var title: String? = null
    var gameLogoImage: List<GameLogoImage>? = null
    var gameLoadImage: List<GameLogoImage>? = null
    var winAmount: Int? = null
    var wonbyCount: Int? = null
    var gameType: String? = null
    var gameUrl: String? = null
    var screenOrientation: String? = null
    var genres: Set<Genres>? = null
    var parameters: String? = null

    val thumbnailImage: String?
        get() = if (gameLogoImage!= null && gameLogoImage!!.size>0) {
            gameLogoImage!!.get(0).url
        } else null

    val backgroundImage: String?
        get() {
            return if (gameLogoImage!= null && gameLogoImage!!.size>0) {
                gameLogoImage!!.get(0).url
            } else null
        }

    override fun toString(): String {
        return gameId.toString()
    }
}

class GameLogoImage : Serializable {
    var density: String? = null
    var width = 0
    var type: String? = null
    var url: String? = null
    var height = 0
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}

class Genres(var id: String, var name: String) : Serializable {

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Genres

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }


}