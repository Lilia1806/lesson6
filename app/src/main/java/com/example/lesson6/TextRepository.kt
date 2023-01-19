package com.example.lesson6

class TextRepository {
    private var textList = mutableListOf<TextModel>()

    fun getListOfText() : MutableList<TextModel>{
        textList.add(TextModel( "Continue"))
        textList.add(TextModel( "Switching Protocols"))
        textList.add(TextModel("Processing"))
        textList.add(TextModel("Early Hints"))
        textList.add(TextModel("OK"))
        textList.add(TextModel( "Created"))
        textList.add(TextModel("Accepted"))
        textList.add(TextModel("Non-Authoritative Information"))
        textList.add(TextModel( "No Content"))
        textList.add(TextModel( "Partial Content"))
        textList.add(TextModel( "Multi-Status"))
        textList.add(TextModel("Multiple Choices"))
        textList.add(TextModel("Moved Permanently"))
        textList.add(TextModel( "Found"))
        textList.add(TextModel( "See Other"))
        textList.add(TextModel("Not Modified"))
        textList.add(TextModel( "Use Proxy"))
        textList.add(TextModel( "Temporary Redirect"))
        textList.add(TextModel( "Permanent Redirect"))
        textList.add(TextModel( "Bad Request"))
        textList.add(TextModel( "Unauthorized"))
        textList.add(TextModel("Payment Required"))
        return textList
    }
}