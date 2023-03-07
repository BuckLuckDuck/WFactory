package com.example.worldfactory.models

data class StudyWord (
    var word: String,
    var phonetic: String,
    var phonetics: ArrayList<PhoneticsModel>,
    var meanings: ArrayList<Meaning>
)

data class PhoneticsModel (
    var audio: String
)

data class Meaning (
    var partOfSpeech: String,
    var definitions: ArrayList<Definition>
)

data class Definition (
    var definition: String,
    var example: String
)
