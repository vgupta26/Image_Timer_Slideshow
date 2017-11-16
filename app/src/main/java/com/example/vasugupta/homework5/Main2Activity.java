package com.example.vasugupta.homework5;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends Activity {
    ImageView cityimage;
    int iterator =0;
    TextView name;

    TextView  descrip;
    String[] citynames = {"Bangalore", "Beijing", "Chicago", "London",
            "New York", "Paris", "San Francisco", "Seoul",
            "Shanghai", "Tokyo", "Toronto", "Vancouver"};
    Integer[] imageid = {R.drawable.banglore, R.drawable.beijing, R.drawable.chicago,
            R.drawable.london, R.drawable.newyork, R.drawable.paris,
            R.drawable.sanfrancisco, R.drawable.seoul,
            R.drawable.shangai, R.drawable.tokyo, R.drawable.toronto,
            R.drawable.vancouver};
    String[] description = {"Bengaluru (also called Bangalore) is the capital of India's southern Karnataka state." +
            "The center of India's high-tech industry, the city is also known for its parks and nightlife. "
            , "Beijing, China’s massive capital, has history stretching back 3 millennia. "
            , "Chicago, on Lake Michigan in Illinois, is among the largest cities in the U.S. Famed for its bold architecture," +
            " it has a skyline punctuated by skyscrapers"
            , "London, the capital of England and the United Kingdom, is a 21st-century city with history stretching back to Roman times."
            , "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. "
            , "Paris, France's capital, is a major European city and a global center for art, fashion," +
            " gastronomy and culture. Its 19th-century cityscape is crisscrossed by wide boulevards and the River Seine"
            , "San Francisco, in northern California, is a hilly city on the tip of a peninsula surrounded by the Pacific Ocean and San Francisco Bay."
            , "Seoul, the capital of South Korea, is a huge metropolis where modern skyscrapers, " +
            "high-tech subways and pop culture meet Buddhist temples, palaces and street markets."
            , "Shanghai, on China’s central coast, is the country's biggest city and a global financial hub."
            , "Tokyo, Japan’s busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples."
            , "Toronto, the capital of the province of Ontario, is a major Canadian city along Lake Ontario’s northwestern shore."
            , "Vancouver, a bustling west coast seaport in British Columbia, is among Canada’s densest, most ethnically diverse cities." +
            "A popular filming location, it’s surrounded by mountains, and also has thriving art, theatre and music scenes."
    }
    ;
    private final Handler myHandler = new Handler();
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b = getIntent().getExtras();
        String Text = b.getString("vasu");
        val = Integer.valueOf(Text);
        cityimage = findViewById(R.id.cityimg);
        name = findViewById(R.id.name);
        descrip = findViewById(R.id.desc);
        myHandler.postDelayed(myRunnable, val*1000);
    }

    public Runnable myRunnable = new Runnable() {
        public void run() {

            if(iterator <imageid.length)
                {
                    // task to be run based a timer
                    cityimage.setImageResource(imageid[iterator]);
                    descrip.setText(description[iterator]);
                    name.setText(citynames[iterator]);
                    iterator++;
                    showToast();
                }

            if (iterator ==imageid.length)
                {
                    iterator =0;
                }
            myHandler.postDelayed(this, val*1000);
                }

    };
    public void showToast() {
        final Toast mToastToShow;
        // Set the toast and duration
        int toastDurationInMilliSeconds = val*1000;
        mToastToShow = Toast.makeText(this, "Index -->  " + String.valueOf(iterator) , Toast.LENGTH_SHORT);

        // Set the countdown to display the toast
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                mToastToShow.show();
            }
            public void onFinish() {
                mToastToShow.cancel();
            }
        };

        // Show the toast and starts the countdown
        mToastToShow.show();
        toastCountDown.start();
    }

    @Override
    public void onBackPressed()
    {myHandler.removeCallbacks(myRunnable);
        super.onBackPressed();}
    @Override
    protected void onResume()
    {super.onResume();}
    @Override
    protected void onPause()
    { myHandler.removeCallbacks(myRunnable);
        super.onPause();}
    @Override
    protected void onStop()
    {super.onStop();}
    @Override
    protected void onDestroy()
    {super.onDestroy();}
}
