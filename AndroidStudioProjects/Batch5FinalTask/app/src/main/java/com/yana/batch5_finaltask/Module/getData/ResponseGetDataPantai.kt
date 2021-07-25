package com.yana.batch5_finaltask.Module.getData

import com.google.gson.annotations.SerializedName

data class ResponseGetDataPantai(

	@field:SerializedName("data")
	val data: List<DataItemPantai>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

data class DataItemPantai(

	@field:SerializedName("nama_pantai")
	val namaPantai: String? = null,

	@field:SerializedName("provinsi")
	val provinsi: String? = null,

	@field:SerializedName("lokasi_pantai")
	val lokasiPantai: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
