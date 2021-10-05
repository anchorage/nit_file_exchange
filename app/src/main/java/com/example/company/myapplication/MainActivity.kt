package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val storage = Environment.getExternalStorageDirectory()

        perform.setOnClickListener {

            try {

                var file1 = File(storage, filepath.text.toString())
                var file2 = File(storage, filepath2.text.toString())
                if (file1.exists() && file2.exists()) {

                    var file1Text = file1.readText()
                    var file2Text = file2.readText()


                    val bufferedWriter1 = BufferedWriter(FileWriter(file1))
                    bufferedWriter1.write(file2Text)
                    bufferedWriter1.close()

                    val bufferedWriter2 = BufferedWriter(FileWriter(file2))
                    bufferedWriter2.write(file1Text)
                    bufferedWriter2.close()
                } else if (file1.exists() && !file2.exists()){
                    filepath2.setText("error")
                } else if (file2.exists() && !file1.exists()) {
                    filepath.setText("error")
                } else {
                    filepath2.setText("error")
                    filepath.setText("error")
                }




            } catch(e:Exception) {

            }

        }

    }
}
