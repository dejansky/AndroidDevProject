package com.example.dimpguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_ask.*

class AskActivity : BaseFunctionsForAllActivities() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask)
        subjectText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                submitButton.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s!!.length < MINIMUM_SUBJECT_LENGTH){
                    subjectErrorText.text= getString(R.string.ToShortSubject)
                }else if(s!!.length > MAXIMUM_SUBJECT_LENGTH){
                    subjectErrorText.text = getString(R.string.ToLongSubject)
                }else{
                    subjectErrorText.text = ""
                    submitButton.isEnabled =true
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if(EnterQuestionText.text.length< MINIMUM_QUESTION_LENGTH || EnterQuestionText.text.length> MAXIMUM_QUESTION_LENGTH){
                    submitButton.isEnabled = false
                }
            }
        })
        EnterQuestionText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(subjectText.text.length < MINIMUM_SUBJECT_LENGTH || subjectText.text.length > MAXIMUM_SUBJECT_LENGTH){

                    submitButton.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                submitButton.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s!!.length < MINIMUM_QUESTION_LENGTH){
                    questionErrorText.text = getString(R.string.ToShortQuestion)
                }else if(s!!.length > MAXIMUM_QUESTION_LENGTH){
                    questionErrorText.text = getString(R.string.toLongQuestion)
                }else{
                    questionErrorText.text = ""
                    submitButton.isEnabled = true
                }
            }

        })
    }
    companion object{
        const val MINIMUM_QUESTION_LENGTH = 5
        const val MAXIMUM_QUESTION_LENGTH = 100
        const val MINIMUM_SUBJECT_LENGTH = 3
        const val MAXIMUM_SUBJECT_LENGTH = 20
    }


}
