package e.hemant.easymeds;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        //Set Event

        setSingleEvent(mainGrid);

        //setToggleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i=0; i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0){
                        Intent intent=new Intent(MainActivity.this,CameraActivity.class);
                        startActivity(intent);
                    }else if(finalI==1){
                        Intent intent=new Intent(MainActivity.this,NonPrescription.class);
                        startActivity(intent);
                    }else if(finalI==2){
                        Intent intent=new Intent(MainActivity.this,PreviousOrder.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                    }
                }
            });


    }
    }

    private void setToggleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6FOO"));
                        Toast.makeText(MainActivity.this, "State : TRUE", Toast.LENGTH_SHORT).show();
                    } else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }
}