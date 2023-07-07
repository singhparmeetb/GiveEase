package com.example.virtusa

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.virtusa.ui.theme.comfortaabold

@Composable
fun CategoryCard(category: Category) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp)
            .background(category.backgroundColor, RoundedCornerShape(25.dp))
    ){ Column(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(category.image),
                contentDescription = null, // Provide a proper content description
                modifier = Modifier
                    .size(70.dp)
            )
            Text(
                fontSize=15.sp, fontFamily= comfortaabold,
                text = category.title,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun NGOCard(ngo: NGO) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(horizontal = 18.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(ngo.backgroundColor)
            .clickable {
                openInAppBrowser(context,ngo.url)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(ngo.image),
                contentDescription = null, // Provide a proper content description
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
            Text(
                text = ngo.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold, fontSize=18.sp, fontFamily= comfortaabold,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .weight(2f) // Occupy 2/3rd of the row width
                    .wrapContentWidth(Alignment.End)
            )
        }
    }
}


fun openInAppBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Composable
fun MainScreen(navController: NavController) {
    val categories = listOf(
        Category("Books", R.drawable.books, Color(0xfff02c64)),
        Category("Money", R.drawable.money, Color(0xFFFFFC5C)),
        Category("Food", R.drawable.food, Color(0xff688cf0))
    )
    val ngos = listOf(
        NGO("Suvidha Foundation", R.drawable.suvidha, Color(0xffe0fc4c),"https://suvidhafoundationedutech.org/about.php"),
        NGO("CRY Foundation", R.drawable.cry_foundation, Color(0xff70dcf4),"https://www.cry.org/about-cry/"),
        NGO("Rural Development Foundation (RDF)", R.drawable.rdf, Color(0xfff86c94),"https://rdfindia.org/about/"),
        NGO("ISKCON Food Relief Foundation", R.drawable.iskon, Color.Magenta,"https://iskconfoodrelief.com/"),
    )

    Column(modifier=Modifier.background(color = Color(0xfffffdd0))) {
        Text(
            text="Categories",
            fontFamily = comfortaabold,
            fontSize = 35.sp,
            modifier=Modifier.padding(start=20.dp, top=12.dp, bottom=8.dp)
        )

        LazyRow (
            modifier = Modifier.padding(start=5.dp, bottom=10.dp)
                ){
            items(categories) { category ->
                CategoryCard(category = category)
            }
        }
        Text(
            text="NGO's",
            fontFamily = comfortaabold,
            fontSize = 35.sp,
            modifier=Modifier.padding(start=20.dp, top=1.dp, bottom=8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(100.dp))
        )

        LazyColumn(modifier= Modifier.background(color=Color(0xfffaf0e6)).padding(top=10.dp)) {
            items(ngos) { ngo ->
                NGOCard(ngo = ngo)
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
