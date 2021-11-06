package so.notion.interview

import retrofit2.http.*
import io.reactivex.Observable

interface MainService {

    @POST("messages")
    fun sendMessage(
        @Query("sender_id") sender_id: String,
        @Query("text") text: String
    ): Observable<MessageResponse>

    @GET("messages")
    fun getMessages(): Observable<List<MessageResponse>>

}
//https://notion-chat-interview.herokuapp.com/chat/alpha/messages/json?sender_id=red&text=a
//https://notion-chat-interview.herokuapp.com/chat/alpha/messages?sender_id=red&text=hello
//curl -X GET 'https://notion-chat-interview.herokuapp.com/chat/alpha/messages'