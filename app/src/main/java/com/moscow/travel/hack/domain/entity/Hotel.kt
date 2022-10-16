package com.moscow.travel.hack.domain.entity

data class Hotel(
    val id: Int,
    val rating: Float,
    val name: String,
    val address: String,
    val price: String,
    val photoUri: String,
)

val hotels = listOf(
    Hotel(
        1,
        4f,
        "Гостиница Измайлово Дельта",
        "Измайловское ш., д. 71, корп. 4 Г—Д",
        "2990",
        "https://cms.russpass.ru/v1/file/62fcf82271b9411345c74ab2/640/480"
    ),
    Hotel(
        2,
        1f,
        "Дизайн-хостел Strawberry Duck Moscow",
        "Потаповский пер., д. 8/12 стр. 2",
        "1463",
        "https://cms.russpass.ru/v1/file/62efae8971b94113457d3d65/640/480"
    ),
    Hotel(
        3,
        5f,
        "Chekhoff Hotel Moscow Curio Collection by Hilton",
        "ул. Малая Дмитровка, д. 11",
        "9600",
        "https://cms.russpass.ru/v1/file/62d1356071b9411345d97339/640/480"
    ),
    Hotel(
        4,
        4f,
        "Гостиница «Эрмитаж»",
        "Дурасовский пер., д. 7, стр. 1",
        "4000",
        "https://cms.russpass.ru/v1/file/632d64b166018edd5c67a0bf/640/480"
    ),
    Hotel(
        5,
        4f,
        "B.60 Hotel",
        "ул. 1-я Брестская, д. 60",
        "7400",
        "https://cms.russpass.ru/v1/file/62fa390871b9411345b563b5/640/480"
    ),
    Hotel(
        6,
        3f,
        "Отель «Паркофф»",
        "ул. 11-я Парковая, д. 34A",
        "3000",
        "https://cms.russpass.ru/v1/file/62a1eafe6f8422bf95ecb258/640/480"
    ),
    Hotel(
        7,
        4f,
        "Гостиница «Парк Тауэр»",
        "Дмитровское ш., д. 27",
        "3281",
        "https://cms.russpass.ru/v1/file/62a1eb46b076bd79ea7d1493/640/480"
    ),
    Hotel(
        8,
        4f,
        "Гостиница Viewpoint Hotel",
        "Садовническая наб., д. 7",
        "5187",
        "https://cms.russpass.ru/v1/file/62a1ecba37e5f4efd4a7ee7f/640/480"
    ),
)