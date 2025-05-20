package com.example.jetpackcompose

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.espresso.base.Default
import com.example.jetpackcompose.ui.theme.Home
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.greenJc
import com.example.jetpackcompose.ui.theme.search
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    //here the component activity is extended to enable the edge to edge functionality ,lifecycle methods are overridden and controlled and the whole ui is rendered
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("System.out", "onCreate: ")
        //here super.oncreate lets the base onCrate to set up the basic groundwork before execting any custom logic or setting up the ui ,it is called first in the lifecycle methods of the activity .
        enableEdgeToEdge()
        //enableEdgeToEdge lets the layout to be stretched to the edge of the screen
        setContent {
            installSplashScreen();
            //setContent lets us to set the content of the activity ,it is called second in the lifecycle methods of the activity .
            JetpackComposeTheme {
                //scaffold lets us to build the whole structure of the ui and modifier lets us to modify the ui elements
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    //we have a lambda fun here called {} where we have innerpadding which is a param in lambda fun which is setting up the padding for the ui elements ,we are basically calling teh scaffold fun here which is predefined in the kotlin code
//                    // and we are just passing the modifier and a lambda fun innerpadding  to set up the padding for the ui elements i.e greeting in this case and meanwhile greeting is also calling the composable function greeting
//                    //passing the name and modifier to set up the padding for the ui elements so we are doing multiple things here ,and also we are not defining the scaffold here we are just calling it and passing the modifier and a lambda fun innerpadding  to set up the padding for the ui elements
//
                learnNavDrawer()
            }
        }
    }


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun learnNavDrawer() {

        val navigationController = rememberNavController()
        val context = LocalContext.current.applicationContext
        val selected = remember {
            mutableStateOf(Icons.Default.Home)
        }
        val sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember {
            mutableStateOf(false)
        }

        val coroutineScope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)



        ModalNavigationDrawer(
            drawerState = drawerState, gesturesEnabled = true,
            drawerContent = {
                ModalDrawerSheet {
                    Box(modifier = Modifier.background(greenJc).fillMaxWidth().height(150.dp)) {
                        Text(text = "")
                    }
                    Divider()
                    NavigationDrawerItem(
                        label = { Text(text = "Home", color = greenJc) }, selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "home",
                                tint = greenJc,
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Screens.Home.screens) {
                                popUpTo(0)
                            }

                        })
                    NavigationDrawerItem(
                        label = { Text(text = "Setting", color = greenJc) }, selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "home",
                                tint = greenJc,
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Screens.Setting.screens) {
                                popUpTo(0)
                            }

                        })
                    NavigationDrawerItem(
                        label = { Text(text = "Profile", color = greenJc) }, selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "home",
                                tint = greenJc,
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Screens.Profile.screens) {
                                popUpTo(0)
                            }

                        })
                    NavigationDrawerItem(
                        label = { Text(text = "Logout", color = greenJc) }, selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = "home",
                                tint = greenJc,
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()

                        })
                }

            },
        )
        {
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        containerColor = greenJc,
                        contentColor = Color.White,
                    ) {
                        IconButton(onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(Screens.Home.screens) {
                                popUpTo(0)
                            }
                        }, modifier = Modifier.weight(1f)) {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "home",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == Icons.Default.Home) Color.White else Color.Gray
                            )
                        }

                        IconButton(onClick = {
                            selected.value = Icons.Default.Search
                            navigationController.navigate(Screens.search.screens) {
                                popUpTo(0)
                            }
                        }, modifier = Modifier.weight(1f)) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "search",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == Icons.Default.Search) Color.White else Color.Gray
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            FloatingActionButton(onClick = { showBottomSheet = true }) {
                                Icon(Icons.Default.Add, contentDescription = "fab")
                            }
                        }
                        IconButton(onClick = {
                            selected.value = Icons.Default.Notifications
                            navigationController.navigate(Screens.Notification.screens) {
                                popUpTo(0)
                            }
                        }, modifier = Modifier.weight(1f)) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = "home",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.Gray
                            )
                        }

                        IconButton(onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(Screens.Profile.screens) {
                                popUpTo(0)
                            }

                        }, modifier = Modifier.weight(1f)) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "home",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == Icons.Default.Person) Color.White else Color.Gray
                            )
                        }
                    }
                },
                topBar = {
                    val coroutineScope = rememberCoroutineScope()
                    TopAppBar(
                        title = { Text(text = "WhatsApp") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = greenJc,
                            titleContentColor = Color.White,
                            navigationIconContentColor = Color.White,
                            actionIconContentColor = Color.White
                        ),
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(Icons.Rounded.Menu, contentDescription = "Menu")
                            }
                        },
                    )
                }
            ) //scaffold param ends here///////////////////////////////////////////


            { paddingValues ->
                NavHost(
                    navController = navigationController,
                    startDestination = Screens.Home.screens,
                    modifier = Modifier.padding(paddingValues)
                )
                {
                    composable(Screens.Home.screens) { Home() }
                    composable(Screens.Profile.screens) { Profile() }
                    composable(Screens.search.screens) { search() }
                    composable(Screens.Notification.screens) { Notification() }
                    composable(Screens.Post.screens) { Post() }
                    composable(Screens.Setting.screens) { Setting() }
                }

            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize().padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        BottomSheetItem(icon = Icons.Default.ThumbUp, "Create a Post") {
                            showBottomSheet = false
                            navigationController.navigate(Screens.Post.screens) {
                                popUpTo(0)
                            }
                        }
                        BottomSheetItem(
                            icon = Icons.Default.Star,
                            "Create a story"
                        ) { Toast.makeText(context, "Create a story", Toast.LENGTH_SHORT).show() }
                        BottomSheetItem(icon = Icons.Default.ExitToApp, "Close") {
                            Toast.makeText(
                                context,
                                "Close",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        BottomSheetItem(icon = Icons.Default.PlayArrow, "Close") {
                            Toast.makeText(
                                context,
                                "arrow toast",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun BottomSheetItem(icon:ImageVector,title: String, onclick: () -> Unit ){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.clickable{onclick()})
        {
            Icon(imageVector = icon, contentDescription = null , tint = greenJc)
            Text(text = title, color = greenJc, fontSize = 16.sp)
        }
    }



//        val navigationController = rememberNavController()
//        val coroutineScope = rememberCoroutineScope()
//        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//        val context = LocalContext.current.applicationContext
//
//
//        ModalNavigationDrawer(
//            drawerState = drawerState, gesturesEnabled = true,
//            drawerContent = {
//                ModalDrawerSheet {
//                    Box(modifier = Modifier.background(greenJc).fillMaxWidth().height(150.dp)) {
//                        Text(text = "")
//                    }
//                    Divider()
//                    NavigationDrawerItem(
//                        label = { Text(text = "Home", color = greenJc) }, selected = false,
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Default.Home,
//                                contentDescription = "home",
//                                tint = greenJc,
//                            )
//                        },
//                        onClick = {
//                            coroutineScope.launch {
//                                drawerState.close()
//                            }
//                            navigationController.navigate(Screens.Home.screens) {
//                                popUpTo(0)
//                            }
//
//                        })
//                    NavigationDrawerItem(
//                        label = { Text(text = "Setting", color = greenJc) }, selected = false,
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Default.Settings,
//                                contentDescription = "home",
//                                tint = greenJc,
//                            )
//                        },
//                        onClick = {
//                            coroutineScope.launch {
//                                drawerState.close()
//                            }
//                            navigationController.navigate(Screens.Setting.screens) {
//                                popUpTo(0)
//                            }
//
//                        })
//                    NavigationDrawerItem(
//                        label = { Text(text = "Profile", color = greenJc) }, selected = false,
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Default.Person,
//                                contentDescription = "home",
//                                tint = greenJc,
//                            )
//                        },
//                        onClick = {
//                            coroutineScope.launch {
//                                drawerState.close()
//                            }
//                            navigationController.navigate(Screens.Profile.screens) {
//                                popUpTo(0)
//                            }
//
//                        })
//                    NavigationDrawerItem(
//                        label = { Text(text = "Logout", color = greenJc) }, selected = false,
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Default.ExitToApp,
//                                contentDescription = "home",
//                                tint = greenJc,
//                            )
//                        },
//                        onClick = {
//                            coroutineScope.launch {
//                                drawerState.close()
//                            }
//                            Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
//
//                        })
//                }
//
//            },
//            )
//        {
//            Scaffold(
//                topBar = {
//                    val coroutineScope = rememberCoroutineScope()
//                    TopAppBar(
//                        title = { Text(text = "WhatsApp") },
//                        colors = TopAppBarDefaults.topAppBarColors(
//                            containerColor = greenJc,
//                            titleContentColor = Color.White,
//                            navigationIconContentColor = Color.White,
//                            actionIconContentColor = Color.White
//                        ),
//                        navigationIcon = {
//                            IconButton(onClick = {
//                                coroutineScope.launch {
//                                    drawerState.open()
//                                }
//                            }) {
//                                Icon(   Icons.Rounded.Menu, contentDescription = "Menu")
//                            }
//                        },
//                    )
//                }
//            ) {
//                NavHost(
//                    navController = navigationController,
//                    startDestination = Screens.Home.screens
//                ) {
//                    composable(Screens.Home.screens) {
//                        Home()
//                    }
//                    composable(Screens.Profile.screens) {
//                        Profile()
//                    }
//
//                    composable(Screens.Setting.screens) {
//                        Setting()
//                    }
//                }
//            }
//
//        }


    ////////////////////////////////////////////////////////////////




















//        val clickOnText = {
//
//        }
//        Text(
//            text = stringResource(id = R.string.hello_world_form_String)
//            fontSize = 16.sp,
//            fontStyle = FontStyle.Italic,
//            color = Color.Red,
//            modifier = Modifier.padding(16.dp).background(color = Color.Blue)
//                .clickable(onClick = clickOnText)
//        )
//        Column(horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxSize()) {
//            Text("Hello world!")
//            Text("Hello kotlin!")
//
//        }

//        Row(modifier = Modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically) {
//
//            Text("Hello world!")
//            Text("Hello kotlin!")
//
//        }

//        Box(
//            modifier = Modifier.fillMaxSize().background(color = Color.Black)
//        ){
//            Box(modifier = Modifier.height(300.dp).width(300.dp).background(color = Color.Yellow).align(alignment = Alignment.Center)){
//                Text(text = "black and yellow" ,fontSize = 20.sp,
//                    modifier = Modifier.align(Alignment.Center),
//                    color = Color.Black)
//            }
//        }

//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "hello world!")
//        }
//
//        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
//            Text(text="hello kotlin!")
//        }

//        Box(modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.BottomCenter){
//            Text(text = "hello world!")
//        }
//        val context = LocalContext.current
//        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {Toast.makeText(context,"button clicked",Toast.LENGTH_SHORT).show()},
//                modifier = Modifier.padding(16.dp),colors = androidx.compose.material3.ButtonDefaults.buttonColors(Color.Blue
//                 )){
//                Text(text = "click me")
//            }
//        }

//        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//            Image(painter = painterResource(id = R.drawable.gicon), contentDescription = "gicon",)
//        }

//        var age by remember {
//            mutableStateOf(0)
//        }
//
//        Column {
//            Button(onClick ={ age++ }) {
//                Text(text = "I am $age years old")
//            }
//        }

//        val context = LocalContext.current
//        TopAppBar(title = { Text(text = "WhatsApp") },
//            navigationIcon = {
//                IconButton(onClick = { Toast.makeText(this, "whatsapp icon clicked", Toast.LENGTH_SHORT).show() }) {
//                    Icon(painter = painterResource(id = R.drawable.baseline_whatsapp_24), contentDescription = "back")
//                }
//
//            },
//            colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = greenJc,
//                titleContentColor = Color.White,
//                navigationIconContentColor = Color.White,
//                actionIconContentColor = Color.White
//            ),
//            actions = {
//                IconButton(onClick = { Toast.makeText(context, "Profile icon clicked", Toast.LENGTH_SHORT).show() }) {
//                    Icon(painter = painterResource(id = R.drawable.profile), contentDescription = "call")
//                }
//                IconButton(onClick = { Toast.makeText(context, "Profile icon clicked", Toast.LENGTH_SHORT).show() }) {
//                    Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "call")
//                }
//                IconButton(onClick = { Toast.makeText(context, "call icon clicked", Toast.LENGTH_SHORT).show() }) {
//                    Icon(painter = painterResource(id = R.drawable.baseline_call_24), contentDescription = "call")
//                }
//
//            }
//        )

//    override fun onStart() {
//        super.onStart()
//        println("onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        println("onresume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        println("onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        println("onStop")
//    }
//
//
//    override fun onRestart() {
//        super.onRestart()
//        println("onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        println("onDestroy")
//    }


        @Preview(showBackground = true)
        @Composable
        fun showPreview() {
            JetpackComposeTheme {
                learnNavDrawer()
            }
        }

    }
