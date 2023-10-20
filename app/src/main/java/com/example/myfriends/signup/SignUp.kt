package com.example.myfriends.signup

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfriends.R

@Composable
@Preview(device = Devices.PIXEL_4)
fun SignUp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        ScreenTitle(R.string.create_an_account)

        Spacer(modifier = Modifier.height(32.dp))

        EmailField(value = email, onValueChange = { email = it })

        Spacer(modifier = Modifier.height(8.dp))

        PasswordField(value = password, onValueChange = { password = it })

        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
            Text(text = stringResource(id = R.string.signUp))
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PasswordField(value: String, onValueChange: (String) -> Unit) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    val visualTransformation = if (isVisible) VisualTransformation.None else {
        PasswordVisualTransformation()
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        trailingIcon = {
            visibilityToggle(isVisible) {
                isVisible = !isVisible
            }
        },
        visualTransformation = visualTransformation,
        label = { Text(text = stringResource(id = R.string.password)) },
        onValueChange = onValueChange
    )
}

@Composable
private fun visibilityToggle(isVisible: Boolean, onToggle: () -> Unit) {
    val resource = if (isVisible) R.drawable.ic_invisible else R.drawable.ic_visible
    IconButton(onClick = { onToggle() }) {
        Icon(
            painter = painterResource(id = resource),
            contentDescription = stringResource(id = R.string.toggle_visibility)
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun EmailField(
    value: String, onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = { Text(text = stringResource(id = R.string.email)) },
        onValueChange = onValueChange
    )
}

@Composable
private fun ScreenTitle(@StringRes resource: Int) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(resource), style = typography.headlineLarge
        )

    }
}