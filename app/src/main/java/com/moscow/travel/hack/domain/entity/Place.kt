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
        "Денчик лох",
        100f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-6.jpg"
    ),
    Place(
        2,
        "Денис жим сосет большой сочный хуй",
        2100f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-6.jpg"
    ),
    Place(
        3,
        "Место 1",
        300f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-6.jpg"
    ),
    Place(
        4,
        "Место 1",
        50f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-6.jpg"
    ),
    Place(
        5,
        "Место 1",
        100f,
        "https://memepedia.ru/wp-content/uploads/2021/12/ivan-zolo-2004-tik-tok-6.jpg"
    ),
)