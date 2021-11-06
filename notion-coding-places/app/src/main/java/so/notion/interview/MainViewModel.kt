package so.notion.interview

import androidx.lifecycle.*
import com.airbnb.epoxy.EpoxyModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observable

class MainViewModel(
    val interaction: MainInteraction
): ViewModel() {
    private val _messages: MutableLiveData<List<LocationRow>> = MutableLiveData()
    private val disposable = CompositeDisposable()
    fun getLocations() = _locations

    fun retrieveLocations(input: String) {
        disposable.add(interaction.getLocationResults(input)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                _locations.value = it.predictions.map { place ->
                    LocationRow(place)
                }
            }, {
                println("")
                //todo - error
            }))
    }

    fun clear() {
        disposable.clear()
    }
}
