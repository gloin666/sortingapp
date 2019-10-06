package be.javaselectsorteren;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText inputnumbers;
    EditText outputnumbers;
    Button bsort;
    Button ssort;
    Button isort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //invoerveld ids koppelen aan onze code
        inputnumbers = findViewById(R.id.inputgetallen);
        outputnumbers = findViewById(R.id.outputgetallen);
        bsort = findViewById(R.id.bsortBtn);
        ssort = findViewById(R.id.SelectionSort);
        isort = findViewById(R.id.Insertionsort);
        bsort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BubbleSortButtonPressed(view);
            }
        });
        ssort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectSortButtonPressed(view);
            }
        });
        isort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertionSortButtonPressed(view);
            }
        });
    }
    // <<------------------------ BUBBLE SORT ALGORITHM --------------------------------------->>

    // als de knop ingedrukt is gaat hij de ingevoede getallen van 1 string naar een integer omzetten en deze opdelen
    // in verschillende getallen. de code weet wanneer het een nieuw getal is als hij een "," tegen komt.
    public void BubbleSortButtonPressed(View view) {
        String[] numberList = inputnumbers.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];
        for (int i = 0; i < numberList.length; i++) {
            numbers[i] = Integer.parseInt(numberList[i]); // gaat de strings arrays omzetten naar integers.
        }
        // dit zijn de gesorteerde getallen die daarna via setText in het output veld geplaatst worden en via to string dus weet naar een string gaan.
        bubblesort(numbers, numbers.length);
        outputnumbers.setText(Arrays.toString(numbers));
    }

    // hier passen we de bubble sort methode toe
    // hij start met de eerste 2 getallen en kijkt welke de kleinste is en zet deze op de 0 index en de andere op index 1
    // vervolgens gaan we naar index 1 en 2 en doet hij het zelfde maar nu met index positie 1 en 2.
    // dit looped tot alle getallen in de juiste vvolgorden staan in dit geval van klein naar groot.

    private void bubblesort(Integer[] numbers, int length) {
        if (length >= 2) {
            for (int i = 0; i < length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    //verwissel het huidig getal met een kleiner getal.
                    Integer temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
            bubblesort(numbers, length - 1);
        }
    }
    //  <<------------------------ SELECTION SORT ALGORITHM --------------------------------------->>

    public void SelectSortButtonPressed(View view) {
        String[] numberList = inputnumbers.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];
        for (int i = 0; i < numberList.length; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }
        selectionsort(numbers, numbers.length);
        outputnumbers.setText(Arrays.toString(numbers));
}
    // in deze methode gaan we
    private void selectionsort(Integer[] numbers, int length){
        for (int i = 0; i < length-1; i++){
            int minindex = i;
            for (int j = i+1; j < length; j++)
                if (numbers[j] < numbers[minindex]) {
                    minindex = j;
                    int temp = numbers[minindex];
                    numbers[minindex] = numbers[i];
                    numbers[i] = temp;
                }
        }
    }
    //<<---------------------------INSERTION SORT ALGORITHM------------------------------------>>



    public void InsertionSortButtonPressed(View view){
        String[] numberList = inputnumbers.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];
        for (int i = 0; i < numberList.length; i++){
            numbers[i] = Integer.parseInt(numberList[i]);
        }
        insertionsort(numbers,numbers.length);
        outputnumbers.setText(Arrays.toString(numbers));
    }
    private void insertionsort(Integer[] numbers,int length){
        for (int i = 1; i < length; i++){
            int val = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > val) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = val;
        }
    }
}
