package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.R
import com.wreckingballsoftware.chowbubble.domain.spritedata.FallingObjectData

@Composable
fun FallingObjectSprite(spriteData: FallingObjectData, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.then(Modifier
            .offset(x = spriteData.xOffset, y = spriteData.yOffset)
            .width(spriteData.size.x.dp)
            .height(spriteData.size.y.dp),
        )
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = spriteData.spriteId),
            contentDescription = ""
        )
    }
}

@Preview(name = "FallingObjectSprite Preview", showBackground = true)
@Composable
fun FallingObjectSpritePreview() {
    FallingObjectSprite(spriteData = FallingObjectData().apply { spriteId = R.drawable.bubble_tea_green })
}
