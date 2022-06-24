package com.kakaopay.book.presentation.adapters

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import com.bumptech.glide.Glide
import com.kakaopay.book.R
import java.text.DecimalFormat


@BindingAdapter("imageUrl")
fun ImageView.imageUrl(imageUrl : String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(this).load(imageUrl)
            .thumbnail(0.1f)
            .error(R.drawable.ic_baseline_error_24)
            .into(this)
    }
}

@BindingAdapter("makeComma")
fun TextView.makeComma(price: Int){
    val formatter = DecimalFormat("###,###")
    this.text = formatter.format(price).plus("원")

    }


@BindingAdapter("main","secondText")
fun TextView.setBoldString(maintext: String,sequence: String) {
    this.text = getBoldText(maintext, sequence)
}

fun getBoldText(text: String, name: String): SpannableStringBuilder {
    try {
        val str = SpannableStringBuilder(text)
        val start = text.indexOf(name)
        val end = start + name.length
        str.setSpan(ForegroundColorSpan(Color.parseColor("#FF6702")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        str.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        str.setSpan(RelativeSizeSpan(1.3f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        return str
    }
    catch (ex : Exception){
        return SpannableStringBuilder(text)
    }

}


//return price.let {
//    val value = price.toLong()
//    val format = DecimalFormat("###,###")
//    format.format(value).plus("원")
//} ?: kotlin.run{
//    "0원"
//}