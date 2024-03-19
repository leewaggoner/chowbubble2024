package com.wreckingballsoftware.chowbubble.ui.menuscreen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.R

@Composable
fun InstructionsButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier.then(
            Modifier
                .height(40.dp)
                .clickable { onClick() },
        ),
        painter = painterResource(id = R.drawable.instructions_button),
        contentDescription = stringResource(id = R.string.instructions)
    )
}