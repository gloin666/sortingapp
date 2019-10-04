package be.javaselectsorteren;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText inputnummers;
    EditText outputnummers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputnummers.findViewById(R.id.inputnummers);
        outputnummers.findViewById(R.id.outputnummers);

    }
    public void sorteerknop(View view){
        String[] lijstmetnummers = inputnummers.getText().toString().split(",");
        Integer[]nummers = new Integer[lijstmetnummers.length];
        for (int i=0;i<lijstmetnummers.length; i++){
            nummers[i]= Integer.parseInt(lijstmetnummers[i]);// we vervormen hier de string array in een interger array

        }
        //de gesorteerde getallen uit de onderstaand sorteer functie
        selectsortern(nummers, nummers.length);
        outputnummers.setText(Arrays.toString(nummers));


        }
    private void selectsortern(Integer[]nummers, int length){
        if(length>2){
            return;
        }
        for (int i = 0; i < length-1; i++){
            int minindex = i;
            for(int j = i+1; j <length; j++)
                if (nummers[j] < nummers[minindex])
                    minindex = j;
            int temp = nummers[minindex];
            nummers[minindex] = nummers[i];
            nummers[i] = temp;
        }


    }
}
