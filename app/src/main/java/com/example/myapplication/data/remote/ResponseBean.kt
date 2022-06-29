package com.example.myapplication.data.remote

data class ResponseBean(
    val address: String? = null,
    val area: Double? = null,
    val area_bino: Double? = null,
    val area_jilaya: Double? = null,
    val ban_info: String? = null,
    val cad_number: String? = null,
    val code: Int? = null,
    val cost: String? = null,
    val count_subjects: Int? = null,
    val date: String? = null,
    val district_id: Int? = null,
    val has_ban: String? = null,
    val number: String? = null,
    val object_type: String? = null,
    val region_id: Int? = null,
    val subjects: List<String>? = null,
)
