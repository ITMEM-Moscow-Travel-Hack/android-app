package com.moscow.travel.hack.domain.entity

data class City(
    val id: Int,
    val name: String,
    val photoUri: String,
    val places: List<String>
)

val cities = listOf(
    City(
        1,
        "Москва",
        "https://cms.dev01.russpass.dev/v1/file/612fce58a40bb900118715af/160/160",
        places = listOf(
            "Третьяковская галерея",
            "ВДНХ",
            "Парк Горького",
            "Четвертая активность",
            "Зарядье"
        )
    ),
    City(
        2,
        "Санкт-Петербург",
        "https://cms.dev01.russpass.dev/v1/file/612fce66a40bb900118715b3/160/160",
        places = listOf("Казанский собор", "Новая Голландия", "Эрмитаж", "Четвертая карточка")
    ),
    City(
        3,
        "Крым",
        "https://cms.dev01.russpass.dev/v1/file/612fce6da40bb900118715b6/160/160",
        places = listOf("Ласточкино гнездо", "Пантикапей", "Ханский дворец")
    ),
    City(
        4,
        "Байкал",
        "https://cms.dev01.russpass.dev/v1/file/611f717df2d54e00185e3467/160/160",
        places = listOf("Байкал", "Буддийская ступа", "Сарайский пляж")
    ),
    City(
        5,
        "Нижний",
        "https://cms.dev01.russpass.dev/v1/file/612fce92a40bb900118715ba/160/160",
        places = listOf("Чкаловская лестница", "Усадьба Рукавишниковых", "Строгановская церковь")
    ),
    City(
        6,
        "Регионы",
        "https://cms.dev01.russpass.dev/v1/file/611f7101f2d54e00185e345b/160/160",
        places = listOf("Показать все")
    ),
)