package com.example.bitteapptestv1

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.bitteapptestv1.databinding.ActivityTextBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. 직접 소스로 레이아웃 선언 시
//        var name = TextView(this).apply {
//            typeface = Typeface.DEFAULT
//            text = "히히히 테스트 1"
//            text ="ghghghghj"
//        }
//
//        // apply 함수 호출임 람다 함수
//        var title = TextView(this).apply {
//            typeface = Typeface.DEFAULT_BOLD
//            text = "출력합니다."
//        }
//
//        var layout = LinearLayout(this).apply {
//
//            orientation = LinearLayout.VERTICAL
//            gravity = Gravity.CENTER
//
//            addView(name)
//            addView(title)
//        }
//
//        // 레이아웃 화면 출력
//        setContentView(layout)

        // xml 레이아웃 화면 출력
        //  setContentView(R.layout.activity_main)

        // 레이아웃 바인딩
        val binding = ActivityTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 레이아웃 버튼 바인딩
        binding.button1.setOnClickListener {
            binding.button2.visibility = View.VISIBLE
            binding.text1.text = "텍스트 바뀌쥬?"
        }

        // 레이아웃 버튼 바인딩
        binding.button2.setOnClickListener {
            binding.button2.visibility = View.INVISIBLE
        }

        // 체크박스
        binding.checkbox1.setOnCheckedChangeListener(MyEventHandler())
    }

    class MyEventHandler: CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            Log.d("체크박스", "체크박스 클릭")
        }
    }


    // 터치 이벤트
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("test", "다운 x: ${event.x}, y: ${event.y} rawX: ${event.rawX} rawY: ${event.rawY}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("test", "업")
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> Log.d("키 이벤트", "뒤로가기 키")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("키 이벤트", "볼륨 업 키")
            KeyEvent.KEYCODE_VOLUME_DOWN-> Log.d("키 이벤트", "볼룸 다운 키")
            KeyEvent.KEYCODE_HOME -> Log.d("키 이벤트", "홈 키")
            KeyEvent.KEYCODE_MENU -> Log.d("키 이벤트", "옵션 키")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        Log.d("백키 이벤트", "뒤로가기 키")
        super.onBackPressed()
    }
}