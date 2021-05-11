package com.hieudv.cloudlawai.data.api.response

data class LoginResponse(
    val status: String,
    val data: LoginData,
    val code: String,
    val message: String
)

data class LoginData(
    val user: User,
    val token: String
)

data class User(
    val userID: Int,
    val myLFID: Int,
    val isMobileUser: Int,
    val loginID: String,
    val lawFirmList: List<LawFirm>,
    val myLawFirmInfo: LawFirmInfo
)

data class LawFirm(
    val lawFirmID: Int,
    val lawFirmBrand: String,
    val lawFirmLogoURL: String,
    val isActive: Int
)

data class LawFirmInfo(
    val lawFirmID: Int,
    val lawFirmBrand: String,
    val lawFirmLogoURL: String,
    val lawFirmMailLogoURL: String,
    val webSiteURL: String,
    val representativeName: String,
    val officeMobilePhoneNumber: String,
    val officePhoneNumber: String,
    val corRegNumber: String,
    val isActive: Int
)