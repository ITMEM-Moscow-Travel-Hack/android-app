package com.moscow.travel.hack.domain.entity

data class Place(
    val id: Int,
    val name: String,
    val price: Float,
    val photoUri: String,
)

val places = listOf(
    Place(
        1,
        "Эрмитаж",
        100f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-6.jpg"
    ),
    Place(
        2,
        "Кремль",
        2100f,
        "https://memepedia.ru/wp-content/uploads/2022/09/photo_2022-09-18_18-52-22-1.jpg"
    ),
    Place(
        3,
        "Царское село",
        300f,
        "https://memepedia.ru/wp-content/uploads/2022/09/oputi-niputju-pesnja-768x512-1.jpg"
    ),
    Place(
        4,
        "Место 1",
        50f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-4.jpg"
    ),
    Place(
        5,
        "Место 2",
        100f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-5.jpg"
    ),
)