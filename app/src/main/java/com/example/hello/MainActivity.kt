package com.example.hello

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.moveToNextImg)
        val image = findViewById<ImageView>(R.id.images)
        val listOfImages= arrayOf(R.drawable.college_friends, R.drawable.back_pic, R.drawable.raining,
            R.drawable.pyramix)

        imageTransition(button, listOfImages, image)
    }
    //function shifts through images through the use of a button
    private fun imageTransition(button: Button, listOfImages: Array<Int>, image:ImageView){
        var imageIndex = 0
        button.setOnClickListener{
            Log.v("nextImg", "Moved to the next Image")
            if(imageIndex < (listOfImages.size - 1)){
                imageIndex += 1
                image.setImageResource(listOfImages[imageIndex])
                Toast.makeText(this,"Moving to the next image", Toast.LENGTH_SHORT).show()
            }
            else{
                imageIndex = 0
                image.setImageResource(listOfImages[imageIndex])
                Toast.makeText(this,"Going back to the first image", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
