package com.wreckingballsoftware.chowbubble.ui.menuscreen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.R

@Composable
fun AudioButton(
    modifier: Modifier = Modifier,
    audioOn: Boolean,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier.then(
            Modifier
                .clickable { onClick() }
                .size(40.dp),
        ),
        painter = painterResource(
            id = if (audioOn) R.drawable.sound_on else R.drawable.sound_off
        ),
        contentDescription = stringResource(id = R.string.sound_toggle)
    )
}