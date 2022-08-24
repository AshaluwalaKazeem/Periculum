package com.periculum.internal.models

sealed class FinancialInstitutions(val institutionName: String, val institutionShortName: String) {
    object GTBank: FinancialInstitutions(institutionName = "GTBank", institutionShortName = "GT")
    object AccessBank: FinancialInstitutions(institutionName = "AccessBank", institutionShortName = "Access")
    object ZenithBank: FinancialInstitutions(institutionName = "ZenithBank", institutionShortName = "Zenith")
    object FCMB: FinancialInstitutions(institutionName = "FCMB", institutionShortName = "FCMB")
    object Opay: FinancialInstitutions(institutionName = "OPAY", institutionShortName = "Opay")
}