package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val `employeeSalary`: Int,
    @SerializedName("employee_age")
    val employeeAge: Int,
    @SerializedName("employee_age")
    val profileImage: String
)
