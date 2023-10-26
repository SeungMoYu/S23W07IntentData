package kr.ac.kumoh.ce.s23w07intentdata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kr.ac.kumoh.ce.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object{
        const val KEY_NAME = "animal"
        const val CAT = "cat"
        const val DOG = "dog"
    }
    private lateinit var main: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnDog.setOnClickListener(this)
        main.btnCat.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ImageActivity::class.java)
        val value = when (v?.id) {
            main.btnDog.id -> {
                Toast.makeText(this, "강아지 사진", Toast.LENGTH_SHORT).show()
                DOG
            }
            main.btnCat.id ->{
                Toast.makeText(this, "고양이 사진", Toast.LENGTH_SHORT).show()
                CAT
            }
            else -> return
        }
        intent.putExtra(KEY_NAME, value)
        startActivity(intent)
    }
}