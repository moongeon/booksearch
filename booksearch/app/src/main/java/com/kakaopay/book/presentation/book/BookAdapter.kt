package com.kakaopay.book.presentation.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kakaopay.book.data.model.BookItemResponse
import com.kakaopay.book.databinding.ItemBookBinding
import com.kakaopay.book.util.Query


class BookAdapter :
    PagingDataAdapter<BookItemResponse, BookAdapter.BookViewHolder>(BookDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        book?.let {
            holder.bind(book)
        }
    }

    class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener { view ->
                binding.book?.let { book ->
                    val direction = BookFragmentDirections.actionBookFragmentToDetailFragment(
                        book,binding.checkBox.isChecked
                    )
                    view.findNavController().navigate(direction)
                }
            }
        }

        fun bind(item: BookItemResponse) {
            binding.apply {
                book = item
                query = Query.data
            }
            if (Query.likeList.contains(item.title)) {
                binding.checkBox.isChecked = true
            }else{
                binding.checkBox.isChecked = false
            }
        }
    }

    companion object {
        val BookDiffCallback = object : DiffUtil.ItemCallback<BookItemResponse>() {
            override fun areItemsTheSame(
                oldItem: BookItemResponse,
                newItem: BookItemResponse,
            ): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(
                oldItem: BookItemResponse,
                newItem: BookItemResponse,
            ): Boolean {
                return oldItem == newItem
            }
        }

    }

}