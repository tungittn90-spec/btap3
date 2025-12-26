package com.example.btap3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class NhapThongTinSV : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtMaSV: EditText
    private lateinit var edtLop: EditText
    private lateinit var edtPhone: EditText
    private lateinit var cbSMS: CheckBox
    private lateinit var cbBHYT: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        edtName = findViewById(R.id.edtName)
        edtMaSV = findViewById(R.id.edtMaSV)
        edtLop = findViewById(R.id.edtLop)
        edtPhone = findViewById(R.id.edtPhone)
        cbSMS   = findViewById(R.id.cbSMS)
        cbBHYT  = findViewById(R.id.cbBHYT)

        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val btnOK: Button = findViewById(R.id.btnOK)

        btnSubmit.setOnClickListener {
            val ten = edtName.text.toString()
            val ma = edtMaSV.text.toString()
            val lop = edtLop.text.toString()
            val phone = edtPhone.text.toString()

            var dichVu =""
            if(cbSMS.isChecked){
                dichVu += "SMS "
            }
            if(cbBHYT.isChecked){
                dichVu += "BHYT"
            }
            val intent = Intent(this, HienThiThongTinSV::class.java)
            intent.putExtra("TEN", ten)
            intent.putExtra("MASV", ma)
            intent.putExtra("LOP", lop)
            intent.putExtra("PHONE", phone)
            intent.putExtra("DICHVU", dichVu)

            startActivity(intent)

        }
        btnOK.setOnClickListener {
            edtName.setText("")
            edtMaSV.setText("")
            edtLop.setText("")
            edtPhone.setText("")
            cbSMS.isChecked = false
            cbBHYT.isChecked = false
        }

    }


}
import android.widget.TextView

class HienThiThongTinSV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvTen = findViewById<TextView>(RESULT_OK.id.tvTen)
        val tvMaSV = findViewById<TextView>(RESULT_OK.id.tvMaSV)
        val tvPhone = findViewById<TextView>(RESULT_OK.id.tvPhone)
        val tvLop = findViewById<TextView>(RESULT_OK.id.tvLop)
        val tvDichVu = findViewById<TextView>(RESULT_OK.id.tvDichVu)

        val intent = intent
        val ten = intent.getStringExtra("TEN")
        val ma = intent.getStringExtra("MASV")
        val phone = intent.getStringExtra("PHONE")
        val lop = intent.getStringExtra("LOP")

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

    }
}
