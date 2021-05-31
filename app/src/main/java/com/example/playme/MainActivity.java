package com.example.playme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    // Declaring variables.
    Button play;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise variables.
        play = findViewById(R.id.play);
        url = findViewById(R.id.url);

        // Configure On-Click function for the play button.
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  int input = url.getText().length();

                final String urlInput = url.getText().toString();

                // Check for empty fields.
                if(input == 0)
                {
                    Toast.makeText(MainActivity.this, "Please enter a link", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent playVideo = new Intent(MainActivity.this, PlayVideo.class);
                    playVideo.putExtra("url", urlInput);
                    startActivity(playVideo);
                }
            }
        });
    }
}

