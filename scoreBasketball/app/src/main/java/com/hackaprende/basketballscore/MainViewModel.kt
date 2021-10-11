package com.hackaprende.basketballscore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

     var localScore: MutableLiveData<Int> = MutableLiveData()
     var visitorScore: MutableLiveData<Int> = MutableLiveData()

    init {
        resetScores()
    }

    fun resetScores() {
        localScore.value = 0
        visitorScore.value = 0

    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            localScore.value = localScore.value!! + points

        } else {
            visitorScore.value  = visitorScore.value!! +  points

        }
    }

    fun decreaseLocalScore(){
        if(localScore.value!! > 0){
            localScore.value =  localScore.value!! - 1
        }
    }

    fun decreaseVisitorScore(){
        if(visitorScore.value!! > 0){
            visitorScore.value =  visitorScore.value!! -1
        }
    }

}