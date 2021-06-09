# Countdown-Timer
<p>Schedule a countdown until a time in the future, with regular notifications on intervals along the way.</p>

### Defining and configuring a Countdown-Timer Object:
```kotlin
var counter : Long = (time * 1000).toLong()
val countDownTimer = object  : CountDownTimer(counter,1000){
    override fun onTick(millisUntilFinished: Long) {
        time -= 1
        separate(time)
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

