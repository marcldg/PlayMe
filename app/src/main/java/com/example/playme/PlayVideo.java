package com.example.playme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideo extends YouTubeBaseActivity {

    // Declare variables.
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer originalYouTubePlayer;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        // Get Url from main activity.
        Intent getUrl = getIntent();
        String url = getUrl.getStringExtra("url");

        // Setup the player.
        youtubeSetup(url);
    }

    // Function to setup the player.
    public void youtubeSetup(String link)
    {
        youTubePlayerView = findViewById(R.id.youtubePlayer);

        onInitializedListener = new YouTubePlayer.OnInitializedListener()
        {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {
                if(!b)
                {
                    originalYouTubePlayer = youTubePlayer;
                    // Play video.
                    originalYouTubePlayer.cueVideo(getLink(link));
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(YoutubeSettings.getApiKey(), onInitializedListener);
    }

    // Convert url to the correct string format - youtube.com/watch?v=XXXXXXXXXXX.
    public String getLink(String url)
    {
        // Parse string to uri.
        Uri uri = Uri.parse(url);

        // Get Query.
        String link = uri.getQueryParameter("v");

        return link;
    }
}