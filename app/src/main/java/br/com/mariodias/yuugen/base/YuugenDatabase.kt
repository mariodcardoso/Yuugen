//package br.com.mariodias.yuugen.base
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import br.com.mariodias.yuugen.shelves.data.ShelvesDao
//import br.com.mariodias.yuugen.shelves.data.ShelvesEntity
//
//@Database(entities = [ShelvesEntity::class], version = 1, exportSchema = false)
//abstract class YuugenDatabase : RoomDatabase() {
//
//    abstract val shelvesDao: ShelvesDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: YuugenDatabase? = null
//
//        fun getInstance(context: Context): YuugenDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        YuugenDatabase::class.java,
//                        "yuugen_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//}