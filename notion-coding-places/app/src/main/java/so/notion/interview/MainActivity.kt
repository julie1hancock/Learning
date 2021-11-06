package so.notion.interview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.*
import androidx.lifecycle.*
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel = Factory.createViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val epoxyRv1: EpoxyRecyclerView = findViewById<EpoxyRecyclerView>(R.id.epoxyRV)
        val editText: EditText = findViewById<EditText>(R.id.editText)

        val nameObserver = Observer<List<LocationRow>> { models ->
            epoxyRv1.setModels(models)
        }

        viewModel.getLocations().observe(this, nameObserver)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.retrieveLocations(s?.toString() ?: "")
            }
        })
    }
}
