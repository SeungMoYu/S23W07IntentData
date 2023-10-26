package kr.ac.kumoh.ce.s23w07intentdata

import android.app.Activity
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object{
        const val KEY_NAME = "animal"
        const val CAT = "cat"
        const val DOG = "dog"
    }
    private lateinit var main: ActivityMainBinding
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode != Activity.RESULT_OK)
            return@registerForActivityResult

        val result = it.data?.getIntExtra(
            ImageActivity.IMAGE_RESULT,
            ImageActivity.NONE)
        val str = when(result) {
            ImageActivity.LIKE -> "좋아요"
            ImageActivity.DISLIKE -> "싫어요"
            else -> ""
        }
        when(it.data?.getStringExtra(ImageActivity.IMAGE_NAME)) {
            CAT -> main.btnCat.text = "고양이 ($str)"
            DOG -> main.btnDog.text = "강아지 ($str)"
        }
    }

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
        //startActivity(intent)
        startForResult.launch(intent)
    }
}