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
    // dit looped tot alle getallen in de juiste volgorden staan in dit geval van klein naar groot.
    // bubble gaat paren vergelijken en de grote getallen laten opschuiven naar boven. zoals een lucht bel.

    private void bubblesort(Integer[] numbers, int length) {
        // base case als dit true is stopt de loop als er dus niet meer moet verwisseld worden.
        if (length >= 2) {
            for (int i = 0; i < length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    //verwissel het huidig getal met een kleiner getal.
                    Integer temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
            // elke keer als de loop een getal op de juiste index zet gaat hij de array - 1 index opnieuw uitvoeren door dat deze op de juiste plaats staat.
            // na het aftrekken van de juiste index roept de functie zichzelf terug op tot de base case juist is.
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
    // in deze methode gaan we kijken naar de eerste index 0 en gaan we index 1 vergelijken met index 0.
    // als index 0 groter is voegen we index 1 toe aan de nieuwe lijst als gesorteerd item en O gaat dan naar 1.
    // indien dit niet zo is daat het algoritme kijken naar het volgende getal tot hij een getal vind dat kleiner is.
    // we zetten hier elke keer het kleinste getal naar index 0 or de volgende index waar dit getal het kleinste is.
    //dit looped tot alles op de juiste plaats staat.
    // kort zoek naar het kleinste getal en verwissel het met het huidige getal

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

    //in dit algoritme gaan we 1 getal nemen en dit vergelijken met alle getallen aan zijn linker kant.
    // als het getal kleinder is dan schuift dit op naar de tijdelijk juist gesorteerde lijst.
    // dus aan de linker kant hebben we een tijdelijke lijst die juist is geordent en aan de rechter kant ongeordent.
    // diet looped tot alles juist staat.


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
