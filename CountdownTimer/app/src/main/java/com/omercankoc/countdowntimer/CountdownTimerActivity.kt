package com.omercankoc.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker

class CountdownTimerActivity : AppCompatActivity() {

    private lateinit var numberPickerHour : NumberPicker
    private lateinit var numberPickerMinute : NumberPicker
    private lateinit var numberPickerSecond : NumberPicker
    private lateinit var buttonCountDownTimer : Button

    private var time : Int = 0
    private var hour : Int = 0
    private var minute : Int = 0
    private var second : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown_timer)

        initialize()

        numberPickerHour.setOnValueChangedListener { _, _, set ->
            hour = set
            time = timer(hour,minute,second)
        }

        numberPickerMinute.setOnValueChangedListener { _, _, set ->
            minute = set
            time = timer(hour,minute,second)
        }

        numberPickerSecond.setOnValueChangedListener { _, _, set ->
            second = set
            time = timer(hour,minute,second)
        }
    }

    private fun initialize(){
        numberPickerHour = findViewById(R.id.numberPickerHour)
        numberPickerHour.minValue = 0
        numberPickerHour.maxValue = 24
        numberPickerHour.value = 0
        numberPickerHour.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        numberPickerMinute = findViewById(R.id.numberPickerMinute)
        numberPickerMinute.minValue = 0
        numberPickerMinute.maxValue = 59
        numberPickerMinute.value = 0
        numberPickerMinute.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        numberPickerSecond = findViewById(R.id.numberPickerSecond)
        numberPickerSecond.minValue = 0
        numberPickerSecond.maxValue = 59
        numberPickerSecond.value = 0
        numberPickerSecond.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        buttonCountDownTimer = findViewById(R.id.buttonCountDownTimer)
    }

    private fun motionTimer(motionTime: Int){

        var second : Int = motionTime
        var minute : Int = second / 60
        second %= 60
        val hour : Int = minute / 60
        minute %= 60
        numberPickerHour.value = hour
        numberPickerMinute.value = minute
        numberPickerSecond.value = second
    }

    private fun timer(hour : Int, minute : Int, second : Int) : Int {
         return (hour * 3600) + (minute * 60) + second
    }

    fun countDownTimer(view : View){

    }
}