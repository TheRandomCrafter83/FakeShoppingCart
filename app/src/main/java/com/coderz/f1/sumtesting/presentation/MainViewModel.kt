package com.coderz.f1.sumtesting.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.coderz.f1.sumtesting.data.ShoppingCartDatabaseClient
import com.coderz.f1.sumtesting.data.data_source.ShoppingCartDatabase
import com.coderz.f1.sumtesting.data.repository.ShoppingCartRepositoryImpl
import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem
import com.coderz.f1.sumtesting.domain.repository.ShoppingCartRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val client: ShoppingCartDatabase?
    private val repository:ShoppingCartRepository


    private val _cartItems: MutableLiveData<List<ShoppingCartItem>> = MutableLiveData()
    val shoppingCartItems:LiveData<List<ShoppingCartItem>> = _cartItems

    private val _cartTotal:MutableLiveData<Double> = MutableLiveData()
    val shoppingCartTotal:LiveData<Double> = _cartTotal

    init {
        client = ShoppingCartDatabaseClient().getShoppingCartDatabaseClient(application)
        repository = client?.let { ShoppingCartRepositoryImpl(it.shoppingCardDao) }!!
        getCartItems()
        getCartTotal()
    }


    private fun getCartItems(){
        viewModelScope.launch {
            repository.getShoppingCartContent().collectLatest { list ->
                _cartItems.postValue(list)
            }
        }
    }

    fun insertItem(item:ShoppingCartItem){
        viewModelScope.launch {
            repository.insertItem(item)
            getCartTotal()
        }
    }

    fun deleteItem(item:ShoppingCartItem){
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun getCartTotal(){
        viewModelScope.launch {
            _cartTotal.postValue(repository.getCartTotal())
        }
    }

    fun getCartItemById(id:Int):ShoppingCartItem?{
        var ret:ShoppingCartItem? = null
        viewModelScope.launch {
            ret = repository.getCartItemById(id)
        }
        return ret
    }
}