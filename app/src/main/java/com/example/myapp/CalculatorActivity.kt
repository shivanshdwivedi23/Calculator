package com.example.myapp
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import com.example.myapp.R
import java.util.concurrent.ExecutionException

class CalculatorActivity:AppCompatActivity() {
    lateinit var one:TextView
    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView
    lateinit var zero:TextView

    lateinit var plus:TextView
    lateinit var subtract:TextView
    lateinit var multiply:TextView
    lateinit var divide:TextView
    lateinit var mod:TextView
    lateinit var equals:TextView
    lateinit var change_sign:TextView
    lateinit var point:TextView
    lateinit var result:TextView
    lateinit var ac:TextView
    lateinit var expression:TextView
    lateinit var backspace:ImageView
//    var oneText:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)

        plus= findViewById(R.id.plus)
        subtract = findViewById(R.id.subtract)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        mod = findViewById(R.id.mod)
        equals = findViewById(R.id.equals)
        change_sign = findViewById(R.id.change_sign)
        point = findViewById(R.id.point)
        ac = findViewById(R.id.ac)
        backspace = findViewById(R.id.backspace)
        result = findViewById(R.id.result)
        expression = findViewById(R.id.expression)

    one.setOnClickListener{
        appendText("1",true)
    }
    two.setOnClickListener{
        appendText("2",true)
    }
    three.setOnClickListener{
        appendText("3",true)
    }
    four.setOnClickListener{
        appendText("4",true)
    }
    five.setOnClickListener{
        appendText("5",true)
    }
    six.setOnClickListener{
        appendText("6",true)
    }
    seven.setOnClickListener{
        appendText("7",true)
    }
    eight.setOnClickListener{
        appendText("8",true)
    }
    nine.setOnClickListener{
        appendText("9",true)
    }
    zero.setOnClickListener{
        appendText("0",true)
    }
    point.setOnClickListener{
        appendText(".",true)
    }

    plus.setOnClickListener{
        appendText("+", false)
    }
    subtract.setOnClickListener{
        appendText("-",false)
    }
    multiply.setOnClickListener{
        appendText("*",false)
    }
    divide.setOnClickListener{
        appendText("/",false)
    }
    mod.setOnClickListener{
        appendText("%",false)
    }
    equals.setOnClickListener{
        try{
      val expr=ExpressionBuilder(expression.text.toString()).build()
            val answer=expr.evaluate()
            result.text=answer.toString()
        }
        catch(e:Exception){
          result.text=e.message
        }
    }
    backspace.setOnClickListener{
        result.text=""
        result.hint=""
        val value=expression.text
        if(value.isNotEmpty()){
            expression.text = value.substring(0,value.length-1)
        }
    }
    ac.setOnClickListener{
        expression.text=""
        result.text=""

    }

    }

   private fun appendText(value: String, toBeCleared: Boolean){
        if(result.text !=""){
            expression.text=""
        }
        if(toBeCleared){
            result.text=""
            expression.append(value)
        }
        else{
            expression.append(result.text)
            expression.append(value)
            result.text =""
        }
    }

}