package so.notion.interview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    val interaction: MainInteractor
): ViewModel() {
    private val _messages: MutableLiveData<List<MessageView>> = MutableLiveData()
    private val _loading: MutableLiveData<Bool> = MutableLiveData()
    private val disposable = CompositeDisposable()

    fun getMessages() = _messages

    fun getSenderId() = "red"

    fun sendMessage(message: String) {
        disposable.add(
            interaction.sendMessage(getSenderId(), message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onsubc{

                }
                .subscribe({ message: MessageResponse ->
                    val newList: List<MessageView> = _messages.value ?: emptyList<MessageView>() + listOf(message.toMessageView())
                    _messages.value = newList
                }, {
                    println("")
                    //todo - error
                })
        )
    }

    fun retrieveAllMessages() {
        disposable.add(
            interaction.getMessages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ messageResponse ->
                    _messages.value = messageResponse.map { message ->
                        message.toMessageView()
                    }
                }, {
                    println("")
                    //todo - error
                })
        )
    }

    fun checkIsForYou(id: String): Boolean {
        return true //todo
    }

    fun MessageResponse.toMessageView(): MessageView = MessageView(
        id = text, //UUID
        message = text,
        isFromYou = checkIsForYou(sender_id)
    )

    fun clear() {
        disposable.clear()
    }
}
