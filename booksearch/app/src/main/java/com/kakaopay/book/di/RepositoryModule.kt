package com.kakaopay.book.di

import com.kakaopay.book.data.api.BookSearchApi
import com.kakaopay.book.data.repository.BookRepository
import com.kakaopay.book.data.repository.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBookRepository(
        bookSearchApi: BookSearchApi
    ) : BookRepository{
        return BookRepositoryImpl(bookSearchApi)
    }

}