package com.example.pertemuan5tugas

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var dropdownTerbuka by remember { mutableStateOf(false) }
    var tampilkanKalender by remember { mutableStateOf(false) }
    var tampilkanHasil by remember { mutableStateOf(false) }

    val skillAndroid = stringResource(R.string.skill_andro)
    val skillUI = stringResource(R.string.skill_ui)
    val skillWeb = stringResource(R.string.skill_web)

    val daftarSkill = listOf(
        skillAndroid,
        skillUI,
        skillWeb
    )

    val skillTerpilih = remember {
        mutableStateListOf<String>()
    }

    val pilihanExperience = listOf(
        stringResource(R.string.exp_1),
        stringResource(R.string.exp_2_3),
        stringResource(R.string.exp_lebih_3)
    )

    val datePickerState = rememberDatePickerState()

    val formValid =
        namaDepan.isNotBlank() &&
                namaBelakang.isNotBlank() &&
                email.isNotBlank()&&
                tanggalLahir.isNotBlank() &&
                experience.isNotBlank() &&
                skillTerpilih.isNotEmpty()

    LaunchedEffect(tampilkanHasil) {
        if (tampilkanHasil) {
            delay(5000)
            tampilkanHasil = false
        }
    }

