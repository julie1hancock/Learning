package so.notion.interview

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*

class MessageView(
    val id: String,
    val message: String,
    val isFromYou: Boolean
): EpoxyModelWithHolder<MessageView.ItemHolder>() {

    init {
        id("MessageView$id")
    }

    override fun getDefaultLayout(): Int = R.layout.message

    override fun createNewHolder(): ItemHolder = ItemHolder()

    override fun bind(holder: ItemHolder) {
        holder.bind()
    }

    override fun shouldSaveViewState(): Boolean = true

    inner class ItemHolder : EpoxyHolder() {
        private lateinit var messageView: TextView

        override fun bindView(itemView: View) {
            messageView = itemView.findViewById(R.id.messageText)
        }

        fun bind() {
            messageView.text = message
        }
    }
}