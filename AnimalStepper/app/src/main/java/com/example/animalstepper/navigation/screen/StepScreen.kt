package com.example.animalstepper.navigation.screen

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
//import com.chaquo.python.Python
import com.example.animalstepper.navigation.theme.AnimalStepperTheme

@Composable
fun StepScreen(
    modifier: Modifier = Modifier,
    stepViewModel: ViewModelTest = viewModel()
) {
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

/*
@Composable
fun test_python() {
    val py = Python.getInstance()
    val module = py.getModule("test")
    val t = module.callAttr("test").toJava(String::class.java)

    Text(text = t)
}
 */

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
    AnimalStepperTheme {
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
