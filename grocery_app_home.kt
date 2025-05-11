import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.untitled.R
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MarketHomeScreenPreview() {
    MarketHomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketHomeScreen() {
    val scaffoldState = rememberBottomSheetScaffoldState()

    Scaffold(
        topBar = { MarketTopBar() },
        bottomBar = { MarketBottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item { DeliveryAddressBar() }
            item { MainPromotion() }
            item { SearchBar() }
            item { CategoryRow() }
            item { 
                Text(
                    text = "Recommended Products",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item { ProductGrid() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketTopBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pic),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "pupilica",
                    color = Color(0xFF5C3EBC),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Account",
                    tint = Color(0xFF5C3EBC)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun DeliveryAddressBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "Location",
            tint = Color(0xFF5C3EBC)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = "Delivery to",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = "Dr. Divinity St. No. 24, Antalya",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        }
        Text(
            text = "30 min",
            color = Color(0xFF5C3EBC),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFFE7E2F3))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun MainPromotion() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF5C3EBC))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Refer friends to pupilica",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "55 TL",
                color = Color.Yellow,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "for each",
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow
                ),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text(
                    text = "JOIN NOW",
                    color = Color(0xFF5C3EBC),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search products") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color(0xFF5C3EBC)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color(0xFF5C3EBC),
            unfocusedIndicatorColor = Color.LightGray,
            focusedLeadingIconColor = Color(0xFF5C3EBC),
            unfocusedLeadingIconColor = Color.Gray
        ),
        shape = RoundedCornerShape(8.dp),
        singleLine = true
    )
}

@Composable
fun CategoryRow() {
    val categories = listOf(
        CategoryItem("Produce", R.drawable.pic),
        CategoryItem("Bakery", R.drawable.pic),
        CategoryItem("Dairy", R.drawable.pic),
        CategoryItem("Meat", R.drawable.pic),
        CategoryItem("Snacks", R.drawable.pic),
        CategoryItem("Beverages", R.drawable.pic),
        CategoryItem("Fruit", R.drawable.pic),
        CategoryItem("Vegetables", R.drawable.pic)
    )

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category)
            }
        }
    }
}

@Composable
fun CategoryItem(category: CategoryItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(72.dp)
            .clickable { /* TODO */ }
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color(0xFFF3F0FE))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.name,
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = category.name,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

@Composable
fun ProductGrid() {
    val products = listOf(
        ProductItem("Apple", "2.99", R.drawable.pic),
        ProductItem("Bread", "1.49", R.drawable.pic),
        ProductItem("Milk", "3.25", R.drawable.pic),
        ProductItem("Tomato", "1.99", R.drawable.pic),
        ProductItem("Cheese", "4.50", R.drawable.pic),
        ProductItem("Eggs", "3.99", R.drawable.pic),
        ProductItem("Water", "0.99", R.drawable.pic),
        ProductItem("Pasta", "1.75", R.drawable.pic)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(320.dp)
    ) {
        items(products) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun ProductCard(product: ProductItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clickable { /* TODO */ },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$${product.price}",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5C3EBC),
                fontSize = 14.sp
            )
            Text(
                text = product.name,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                maxLines = 2,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun MarketBottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White
    ) {
        val items = listOf(
            NavigationBarItem("Home", Icons.Default.Home),
            NavigationBarItem("Search", Icons.Default.Search),
            NavigationBarItem("Cart", Icons.Default.ShoppingCart),
            NavigationBarItem("List", Icons.Default.List),
            NavigationBarItem("Profile", Icons.Default.Person)
        )
        
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = item.title == "Home",
                onClick = { /* TODO */ },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF5C3EBC),
                    selectedTextColor = Color(0xFF5C3EBC),
                    indicatorColor = Color.White
                )
            )
        }
    }
}

// Data classes
data class CategoryItem(val name: String, val imageRes: Int)
data class ProductItem(val name: String, val price: String, val imageRes: Int)
data class NavigationBarItem(val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
