package kr.ac.kumoh.ce.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.ce.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var main: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        val res = when (intent.getStringExtra(MainActivity.KEY_NAME)) {
            MainActivity.DOG -> R.drawable.dog
            MainActivity.CAT -> R.drawable.cat
            else -> R.drawable.ic_launcher_foreground
        }
        main.image.setImageResource(res)
    }
}
