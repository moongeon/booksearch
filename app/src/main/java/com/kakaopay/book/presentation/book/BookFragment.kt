package com.kakaopay.book.presentation.book

import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.kakaopay.book.databinding.FragmentBookBinding
import com.kakaopay.book.presentation.base.BaseFragment
import com.kakaopay.book.util.Constants
import com.kakaopay.book.util.Query
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookFragment : BaseFragment<BookViewModel, FragmentBookBinding>() {

    override val viewModel by viewModels<BookViewModel>()

    override fun getViewBinding() = FragmentBookBinding.inflate(layoutInflater)

    private val bookSearchAdapter by lazy { BookAdapter() }


    override fun initViews() {
        searchBooks()
        setupLoadState()
        with(binding) {
            rvSearchResult.adapter = bookSearchAdapter
            btnRetry.setOnClickListener {
                binding.btnRetry.visibility = View.GONE
                bookSearchAdapter.refresh()
            }
        }
    }

    private fun searchBooks() {
        var startTime = System.currentTimeMillis()
        var endTime: Long = 0
        binding.etSearch.addTextChangedListener {
            endTime = System.currentTimeMillis()
            if (endTime - startTime >= Constants.SEARCH_BOOKS_TIME_DELAY ) {
                it?.let {
                    val query = it.toString().trim()
                    if (query.isNotEmpty() && Query.data != query) {
                        Query.data = query
                        Query.likeList.clear()
                        viewModel.search(query)
                    }
                }
            }
        }
        startTime = endTime
    }

    private fun setupLoadState() {
        bookSearchAdapter.addLoadStateListener { combinedLoadStates ->
            val loadState = combinedLoadStates.source
            val isListEmpty = bookSearchAdapter.itemCount < 1
                    && loadState.refresh is LoadState.NotLoading
                    && loadState.append.endOfPaginationReached

            binding.tvEmptylist.isVisible = isListEmpty
            binding.rvSearchResult.isVisible = !isListEmpty

            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading

            val errorState: LoadState.Error? = loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error
                ?: loadState.refresh as? LoadState.Error

            errorState?.let {
                binding.clNetwork.visibility = View.VISIBLE
                binding.btnRetry.visibility = View.VISIBLE
                binding.rvSearchResult.visibility = View.GONE
            } ?: kotlin.run {
                binding.clNetwork.visibility = View.GONE
            }
        }
    }

    override fun observeData() {
        lifecycleScope.launch {
            viewModel.searchPagingResult.collectLatest {
                bookSearchAdapter.submitData(it)
            }
        }

    }


}