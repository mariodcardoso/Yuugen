package br.com.mariodias.yuugen.base

import android.content.Context
import androidx.room.Room
import br.com.mariodias.yuugen.shelves.data.dao.ShelvesBooksDao
import br.com.mariodias.yuugen.shelves.domain.repository.ShelvesBooksRepository
import br.com.mariodias.yuugen.shelves.domain.repository.ShelvesBooksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideYuugenDatabase(@ApplicationContext context: Context) =
        Room
            .databaseBuilder(context, YuugenDatabase::class.java, "yuugen_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BookApi::class.java)


    @Provides
    @Singleton
    fun provideShelvesDao(db: YuugenDatabase) = db.shelvesDao()

    @Provides
    @Singleton
    fun provideShelvesBooksRepository(shelvesBooksDao: ShelvesBooksDao) = ShelvesBooksRepositoryImpl(shelvesBooksDao)

}