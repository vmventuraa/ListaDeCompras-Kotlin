package br.com.fiap.listadecompras.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.listadecompras.model.ItemModel

class ItemsViewModel : ViewModel() {

    private var items = mutableListOf<ItemModel>()
    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(name: String) {
        val item = ItemModel(
            id = 0,
            name = name,
            onRemove = ::removeItem
        )

        if (!items.contains(item)) {
            items.add(item)
            itemsLiveData.value = items
        }
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }
}