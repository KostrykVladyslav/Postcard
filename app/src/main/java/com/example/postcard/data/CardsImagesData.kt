package com.example.postcard.data

data class CardsImagesData(val url: String, val day: String, val type: String)

class Cards {
    fun getList(): ArrayList<CardsImagesData> {
        return arrayListOf(
            CardsImagesData("https://images.ctfassets.net/hrltx12pl8hq/3MbF54EhWUhsXunc5Keueb/60774fbbff86e6bf6776f1e17a8016b4/04-nature_721703848.jpg?fit=fill&w=480&h=270", "March 5", "Holiday"),
            CardsImagesData("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg", "March 6", "Holiday"),
            CardsImagesData("https://static.toiimg.com/photo/72975551.cms", "March 7", "Holiday"),
            CardsImagesData("https://www.adobe.com/content/dam/cc/us/en/products/creativecloud/stock/stock-riverflow1-720x522.jpg.img.jpg", "March 8", "Holiday"),
            CardsImagesData("https://cdn.pixabay.com/photo/2014/02/27/16/10/tree-276014__340.jpg", "March 9", "Holiday"),
            CardsImagesData("https://cdn.pixabay.com/photo/2019/02/15/11/04/book-3998252__340.jpg", "March 10", "Holiday"),
            CardsImagesData("https://thumbs.dreamstime.com/b/environment-earth-day-hands-trees-growing-seedlings-bokeh-green-background-female-hand-holding-tree-nature-field-gra-130247647.jpg", "March 11", "Holiday"),
            CardsImagesData("https://www.searchenginejournal.com/wp-content/uploads/2018/10/How-to-Boost-Your-Images%E2%80%99-Visibility-on-Google-Images-760x400.png", "March 12", "Holiday"),
        )
    }
}