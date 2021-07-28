package com.yana.batch5_finaltask.Module.getData

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseGetDataHewan(

	@field:SerializedName("data")
	val data: List<DataItemHewan>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

@Parcelize
data class DataItemHewan(

	@field:SerializedName("nama_hewan")
	val namaHewan: String? = null,

	@field:SerializedName("cara_berjalan")
	val caraBerjalan: String? = null,

	@field:SerializedName("jenis")
	val jenis: String? = null,

	@field:SerializedName("id")
	val id: String? = null
): Parcelable
