package com.coderz.f1.sumtesting.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="ShoppingCart")
data class ShoppingCartItem(
    val description:String,
    val price:Double,
    @PrimaryKey(autoGenerate = true) val id:Int? = null
)
