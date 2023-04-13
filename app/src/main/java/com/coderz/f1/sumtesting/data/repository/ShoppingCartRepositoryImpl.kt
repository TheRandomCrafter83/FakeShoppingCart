package com.coderz.f1.sumtesting.data.repository

import com.coderz.f1.sumtesting.data.data_source.ShoppingCartDao
import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem
import com.coderz.f1.sumtesting.domain.repository.ShoppingCartRepository
import kotlinx.coroutines.flow.Flow

class ShoppingCartRepositoryImpl(private val dao: ShoppingCartDao): ShoppingCartRepository {
    override fun getShoppingCartContent(): Flow<List<ShoppingCartItem>> {
        return dao.getShoppingCartContent()
    }

    override suspend fun insertItem(item: ShoppingCartItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: ShoppingCartItem) {
        dao.deleteItem(item)
    }

    override suspend fun getCartTotal(): Double {
        return dao.getCartTotal()
    }

    override suspend fun getCartItemById(id: Int): ShoppingCartItem? {
        return dao.getCartItemById(id)
    }


}