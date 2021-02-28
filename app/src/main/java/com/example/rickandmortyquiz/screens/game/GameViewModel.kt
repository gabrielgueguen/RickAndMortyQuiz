package com.example.rickandmortyquiz.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyquiz.R

/*
Author: Gabriel Gueguen
 Title: Rick and Morty quiz GameViewModel
  Date: 2021-02-27
 */

class GameViewModel : ViewModel() {
    //list of questions and set initial index
    private var questionIndex = 0
    private lateinit var questionList: MutableList<Question>

    //game over string to be sent to game over screen
    private val _scoreText = MutableLiveData<String>()
    val scoreText: LiveData<String>
        get() = _scoreText

    //current question elements
    private val _question = MutableLiveData<Int>()
    val question: LiveData<Int>
        get() = _question

    private val _answer = MutableLiveData<Boolean>()
    val answer: LiveData<Boolean>
        get() = _answer

    private val _answered = MutableLiveData<Boolean>()
    val answered: LiveData<Boolean>
        get() = _answered

    private val _attempted = MutableLiveData<Boolean>()
    val attempted: LiveData<Boolean>
        get() = _attempted

    private val _isCorrect = MutableLiveData<Boolean>()
    val isCorrect: LiveData<Boolean>
        get() = _isCorrect

    //game end event
    private val _eventGameOver = MutableLiveData<Boolean>()
    val eventGameOver: LiveData<Boolean>
        get() = _eventGameOver

    //initialize by creating a list of questions and set initial question
    init{
        resetQuestionList()
        getCurrentQuestion()
    }

    /**
     * Navigate to next question, or return to first if on last
     */
    fun nextQuestion() {
        if (questionIndex < questionList.size - 1) //increment question number
            questionIndex++
        else //loop back to first question in list if at end of list
            questionIndex = 0
        getCurrentQuestion()
    }

    /**
     * Navigate to prev question, or go to end of list if on first
     */
    fun prevQuestion() {
        if (questionIndex > 0) //decrement question number
            questionIndex--
        else //loop back to last question in list if at beginning of list
            questionIndex = questionList.size - 1
        getCurrentQuestion()
    }

    private fun getCurrentQuestion(){
        _question.value = questionList[questionIndex].questionID
        _answer.value = questionList[questionIndex].answer
        _answered.value = questionList[questionIndex].answered
        _attempted.value = questionList[questionIndex].attempted
        _isCorrect.value = questionList[questionIndex].isCorrect
    }

    /**
     * update question in list, triggers game over if all questions have been answered
     */
    fun updateQuestion(answer: Boolean) {
        if (answer == _answer.value)
            questionList[questionIndex].isCorrect = true
        //mark as attempted and set which answer was chosen
        questionList[questionIndex].answered = answer
        questionList[questionIndex].attempted = true

        //scoreText update
        _scoreText.value = "Your Score: ${questionList.count{it.isCorrect}}/${questionList.size}"

        //if all are answered, trigger game over event, else get the updated info
        if (questionList.count { it.attempted } == questionList.size)
            onGameEnd()
        else
            getCurrentQuestion()
    }

    /**
     * Set or reset the questions list (shuffled)
     */
    private fun resetQuestionList() {
        questionList = mutableListOf(
            Question(R.string.question_1, false),
            Question(R.string.question_2, true),
            Question(R.string.question_3, true),
            Question(R.string.question_4, false),
            Question(R.string.question_5, false),
            Question(R.string.question_6, true),
            Question(R.string.question_7, false),
            Question(R.string.question_8, true),
            Question(R.string.question_9, false),
            Question(R.string.question_10, false),
            Question(R.string.question_11, false),
            Question(R.string.question_12, true),
            Question(R.string.question_13, false),
            Question(R.string.question_14, true),
            Question(R.string.question_15, false),
            Question(R.string.question_16, false),
            Question(R.string.question_17, true),
            Question(R.string.question_18, false),
            Question(R.string.question_19, false),
            Question(R.string.question_20, true)
        )
        //shuffle list
        questionList.shuffle()
    }

    /**
     * End the game
     */
    private fun onGameEnd() {
        //fire gameOver event
        _eventGameOver.value = true
    }

    /**
     * Complete the game over event
     */
    fun onGameEndCompleted() {
        //reset questions list, score text, and game over event
        resetQuestionList()
        getCurrentQuestion()
        _scoreText.value = ""
        _eventGameOver.value = false
    }
}