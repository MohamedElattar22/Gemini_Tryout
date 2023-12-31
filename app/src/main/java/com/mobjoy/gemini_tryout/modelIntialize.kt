package com.mobjoy.gemini_tryout

import com.google.ai.client.generativeai.GenerativeModel

class modelIntialize {

    companion object {
        private  var instance : GenerativeModel ?= null
        fun intializeModel() : GenerativeModel{
            if(instance == null){
                instance = GenerativeModel(
                    modelName = "gemini-pro" ,
                    Constants.apiKey
                )
            }
            return instance!!
        }
    }


}