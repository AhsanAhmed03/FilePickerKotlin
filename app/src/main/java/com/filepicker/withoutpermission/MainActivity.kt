package com.filepicker.withoutpermission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atwa.filepicker.core.FilePicker
import com.filepicker.withoutpermission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var filePicker: FilePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            filePicker = FilePicker.getInstance(this@MainActivity)
            btnPickFile.setOnClickListener {
                pickFile()
            }
        }
    }

    private fun pickFile(){

        filePicker.pickFile{ data->
            val name =  data?.name
            val fileSize = data?.sizeKb
            val file = data?.file

            binding.fileNameTxt.text = name
            binding.fileSizeTxt.text = fileSize.toString()+"Kbs"

        }
    }

}