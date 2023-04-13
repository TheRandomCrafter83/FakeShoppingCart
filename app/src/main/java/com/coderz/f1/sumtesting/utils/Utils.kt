package com.coderz.f1.sumtesting.utils

import java.text.NumberFormat
import java.util.*

class Utils {
    companion object{
        fun formatCurrency(number:Double):String{
            return NumberFormat.getCurrencyInstance(Locale.US).format(number)
        }
    }
}