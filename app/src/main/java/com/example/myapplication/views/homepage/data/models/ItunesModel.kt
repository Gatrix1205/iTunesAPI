package com.example.myapplication.views.homepage.data.models

import com.google.gson.annotations.SerializedName

data class ItunesModel (

    @SerializedName("resultCount" ) var resultCount : Int?               = null,
    @SerializedName("results"     ) var results     : ArrayList<Results> = arrayListOf()

)

data class Results (

    @SerializedName("genreIds"          ) var genreIds          : ArrayList<String> = arrayListOf(),
    @SerializedName("releaseDate"       ) var releaseDate       : String?           = null,
    @SerializedName("trackId"           ) var trackId           : Long?              = null,
    @SerializedName("trackName"         ) var trackName         : String?           = null,
    @SerializedName("artistIds"         ) var artistIds         : ArrayList<Int>    = arrayListOf(),
    @SerializedName("kind"              ) var kind              : String?           = null,
    @SerializedName("currency"          ) var currency          : String?           = null,
    @SerializedName("description"       ) var description       : String?           = null,
    @SerializedName("artworkUrl60"      ) var artworkUrl60      : String?           = null,
    @SerializedName("artworkUrl100"     ) var artworkUrl100     : String?           = null,
    @SerializedName("artistViewUrl"     ) var artistViewUrl     : String?           = null,
    @SerializedName("trackCensoredName" ) var trackCensoredName : String?           = null,
    @SerializedName("fileSizeBytes"     ) var fileSizeBytes     : Int?              = null,
    @SerializedName("formattedPrice"    ) var formattedPrice    : String?           = null,
    @SerializedName("trackViewUrl"      ) var trackViewUrl      : String?           = null,
    @SerializedName("artistId"          ) var artistId          : Int?              = null,
    @SerializedName("artistName"        ) var artistName        : String?           = null,
    @SerializedName("genres"            ) var genres            : ArrayList<String> = arrayListOf(),
    @SerializedName("price"             ) var price             : Double?           = null,
    @SerializedName("userRatingCount"   ) var userRatingCount   : Int?              = null,
    @SerializedName("averageUserRating" ) var averageUserRating : Int?              = null

)