package so.notion.interview

class MainInteractor(
    val service: MainService
) {
    fun sendMessage(senderId: String, message: String) = service.sendMessage(senderId, message)
    fun getMessages() = service.getMessages()
}