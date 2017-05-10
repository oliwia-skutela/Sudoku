package com.example.oliwia.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Instruction extends AppCompatActivity {

    TextView txtInstruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        txtInstruction=(TextView)findViewById(R.id.txtInstruction);
        String ins="W Sudoku trzeba wypełnić planszę tak, aby w każdym wierszu oraz w każdej kolumnie i w każdym małym kwadracie 3x3 znalazły się cyfry od 1 do 9, gdzie cyfry te nie mogą się powtarzać w żadnym wierszu, kolumnie i małym kwadracie 3x3.\n" +
                "\n" +
                "Sudoku w odróżnieniu od innych łamigłówek nie wymaga od grającego wykonywania rachunków matematycznych, ale logicznego myślenia. Przy rozwiązywaniu planszy wymagana jest cierpliwość i logiczne myślenie.\n" +
                "\n" +
                "Podczas wypełniania planszy należy wpisywać tylko liczby, co do których miejsca jesteśmy pewni, gdyż jeden błąd może spowodować, że gry nie będzie dało się rozwiązać.\n";
        txtInstruction.setText(ins);

    }
}
