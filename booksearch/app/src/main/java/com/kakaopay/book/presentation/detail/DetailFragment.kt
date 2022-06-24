package com.kakaopay.book.presentation.detail

import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.kakaopay.book.databinding.FragmentDetailBinding
import com.kakaopay.book.presentation.base.BaseFragment
import com.kakaopay.book.util.Query
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {

    private val args: DetailFragmentArgs by navArgs()
    override val viewModel by viewModels<DetailViewModel>()


    override fun getViewBinding() = FragmentDetailBinding.inflate(layoutInflater)


    override fun initViews() = with(binding) {
        vm = viewModel
        args.bookDetail?.let{
            binding.bookItem = it
        }

        toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        cbLike.isChecked = args.like

        cbLike.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Query.likeList.add(args.bookDetail.title)
            } else {
                Query.likeList.clear()
            }

        }

    }


    override fun observeData() {

    }
}