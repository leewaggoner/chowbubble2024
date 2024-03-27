package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.statusbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wreckingballsoftware.chowbubble.domain.spritedata.LifeData
import com.wreckingballsoftware.chowbubble.ui.theme.gameplayBackgroundColor

@Composable
fun StatusBar(lives: List<LifeData>, score: Int, modifier: Modifier = Modifier) {
    StatusBarContent(lives = lives, score = score, modifier = modifier)
}

@Composable
fun StatusBarContent(
    lives: List<LifeData>,
    score: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.then(
            Modifier
                .background(color = Color.Transparent)
                .padding(8.dp)
                .fillMaxWidth(),
        )
    ) {
        Row {
            lives.forEach { lifeData ->
                LifeSprite(
                    lifeData = lifeData
                )
            }
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Bottom),
                text = score.toString(),
                fontSize = 48.sp,
                color = Color.White,
            )
        }
    }
}

@Preview(name = "StatusBar Preview", showBackground = true)
@Composable
fun StatusBarPreview() {
    StatusBarContent(
        modifier = Modifier.background(color = gameplayBackgroundColor),
        lives = listOf(
            LifeData().apply { full = true },
            LifeData(),
            LifeData(),
        ),
        score = 240
    )
}
