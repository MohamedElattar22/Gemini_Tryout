package com.mobjoy.gemini_tryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.WindowCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.ai.client.generativeai.GenerativeModel
import com.mobjoy.gemini_tryout.databinding.ActivityMainBinding
import com.mobjoy.gemini_tryout.viewMolde.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        setContentView(viewBinding.root)


    }

    override fun onStart() {
        super.onStart()

    }

    private suspend fun  modelCall(){
        val generativeModel = modelIntialize.intializeModel()
        viewBinding.generateBtn.setOnClickListener {
            val prompt = viewBinding.promptText.text.toString()
            lifecycleScope.launch {
                val response = generativeModel.generateContent(prompt)
                viewBinding.HeaderTV.text = prompt
                viewBinding.prombotAnswerTV.text = response.text
                viewBinding.promptText.text = null
            }


        }

    }


}