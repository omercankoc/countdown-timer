## Countdown-Timer
<p>Schedule a countdown until a time in the future, with regular notifications on intervals along the way.</p>

### Defining and configuring a Countdown-Timer Object:
```kotlin
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
```

<p>onTick(milisUntilFinished : Long) -> while the countdown continues...</p>
<p>onFinish() -> when the countdown is over.</p>

### To stop the Countdown-Timer:
```kotlin
countDownTimer.cancel()
counter = 0
time = 0
hour = 0
minute = 0
second = 0
```

### Calculate Second from HH:MM:SS:
```kotlin
private fun combineTime(hour : Int, minute : Int, second : Int) : Int {
    return (hour * 3600) + (minute * 60) + second
}
```

### Calculate HH:MM:SS from Second:
```kotlin
private fun splitTime(time : Int) {
    var second : Int = time
    var minute : Int = second / 60
    second %= 60
    val hour : Int = minute / 60
    minute %= 60
}
```
