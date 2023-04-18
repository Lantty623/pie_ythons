package com.example.animalstepper.navigation.screen

//import com.chaquo.python.Python
import android.app.Activity
import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.animalstepper.R
import com.example.animalstepper.data.Animal
import com.example.animalstepper.data.CatAPI
import com.example.animalstepper.navigation.theme.AnimalStepperTheme


@Composable
fun StepScreen(
    //modifier: Modifier = Modifier,
    //stepViewModel: StepViewModel = viewModel(),
    steps: Long?,
    lengthUnit: String,
    url : String
) {
    set_layout(steps, lengthUnit, url)
}


@Composable
fun show_steps(steps: Long?) {
    Surface(color = Color.LightGray) {
        Text(text = "You've walked $steps steps!")
    }
}

@Composable
fun show_animal_steps(animal: String, steps: Long?, lengthUnit: String) {
    //var animal_steps = steps?.times(100)
    var animalsteps = 0.0

    if(steps != null) {
        when (animal) {
            "cat" -> animalsteps = Animal.human_to_cat(steps, lengthUnit)
            "elephant" -> animalsteps = Animal.human_to_elephant(steps, lengthUnit)
            "horse" -> animalsteps = Animal.human_to_horse(steps, lengthUnit)
            "large dog" -> animalsteps = Animal.human_to_ldog(steps, lengthUnit)
            "medium dog" -> animalsteps = Animal.human_to_mdog(steps, lengthUnit)
            "small dog" -> animalsteps = Animal.human_to_sdog(steps, lengthUnit)
            "kangaroo" -> animalsteps = Animal.human_to_kangaroo(steps, lengthUnit)
        }
    }

    Surface(color = Color.Gray) {
        Text(text = "That's the equivalent to $animalsteps $animal steps!")
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
fun set_layout(steps: Long?, lengthUnit: String, url: String) {
    Column {
        val animal =  dropdown_menu()
        show_steps(steps)
        show_animal_steps(animal, steps, lengthUnit)
        show_animal_picture(url)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimalStepperTheme {
        //Greeting("Android")
        //test_python()
        set_layout(steps = 2000, lengthUnit = "cm", animal_picture = )
    }
}
 */

@Composable
fun show_animal_picture(url: String) {
    println("\n\n\n url = $url \n\n\n")
    AsyncImage(
        model = url,
        contentDescription = null
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun dropdown_menu(): String {
    val contextForToast = LocalContext.current.applicationContext
    //val listItems = arrayOf("Cat", "Elephant", "Horse", "Large Dog", "Medium Dog", "Small Dog", "Kangaroo")
    val listItems = Animal.ANIMAL_LIST

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
