package com.example.globalnews.model

import com.google.gson.annotations.SerializedName

data class Business(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: ArrayList<ArticlesItem2>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ArticlesItem2(

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: Any? = null,

	@field:SerializedName("description")
	val description: Any? = null,

	@field:SerializedName("source")
	val source: Source2? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("content")
	val content: Any? = null
)

data class Source2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
