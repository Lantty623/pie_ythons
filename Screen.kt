package com.example.myapplication2

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chaquo.python.Python
import com.example.myapplication2.ui.theme.MyApplication2Theme

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    stepViewModel: ViewModelTest = viewModel()
) {
    val stepUiState by stepViewModel.uiState.collectAsState()
    set_layout()
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
        set_layout()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun dropdown_menu(): String {
    val listItems = arrayOf("Dog", "Cat", "Moose", "Duck", "Elephant")
    val contextForToast = LocalContext.current.applicationContext

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
        // text field
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Label") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // this is a column scope
            // all the items are added vertically
            listItems.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption
                    Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT).show()
                    expanded = false
                }) {
                    Text(text = selectedOption)
                }
            }
        }
    }
    return selectedItem.lowercase();
}