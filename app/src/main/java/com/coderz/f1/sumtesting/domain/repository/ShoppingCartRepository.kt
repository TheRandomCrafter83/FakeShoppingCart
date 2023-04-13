package com.coderz.f1.sumtesting.domain.repository

import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem
import kotlinx.coroutines.flow.Flow

interface ShoppingCartRepository {
    fun getShoppingCartContent(): Flow<List<ShoppingCartItem>>

    suspend fun insertItem(item: ShoppingCartItem)

    suspend fun deleteItem(item: ShoppingCartItem)

    suspend fun getCartTotal():Double

    suspend fun getCartItemById(id:Int):ShoppingCartItem?
}