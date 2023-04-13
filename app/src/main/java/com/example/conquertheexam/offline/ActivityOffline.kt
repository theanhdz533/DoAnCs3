package com.example.conquertheexam.offline

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conquertheexam.MainActivity
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityOfflineBinding

class ActivityOffline : AppCompatActivity() {
    lateinit var binding: ActivityOfflineBinding
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)
        binding = ActivityOfflineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // music
        mediaPlayer = MediaPlayer.create(this, R.raw.music)

        binding.btnBackHome.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // toan
        binding.btnToan.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnToan.isClickable){
                intent.putExtra("mon","Toán")
            }
            startActivity(intent)
        }
        // toan
        binding.btnToan.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnToan.isClickable){
                intent.putExtra("mon","Toán")
                intent.putExtra("ma_mon","toan")
            }
            startActivity(intent)
        }
        // li
        binding.btnVatLi.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnVatLi.isClickable){
                intent.putExtra("mon","Vật Lí")
                intent.putExtra("ma_mon","li")
            }
            startActivity(intent)
        }
        // hoa
        binding.btnHoaHoc.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnHoaHoc.isClickable){
                intent.putExtra("mon","Hóa Học")
                intent.putExtra("ma_mon","hoa")
            }
            startActivity(intent)
        }
        // su
        binding.btnSu.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnSu.isClickable){
                intent.putExtra("mon","Lịch Sử")
                intent.putExtra("ma_mon","su")
            }
            startActivity(intent)
        }
        // dia
        binding.btnDia.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnDia.isClickable){
                intent.putExtra("mon","Địa lí")
                intent.putExtra("ma_mon","dia")
            }
            startActivity(intent)
        }
        // GDCD
        binding.btnGDCD.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnGDCD.isClickable){
                intent.putExtra("mon","Giáo Dục Công Dân")
                intent.putExtra("ma_mon","gdcd")
            }
            startActivity(intent)
        }
        // sinh hoc
        binding.btnSinh.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnSinh.isClickable){
                intent.putExtra("mon","Sinh Học")
                intent.putExtra("ma_mon","sinh")
            }
            startActivity(intent)
        }
        // tieng anh
        binding.btnAnh.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnAnh.isClickable){
                intent.putExtra("mon","Tiếng Anh")
                intent.putExtra("ma_mon","anh")
            }
            startActivity(intent)
        }
        // dem nguoc
        binding.btnClock.setOnClickListener {
            mediaPlayer.release()
            val intent = Intent(this,ActivityClock::class.java)
            startActivity(intent)
        }
        // btn music

        binding.btnMusic.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                binding.btnMusic.text = "Phát nhạc"
            } else {
                mediaPlayer.start()
                binding.btnMusic.text = "Dừng"
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}