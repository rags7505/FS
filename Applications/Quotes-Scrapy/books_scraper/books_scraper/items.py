import scrapy

class BookItem(scrapy.Item):
    title = scrapy.Field()
    rating = scrapy.Field()
    price = scrapy.Field()
    availability = scrapy.Field()
