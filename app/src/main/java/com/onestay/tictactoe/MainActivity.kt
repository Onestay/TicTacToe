package com.onestay.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butClick(view:View) {
        val clickedBut = view as Button
        var cellID = 0
        when(clickedBut.id) {
            R.id.but1 -> cellID = 1
            R.id.but2 -> cellID = 2
            R.id.but3 -> cellID = 3
            R.id.but4 -> cellID = 4
            R.id.but5 -> cellID = 5
            R.id.but6 -> cellID = 6
            R.id.but7 -> cellID = 7
            R.id.but8 -> cellID = 8
            R.id.but9 -> cellID = 9
        }

        play(cellID, clickedBut)
    }

    val Player1 = ArrayList<Int>()
    val Player2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun play(cellID: Int, clickedBut: Button) {

        if (ActivePlayer == 1) {
            clickedBut.text = "X"
            clickedBut.setBackgroundColor(Color.GREEN)

            Player1.add(cellID)

            ActivePlayer = 2
            AiMove()
        } else {
            clickedBut.text = "O"
            clickedBut.setBackgroundColor(Color.BLUE)

            Player2.add(cellID)

            ActivePlayer = 1
        }
        clickedBut.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2
        }

        // row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2
        }

        // col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2
        }

        // col 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2
        }

        // col 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2
        }


        if (winner != -1) {
            if (winner == 1)
                Toast.makeText(this, "Player 1 won", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Player 2 won", Toast.LENGTH_LONG).show()
        }

    }

    fun AiMove() {
        var emptyCells = ArrayList<Int>()

        (1..9).filterNotTo(emptyCells) { Player1.contains(it) || Player2.contains(it) }

        var r = Random()

        val randIndex = r.nextInt(emptyCells.size -0)+0

        val randCell = emptyCells[randIndex]
        val randButton:Button?

        when(randCell) {
            1 -> randButton = but1
            2 -> randButton = but2
            3 -> randButton = but3
            4 -> randButton = but4
            5 -> randButton = but5
            6 -> randButton = but6
            7 -> randButton = but7
            8 -> randButton = but8
            9 -> randButton = but9
            else ->
                    randButton = but1

        }

        play(randCell, randButton)

    }
}
