package so.notion.interview

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*



class LocationRow(
 val result: Prediction
): EpoxyModelWithHolder<LocationRow.ItemHolder>() {

    init {
        id("LocationRow${result.place_id}")
    }

    override fun getDefaultLayout(): Int = R.layout.location_row

    override fun createNewHolder(): ItemHolder = ItemHolder()

    override fun bind(holder: ItemHolder) {
        holder.bind()
    }

    override fun shouldSaveViewState(): Boolean = true

    inner class ItemHolder : EpoxyHolder() {
        private lateinit var primary: TextView
        private lateinit var secondary: TextView

        override fun bindView(itemView: View) {
            primary = itemView.findViewById(R.id.primary)
            secondary = itemView.findViewById(R.id.secondary)
        }

        fun bind() {
            primary.text = result.structured_formatting.main_text
            secondary.text = result.structured_formatting.secondary_text
        }
    }
}