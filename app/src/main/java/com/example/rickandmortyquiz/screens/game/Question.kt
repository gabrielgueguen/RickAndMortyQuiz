package com.example.rickandmortyquiz.screens.game

/*
Author: Gabriel Gueguen
 Title: Question data class for rick and morty quiz GameViewModel
  Date: 2021-02-27
 */

data class Question(
    val questionID: Int,
    val answer: Boolean,
    var answered: Boolean = false,
    var attempted: Boolean = false,
    var isCorrect: Boolean = false
)