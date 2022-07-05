package com.example.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [DocumentEntity::class, ECommerceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun documentDao(): DocumentDAO
    abstract fun ecommerceDao(): ECommerceDAO

    companion object {
        private var db: AppDatabase? = null

        fun init(applicationContext: Context): AppDatabase {
            if (db == null) {
                synchronized(this) {
                    db = Room.databaseBuilder(
                        applicationContext,
                        AppDatabase::class.java, "davreestr"
                    )
                        .addCallback(callback())
                        .build()
                }
            }

            return db!!
        }

        private fun callback(): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    db.execSQL(
                        """
                            INSERT INTO ecommerce(name_uz, description_uz, url_address) VALUES 
                            ('Uy-joy bor/yo`qligi to`g`risida ma`lumotnoma', 'Jismoniy shaxslarga nomida uy-joy bor/yo`qligi to`g`risida ma`lumotnoma berish','https://my.gov.uz/uz/service/115'),
                            ('Ta`qiq bor/yo`qligi to`g`risida ma`lumot berish', 'Ko`chmas mulkka nisbatan ta`qiq bor/yo`qligi to`g`risida ma`lumotnoma olish','https://my.gov.uz/uz/service/471'),
                            ('Kadastr qiymati to`g`risida ma`lumot berish', 'Davlat Reestridagi har qanday ko`chmas mulk ob`ektning kadastr qiymatini bilish','http://kadastr.uz/uz/kadastr-qiymatini-hisoblash'),
                            ('Kadastr passportini shakllantirish', 'Jismoniy va yuridik shaxslarga kadastr passportini shakllantirish','https://my.gov.uz/uz/service/294'),
                            ('Ko`chirma shakllantirish', 'Ko`chmas mulk obyektlariga bo`lgan huquqlarni davlat ro`yxatidan o`tkazish','https://my.gov.uz/uz/service/248'),
                            ('Ko`chirmani tekshirish', 'Davlat kadastr reestridan ko`chmas mulk bo`yicha ko`chirmani tekshirish','https://my.gov.uz/uz/service/506'),
                            ('Kadastr hujjatlarini rasmiylashitirish', 'Qurilishi tugallangan bino va inshootlarni foydalanishga qabul qilish uchun ariza topshirish va kadastr hujjatlarini rasmiylashtirish','https://my.gov.uz/uz/service/480'),
                            ('Ijara shartnomasini ro`yxatdan o`tkazish', 'Bino va inshootlarni ijara shartnomasini davlat ro`yxatidan o`tkazish','https://my.gov.uz/uz/service/219'),
                            ('Turar joyning maydoni bo`yicha ma`lumotnoma olish', 'Jismoniy va yuridik shaxslarga turar joyning maydoni bo`yicha ma`lumotnoma olish','https://my.gov.uz/uz/service/216'),
                            ('Servitutni ro`yxatdan o`tkazish', 'O`zganing yer uchstkasidan cheklangan tarzda foydalanish huquqi (servitut) to`g`risida kelishuvni ro`yhatdan o`tkazish','https://my.gov.uz/uz/service/217');
                        """
                    )

                    db.execSQL("""
                       INSERT INTO document(name_uz, url_address) VALUES
                        ('Kadastr sohasida ayrim davlat xizmatlari ko`rsatishning ma`muriy reglamentlarini tasdiqlash to`g`risida','https://lex.uz/uz/docs/4977684'),
                        ('Ko`chmas mulk obyektlariga bo`lgan huquqlarni davlat ro`yxatidan o`tkazish tartibini takomillashtirish chora-tadbirlari to`g`rida','https://lex.uz/uz/docs/4135063'),
                        ('Ko`chmas mulkka bo`lgan huquqlarni davlat ro`yxatidan o`tkazish tizimini yanada takomillashtirish chora-tadbirlari to`g`risida','https://lex.uz/docs/4272681'),
                        ('Yer hisobi va davlat kadastrlarini yuritish tizimini tubdan takomillashtirish chora-tadbirlari to`g`risida 2020 yil 7 sentyabrdagi ПФ-6061-son farmoni','https://lex.uz/docs/5425723');
                    """)

                }

            }
        }
    }
}