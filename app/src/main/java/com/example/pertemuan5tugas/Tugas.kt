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

    Box(modifier = modifier.fillMaxSize()
            .background(colorResource(R.color.putih_latar))
    ) {
        Column(modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Image(painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .height(dimensionResource(R.dimen.tinggi_header))
            )

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
                    .offset(y = -dimensionResource(R.dimen.tumpukan_card)
                    ),
                shape = RoundedCornerShape(topStart =
                    dimensionResource(R.dimen.radius_card
                    ),
                    topEnd = dimensionResource(R.dimen.radius_card
                    )
                ),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = colorResource(id = R.color.putih)
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation =  dimensionResource(R.dimen.elevasi_card_form)
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = dimensionResource(
                                R.dimen.padding_card
                            ),
                            vertical = dimensionResource(
                                R.dimen.padding_sedang
                            )
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = stringResource(R.string.form),
                        color = colorResource(id = R.color.ungu_judul),
                        fontSize = dimensionResource(R.dimen.font_judul).value.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_judul))
                    )

                    Text(
                        text = stringResource(R.string.kata_bawah
                        ),
                        color = colorResource(id = R.color.abu_teks),
                        fontSize = dimensionResource(id = R.dimen.font_petunjuk).value.sp,
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_petunjuk))
                    )

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_field_nama)                        )
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = {
                                namaDepan = it
                                tampilkanHasil = false
                            },
                            modifier = Modifier.weight(1f),
                            label = {
                                Text(stringResource(R.string.nama_depan
                                    )
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.radius_input
                                )
                            )
                        )

                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = {
                                namaBelakang = it
                                tampilkanHasil = false
                            },
                            modifier = Modifier.weight(1f),
                            label = {
                                Text(stringResource(                                     R.string.nama_belakang
                                    )
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.radius_input
                                )
                            )
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_field))
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            tampilkanHasil = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(stringResource(R.string.email)
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.radius_input
                            )
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_field))
                    )

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.jarak_field_nama)
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        OutlinedTextField(
                            value = tanggalLahir,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier.weight(1f),
                            label = {
                                Text(
                                    stringResource(R.string.tgl_lahir
                                    )
                                )
                            },
                            trailingIcon = {
                                TextButton(
                                    onClick = {
                                        tampilkanKalender = true
                                    }
                                ) {
                                    Text(
                                        text = stringResource(R.string.kalender_ikon
                                        ),
                                        color = colorResource(id = R.color.hitam),
                                        fontSize = dimensionResource(id = R.dimen.font_ikon).value.sp,
                                    )
                                }
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.radius_input
                                )
                            )
                        )

                        ExposedDropdownMenuBox(
                            expanded = dropdownTerbuka,
                            onExpandedChange = {
                                dropdownTerbuka = it
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = {},
                                readOnly = true,
                                modifier = Modifier.menuAnchor(
                                        MenuAnchorType.PrimaryNotEditable
                                    )
                                    .fillMaxWidth(),
                                label = {
                                    Text(
                                        stringResource(R.string.experience
                                        )
                                    )
                                },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = dropdownTerbuka
                                        )
                                },
                                singleLine = true,
                                shape = RoundedCornerShape(
                                    dimensionResource(R.dimen.radius_input
                                    )
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = dropdownTerbuka,
                                onDismissRequest = {
                                    dropdownTerbuka = false
                                }
                            ) {
                                pilihanExperience.forEach { pilihan ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(pilihan)
                                        },
                                        onClick = {
                                            experience = pilihan
                                            dropdownTerbuka = false
                                            tampilkanHasil = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_skill))
                    )

                    Text(
                        text = stringResource(R.string.pilih_skill
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.hitam),
                        fontSize = dimensionResource(id = R.dimen.font_skill_label).value.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_judul))
                    )

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        daftarSkill.forEach { skill ->
                            Row(verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = skill in skillTerpilih,
                                    onCheckedChange = { checked ->
                                        if (checked) {
                                            skillTerpilih.add(skill)
                                        } else {
                                            skillTerpilih.remove(skill)
                                        }

                                        tampilkanHasil = false
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.ungu_judul),
                                        uncheckedColor = colorResource(id = R.color.abu_teks),
                                        checkmarkColor = colorResource(id = R.color.putih)
                                    )
                                )

                                Text(
                                    text = skill,
                                    color = colorResource(id = R.color.hitam),
                                    fontSize = dimensionResource(id = R.dimen.font_skill).value.sp,
                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(dimensionResource(R.dimen.jarak_tombol))
                    )
