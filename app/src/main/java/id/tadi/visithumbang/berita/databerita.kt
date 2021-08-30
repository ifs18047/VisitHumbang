package id.tadi.visithumbang.berita

import id.tadi.visithumbang.R

object databerita {
        private val image = arrayOf(
            R.drawable.c,
            R.drawable.c,
            R.drawable.c,
            R.drawable.c
        )
        private val news_title = arrayOf(
            "Horja Geopark Kaldera Toba 2020",
            "Horja Geopark Kaldera Toba 2020",
            "Horja Geopark Kaldera Toba 2020",
            "Horja Geopark Kaldera Toba 2020"
        )
        private val news_date = arrayOf(
            "11 Mei 2021",
            "11 Mei 2021",
            "11 Mei 2021",
            "11 Mei 2021"
        )

        val listdata: ArrayList<berita>
            get() {
                val list = arrayListOf<berita>()
                for (i in image.indices) {
                    val Berita = berita() // variabel manga adalah object dari data class Manga()
                    Berita.image = image[i] // mengisi property pada data class berdasarkan index
                    Berita.news_title = news_title[i] // mengisi property pada data class berdasarkan index
                     Berita.news_date= news_date[i] // mengisi property pada data class berdasarkan index
                     // mengisi property pada data class berdasarkan index
                    list.add(Berita) // memasukan data yang telah di looping ke object manga
                }
                return list // mengembalikan data ke variabel list yang ada di baris 58
            }
    }
