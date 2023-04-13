package com.coderz.f1.sumtesting.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.KeyListener
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coderz.f1.sumtesting.databinding.ActivityMainBinding
import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem
import com.coderz.f1.sumtesting.utils.Utils

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =  ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application))[MainViewModel::class.java]

        val adapter = ShoppingCartRecyclerAdapter()


        viewModel.shoppingCartItems.observe(this) { items ->
            adapter.submitList(items)
        }

        viewModel.shoppingCartTotal.observe(this){total ->
            binding.textviewTotal.text = Utils.formatCurrency(total)
        }

        binding.apply {
            recycler.adapter = adapter
            buttonAdd.setOnClickListener {
                viewModel.insertItem(ShoppingCartItem(edittextDescription.text.toString(),edittextPrice.text.toString().toDouble()))
                edittextPrice.text.clear()
                edittextDescription.text.clear()
                edittextDescription.requestFocus()
            }
            edittextPrice.setOnEditorActionListener { textView, actionId, keyEvent ->
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    buttonAdd.performClick()
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }
        }

    }
}