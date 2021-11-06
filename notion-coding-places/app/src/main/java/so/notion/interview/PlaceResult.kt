package so.notion.interview

data class PlaceResult(
    val status: String,
    val predictions: Array<Prediction>
)

data class Prediction(
    val place_id: String,
    val structured_formatting: StructuredFormatting
)

data class StructuredFormatting (
    val main_text: String,
    val secondary_text: String
)