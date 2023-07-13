package com.example.bitteapptestv1

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bitteapptestv1.databinding.ActivityNoticeBinding
import java.util.concurrent.atomic.AtomicReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //인트로 레이아웃 반영
//        val binding = ActivityIntroBinding.inflate(layoutInflater)
//        setContentView(binding.root)

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
      /*  val binding = ActivityTextBinding.inflate(layoutInflater)
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
        binding.checkbox1.setOnCheckedChangeListener(MyEventHandler())*/
//
//        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
//
//        if (status === PackageManager.PERMISSION_GRANTED) {
//            Log.d("퍼미션 테스트" , "허용")
//        } else {
//            Log.d("퍼미션 테스트" , "거부")
//        }
//
//        // 권한 런쳐 오픈
//        val requestPermissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestPermission()
//        ){
//            isGranted -> if (isGranted) {
//            Log.d("퍼미션 런쳐" , "허용")
//            } else {
//            Log.d("퍼미션 런쳐" , "거부")
//            }
//        }
//
//        requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")


        // 토스트 아이템 선언
//        val toast = Toast.makeText(this, "토스트 오픈!", Toast.LENGTH_LONG)
//
//        // 토스트 오픈
//        binding.buttonShowToast.setOnClickListener {
//            toast.show()
//        }



        // api 호환성 고려 어노테이션 (레벨 30버전)
        // @RequiresApi(Build.VERSION_CODES.R)
//        fun toastHandler () {
//            val toast = Toast.makeText(this, "토스트 이벤트 핸들러!", Toast.LENGTH_LONG)
//            // api 버전이 33 버전 이상일 경우
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                toast.addCallback(
//                    object : Toast.Callback() {
//                        override fun onToastHidden() {
//                            Log.d("토스트 이벤트 핸들러" , "토스트가 사라질 경우")
//                            super.onToastHidden()
//                        }
//                        override fun onToastShown() {
//                            Log.d("토스트 이벤트 핸들러" , "토스트가 생성될 경우")
//                            super.onToastShown()
//                        }
//                    }
//                )
//            }
//                toast.show()
//        }


        // 토스트 이벤트 오픈
//        binding.buttonShowToast.setOnClickListener {
//            toastHandler()
//        }
          // datePicker
//        val binding = ActivityDateBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        var dateLabel =""
//
//        fun datePiker () {
//            val calendar = Calendar.getInstance() // 캘린더 오픈
//            val datePicker = DatePickerDialog.OnDateSetListener { picker, year, month, day ->
//                dateLabel = "${year}년 ${month+1}월 ${day}일"
//                binding.dateLabel.text = dateLabel
//            }
//            DatePickerDialog(this, datePicker, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
//        }
//
//        binding.showCalender.setOnClickListener {
//            datePiker()
//        }
          // timePicker
//        val binding = ActivityTimeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        var timeLabel =""
//
//        fun timePiker () {
//            val calendar = Calendar.getInstance() // 캘린더 오픈
//            val timePicker = TimePickerDialog.OnTimeSetListener() { picker, hour, minute ->
//                timeLabel = "${hour}시 ${minute}분"
//                binding.timeLabel.text = timeLabel
//            }
//            TimePickerDialog(this, timePicker, calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show()
//        }
//
//        binding.showCalender.setOnClickListener {
//            timePiker()
//        }

        val binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toastText = AtomicReference("")
        val toast = Toast.makeText(this, toastText.get(), Toast.LENGTH_LONG)

        var settingItem = arrayOf<String>("설정1", "설정2", "설정3")

        fun settingAlertHandler () {
            AlertDialog.Builder(this).run {
                setTitle("설정창")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(settingItem, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        toastText.set("${settingItem[p1]}")
                        toast.setText(toastText.get())
                        toast.show()
                    }
                })
                setPositiveButton("닫기", null)
                show()
            }
        }

        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if (p1 === DialogInterface.BUTTON_POSITIVE) {
                    toastText.set("긍정")
                } else if (p1 === DialogInterface.BUTTON_NEGATIVE) {
                    toastText.set("부정")
                } else if (p1 === DialogInterface.BUTTON_NEUTRAL) {
                    settingAlertHandler()
                }
                toast.setText(toastText.get())
                toast.show()
            }
        }


        // 알림 이벤트
        fun alertHandler () {
            AlertDialog.Builder(this).run {
                setTitle("알림창 오픈")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("확인", eventHandler)
                setNegativeButton("취소", eventHandler)
                setNeutralButton("설정", eventHandler)
                show()
            }
        }

        binding.showNotice.setOnClickListener {
            alertHandler()
        }

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