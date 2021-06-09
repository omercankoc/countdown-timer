package com.omercankoc.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import android.os.CountDownTimer as CountDownTimer

class CountdownTimerActivity : AppCompatActivity() {

    private lateinit var numberPickerHour : NumberPicker
    private lateinit var numberPickerMinute : NumberPicker
    private lateinit var numberPickerSecond : NumberPicker
    private lateinit var buttonStart : Button
    private lateinit var buttonStop : Button

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
            time = combineTime(hour,minute,second)
            println("$hour:$minute:$second")
        }

        numberPickerMinute.setOnValueChangedListener { _, _, set ->
            minute = set
            time = combineTime(hour,minute,second)
            println("$hour:$minute:$second")
        }

        numberPickerSecond.setOnValueChangedListener { _, _, set ->
            second = set
            time = combineTime(hour,minute,second)
            println("$hour:$minute:$second")
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
        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
    }

    // Toplam saniye verisini Saat:Dakika:Saniye cinsinen hesapla...
    private fun splitTime(time : Int){

        var second : Int = time
        var minute : Int = second / 60
        second %= 60
        val hour : Int = minute / 60
        minute %= 60
        numberPickerHour.value = hour
        numberPickerMinute.value = minute
        numberPickerSecond.value = second
    }

    // Saat:Dakika:Saniye cinsinden saniye cinsinde toplam sureyi hesapla...
    private fun combineTime(hour : Int, minute : Int, second : Int) : Int {
        return (hour * 3600) + (minute * 60) + second
    }

    fun start(view : View){
        var counter : Long = (time * 1000).toLong()
        val countDownTimer = object  : CountDownTimer(counter,1000){
            override fun onTick(millisUntilFinished: Long) {
                time -= 1
                splitTime(time)
                counter -= 1000
            }

            override fun onFinish() {
                Toast.makeText(applicationContext,"DONE!",Toast.LENGTH_LONG).show()
            }
        }.start()

        buttonStop.setOnClickListener {
            countDownTimer.cancel()
            counter = 0

            time = 0
            hour = 0
            minute = 0
            second = 0

            numberPickerHour.value = 0
            numberPickerMinute.value = 0
            numberPickerSecond.value = 0

        }
    }
}