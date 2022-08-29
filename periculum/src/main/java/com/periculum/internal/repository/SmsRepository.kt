package com.periculum.internal.repository

import android.database.Cursor
import android.net.Uri
import com.periculum.internal.models.SmsDataModel
import com.periculum.internal.utils.PericulumDependency
import java.util.*
import com.periculum.internal.models.FinancialInstitutions

internal class SmsRepository {

    internal suspend fun getSmsDataFromDevice() : List<SmsDataModel> {
        val smsList = mutableListOf<SmsDataModel>()
        val inboxURI: Uri = Uri.parse("content://sms/inbox")
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.add(Calendar.MONTH, -6)
        val lastSixMonthsInMillis: Long = calendar.timeInMillis
        val cursor: Cursor = PericulumDependency.getApplicationContext().contentResolver.query(inboxURI,
            arrayOf("_id", "thread_id", "address", "date", "date_sent", "protocol", "read", "status", "type", "reply_path_present", "body", "locked", "sub_id", "error_code", "creator", "seen"), "date>=$lastSixMonthsInMillis", null, null)!!

        while (cursor.moveToNext()) {
            val smsData = SmsDataModel(
                id = cursor.getString(0).toInt(),
                threadId = cursor.getString(1).toInt(),
                address = cursor.getString(2),
                date = cursor.getString(3).toLong(),
                dateSent = cursor.getString(4).toLong(),
                protocol = cursor.getString(5).toInt(),
                read = cursor.getString(6).toInt(),
                status = cursor.getString(7).toInt(),
                type = cursor.getString(8).toInt(),
                replyPathPresent = cursor.getString(9).toInt(),
                body = cursor.getString(10),
                locked = cursor.getString(11).toInt(),
                subId = cursor.getString(12).toInt(),
                errorCode = cursor.getString(13).toInt(),
                creator = cursor.getString(14),
                seen = cursor.getString(15).toInt(),
            )
            smsList.add(smsData)
        }
        cursor.close()

        val filteredList = smsList.filter {
            it.address.contains(
                FinancialInstitutions.GTBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.GTBank.institutionShortName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.AccessBank.institutionShortName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.AccessBank.institutionShortName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Opay.institutionShortName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Opay.institutionShortName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ZenithBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ZenithBank.institutionShortName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FCMB.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FCMB.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FidelityBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FidelityBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
            FinancialInstitutions.FirstBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
            FinancialInstitutions.FirstBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
            FinancialInstitutions.UnionBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
            FinancialInstitutions.UnionBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.UnitedBankOfAfrica.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.UnitedBankOfAfrica.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.CitiBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.CitiBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.EcoBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.EcoBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.HeritageBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.HeritageBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.KeystoneBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.KeystoneBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.PolarisBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.PolarisBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.StanbicIBTCBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.StanbicIBTCBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.StandardChartered.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.StandardChartered.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.SterlingBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.SterlingBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.TitanTrustBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.TitanTrustBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.UnityBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.UnityBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.WemaBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.WemaBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.GlobusBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.GlobusBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ParallexBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ParallexBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ProvidusBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ProvidusBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.SunTrustBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.SunTrustBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.JaizBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.JaizBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.LotusBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.LotusBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.TajBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.TajBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.MutualTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.MutualTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.RephidimMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.RephidimMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ShepherdTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.ShepherdTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.EmpireTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.EmpireTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FincaMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FincaMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FinaTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FinaTrustMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.AccionMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.AccionMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.PeaceMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.PeaceMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.InfinityMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.InfinityMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.PearlMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.PearlMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.CovenantMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.CovenantMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.AdvansLaFayetteMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.AdvansLaFayetteMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.SparkleBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.SparkleBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.KudaBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.KudaBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.RubiesBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.RubiesBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.VFDMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.VFDMicrofinanceBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.MintFinexMFBBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.MintFinexMFBBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.MKBMFBBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.MKBMFBBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.CoronationMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.CoronationMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FBNQuestMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FBNQuestMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FSDHMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.FSDHMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.NOVAMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.NOVAMerchantBank.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Bet.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Bet.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Loan.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Loan.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Insurance.institutionName,
                ignoreCase = true
            ) || it.address.contains(
                FinancialInstitutions.Insurance.institutionName,
                ignoreCase = true)
        }


        return filteredList
    }
}