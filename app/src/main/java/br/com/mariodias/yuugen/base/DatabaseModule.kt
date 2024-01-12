package br.com.mariodias.yuugen.base

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
    fun provideShelvesDao(db: YuugenDatabase) = db.shelvesDao()
}