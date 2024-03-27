package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.statusbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.R
import com.wreckingballsoftware.chowbubble.domain.spritedata.LifeData

@Composable
fun LifeSprite(lifeData: LifeData, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.then(Modifier
            .width(lifeData.size.x.dp)
            .height(lifeData.size.y.dp),
        )
    ) {
        if (lifeData.visible) {
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = if (lifeData.full) {
                    painterResource(id = R.drawable.life_full)
                } else {
                    painterResource(id = R.drawable.life_empty)
                },
                contentDescription = ""
            )
        }
    }
}

@Preview(name = "LifeSprite Preview", showBackground = true)
@Composable
fun LifeSpritePreview() {
    LifeSprite(lifeData = LifeData().apply { visible = false })
}
