package com.moscow.travel.hack.presentation.ui.recommendation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscow.travel.hack.BuildConfig
import com.moscow.travel.hack.domain.entity.hotels
import com.moscow.travel.hack.domain.entity.places
import com.moscow.travel.hack.presentation.view.HotelCard
import com.moscow.travel.hack.presentation.view.SelectedPlaceCard
import com.moscow.travel.hack.presentation.view.SexyButton
import ru.cloudpayments.sdk.configuration.CloudpaymentsSDK
import ru.cloudpayments.sdk.configuration.PaymentConfiguration
import ru.cloudpayments.sdk.configuration.PaymentData
import ru.cloudpayments.sdk.models.Transaction

class MyCloudPaymentsIntentSender : ActivityResultContract<PaymentConfiguration, Transaction>() {
    override fun createIntent(context: Context, input: PaymentConfiguration): Intent {
        return CloudpaymentsSDK.getInstance().getStartIntent(context, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Transaction {
        if (resultCode == Activity.RESULT_OK) {
            val id = intent?.getIntExtra(CloudpaymentsSDK.IntentKeys.TransactionId.name, 0) ?: 0
            val status =
                intent?.getSerializableExtra(CloudpaymentsSDK.IntentKeys.TransactionStatus.name) as? CloudpaymentsSDK.TransactionStatus
            val reasonCode =
                intent?.getIntExtra(CloudpaymentsSDK.IntentKeys.TransactionReasonCode.name, 0) ?: 0
            return Transaction(id, status, reasonCode)
        }

        return Transaction(0, null, 0)
    }
}

@Composable
fun SummaryScreen(
) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(MyCloudPaymentsIntentSender()) {
        if (it.status != null) {
            if (it.status == CloudpaymentsSDK.TransactionStatus.Succeeded) {
                Toast.makeText(
                    context,
                    "Успешно!",
                    Toast.LENGTH_SHORT
                ).show()
//                onSuccess()
//                viewModel.fetchPoints()
            } else {
                if (it.reasonCode != 0) {
                    Toast.makeText(
                        context,
                        "Ошибка!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Ошибка!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
//                onError()
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    "Отель:",
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                HotelCard(hotel = hotels[0], onHotelClick = {})
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Места:",
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(
                        onClick = { },
                        modifier = Modifier
                    ) {
                        Text("Добавить", color = Color.Black)
                    }
                }
            }
            items(places) {
                SelectedPlaceCard(place = it, onPlaceClick = {})
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
        SexyButton(
            onClick = {
                launcher.launch(
                    PaymentConfiguration(
                        paymentData = PaymentData(
                            BuildConfig.CLOUDPAYMENTS_PUBLIC_ID,
                            "15678",
                            currency = "RUB",
//                            jsonData = hashMapOf(
//                                "userId" to viewModel.profileId.value.toString(),
//                                "points" to points
//                            )
                        ),
                        scanner = null
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 48.dp)
                .padding(bottom = 24.dp),
            name = "Оплатить 15.678 руб"
        )
    }
}