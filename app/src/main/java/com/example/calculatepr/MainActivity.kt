package com.example.calculatepr

import android.os.Bundle
import android.text.method.DigitsKeyListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oneEdit = findViewById<EditText>(R.id.editText)
        val twoEdit = findViewById<EditText>(R.id.editText1)
        val threeEdit = findViewById<EditText>(R.id.editText2)


        oneEdit.setKeyListener(DigitsKeyListener.getInstance("0123456789,"));
        twoEdit.setKeyListener(DigitsKeyListener.getInstance("0123456789,"));
        threeEdit.setKeyListener(DigitsKeyListener.getInstance("0123456789,"));

        val oneTextview = findViewById<TextView>(R.id.tv_intersect)
        val twoTextView = findViewById<TextView>(R.id.tv_union)
        val threeTextView = findViewById<TextView>(R.id.tv_max)
        val btn = findViewById<Button>(R.id.btn1)

        val Number1 = oneEdit.text.toString()
        val Number2 = twoEdit.text.toString()
        val Number3 = threeEdit.text.toString()

        btn.setOnClickListener {
            val input: String = oneEdit.getText().toString()
            val input1: String = twoEdit.getText().toString()
            val input2: String = threeEdit.getText().toString()
            //split your input using ","
            val valuesArray = input.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
            val valuesArray1 = input1.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
            val valuesArray2 = input2.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
            val intesect1 = valuesArray.toList().intersect(valuesArray1.toList())
            val intersect_final = intesect1.toList().intersect(valuesArray2.toList())


            val union1 = valuesArray.toList().union(valuesArray1.toList())
            val finall_union = union1.toList().union(valuesArray2.toList())


            /**
             * Displaying Logs
             */
            println(valuesArray.toList())
            println(valuesArray1.toList())
            println(valuesArray2.toList())
            println(intesect1.toList())
            /**
             * appending Values to TextViews
             */
            oneTextview.setText("InterSect of Numbers   :" + intersect_final.toList())
            println("InterSect of Numbers" + intersect_final.toList())

            twoTextView.setText("Union of Numbers   :" + finall_union.toList())
            println("Union of Numbers" + finall_union.toList())

            /**
             * Converting String List to Int List
             */
            val intArray = finall_union.map { it.toInt() }.toIntArray()

            /**
             * Caluculating max Number from Final Union List
             */
            val max = findMaxNumber(intArray)
            threeTextView.setText("Max No From Numbers   :" + max)
            println("Max  of Numbers" + max)

        }


    }

    fun findMaxNumber(array: IntArray): Int {
        var largest = array[0]

        for (element in array) {
            if (element > largest) {
                largest = element
            }
        }

        return largest
    }

}