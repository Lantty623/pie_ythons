package com.example.myapplication2

import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication2.ui.theme.MyApplication2Theme
import com.chaquo.python.PyException
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import java.lang.Class




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        setContent {
            MyApplication2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //test_python()
                    set_layout()
                }
            }
        }
    }
}

@Composable
fun show_steps(steps: Int) {
    Surface(color = Color.LightGray) {
        Text(text = "You've walked $steps steps!")
    }
}

@Composable
fun show_animal_steps(animal: String, steps: Int) {
    var animal_steps = steps * 100
    Surface(color = Color.Gray) {
        Text(text = "That's the equivalent to $animal_steps $animal steps!")
    }
}

@Composable
fun test_python() {
    val py = Python.getInstance()
    val module = py.getModule("test")
    val t = module.callAttr("test").toJava(String::class.java)
    
    Text(text = t)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun set_layout() {
    Column {
        val animal =  dropdown_menu()
        show_steps(2000)
        show_animal_steps(animal, 2000)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplication2Theme {
        //Greeting("Android")
        //test_python()
        set_layout()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun dropdown_menu(): String {
    val contextForToast = LocalContext.current.applicationContext
    val listItems = arrayOf("Dog", "Cat", "Moose", "Duck", "Elephant")

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    // remember the selected item
    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }

    // box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            label = { Text(text = "Choose an animal") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // filter options based on text field value
        val filteringOptions =
            listItems.filter { it.contains(selectedItem, ignoreCase = true) }

        if (filteringOptions.isNotEmpty()) {
            // menu
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // this is a column scope
                // all the items are added vertically
                filteringOptions.forEach { selectionOption ->
                    // menu item
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = selectionOption
                            Toast.makeText(contextForToast, selectedItem, Toast.LENGTH_SHORT).show()
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }
    return selectedItem.lowercase()
}
