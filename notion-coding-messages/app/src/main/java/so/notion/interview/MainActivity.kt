package so.notion.interview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.*
import androidx.lifecycle.*
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel = Factory.createViewModel()
    lateinit var epoxyRV: EpoxyRecyclerView
    lateinit var sendButton: Button
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        epoxyRV = findViewById<EpoxyRecyclerView>(R.id.epoxyRV)
        sendButton = findViewById<Button>(R.id.sendButton)
        editText = findViewById<EditText>(R.id.editText)

        setupMessages()
        sendButton.setOnClickListener {
            val text = editText.getText().toString()
            if (!text.isNullOrEmpty()) {
                viewModel.sendMessage(text)
                editText.setText("")
            }
        }
    }

    fun setupMessages() {
        val messageObserver = Observer<List<MessageView>> { models ->
            epoxyRV.setModels(models)
        }

        viewModel.getMessages().observe(this, messageObserver)

        //retrieve todo
    }
}