/*
 * Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.unibo.sistemidigitali.exam.jhon_ai;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import it.unibo.sistemidigitali.exam.jhon_ai.data.FileUtil;
import it.unibo.sistemidigitali.exam.jhon_ai.data.MovieItem;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Movie;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Utterance;
import it.unibo.sistemidigitali.exam.jhon_ai.mongodb.MongoDb;

/** The main activity to provide interactions with users. */
public class RecomendationAcivity extends AppCompatActivity
    implements
        RecommendationFragment.OnListFragmentInteractionListener {
  private static final String TAG = "OnDeviceRecommendationDemo";
  private static final String CONFIG_PATH = "config.json";  // Default config path in assets.

  private Config config;
  private RecommendationClient client;

  private final List<MovieItem> allMovies = new ArrayList<>();
  private final List<MovieItem> selectedMovies = new ArrayList<>();

  private Handler handler;
 // private MovieFragment movieFragment;
  private RecommendationFragment recommendationFragment;

  private TextView movie_name;
  private TextView link_name;
  private TextView quote;

  private Button btnRecomendation;



    @SuppressLint("MissingInflatedId")
    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recomendation_activity);
    Log.v(TAG, "onCreate");


    String name = getIntent().getStringExtra("MOVIE");

        movie_name = findViewById(R.id.movie_name);
        movie_name.setText(getIntent().getStringExtra("MOVIE"));
        quote = findViewById(R.id.quote);
        quote.setText(getIntent().getStringExtra("TEXT"));

        link_name= findViewById(R.id.link_name);
        link_name.setText(getIntent().getStringExtra("LINK"));
        btnRecomendation = findViewById(R.id.button_recomendation);




        // Load config file.
    try {
      config = FileUtil.loadConfig(getAssets(), CONFIG_PATH);
    } catch (IOException ex) {
      Log.e(TAG, String.format("Error occurs when loading config %s: %s.", CONFIG_PATH, ex));
    }

    // Load movies list.

            try {
                allMovies.clear();
                allMovies.addAll(FileUtil.loadMovieList(getAssets(), config.movieList));
            } catch (IOException ex) {
                Log.e(TAG, String.format("Error occurs when loading movies %s: %s.", config.movieList, ex));
            }

    client = new RecommendationClient(this, config);
    handler = new Handler();
  //  movieFragment =
       // (MovieFragment) getSupportFragmentManager().findFragmentById(R.id.movie_fragment);
    recommendationFragment =
        (RecommendationFragment)
            getSupportFragmentManager().findFragmentById(R.id.recommendation_fragment);
    //add if
///////////////////////////////////

        btnRecomendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MovieItem filmo = findItem(name);
                if(filmo != null) {
                    filmo.selected=true;
                    List<MovieItem> movielo = new ArrayList<MovieItem>();
                    movielo.add(filmo);


                    if (!movielo.isEmpty()) {
                        // Log selected movies.
                        StringBuilder sb = new StringBuilder();
                        sb.append("Select movies in the following order:\n");
                        for (MovieItem movie : movielo) {
                            sb.append(String.format("  movie: %s\n", movie));
                        }
                        Log.d(TAG, sb.toString());

                        // Recommend based on selected movies.
                        recommend(movielo);
                    } else {
                        // Clear result list.
                        showResult(new ArrayList<RecommendationClient.Result>());
                    }
                    System.out.println(filmo.toString());
                }else{
                    System.out.println("ERRORE");
                    Toast.makeText(getApplicationContext(),"Ops we cannot recomend you any film!",Toast.LENGTH_LONG).show();

                }



                // recommend(favoriteMovies);


                ///////////////////////////////////
            }
        });


  }

  @SuppressWarnings("AndroidJdkLibsChecker")
  @Override
  protected void onStart() {
    super.onStart();
    Log.v(TAG, "onStart");

    // Add favorite movies to the fragment.
    List<MovieItem> favoriteMovies =
        allMovies.stream().limit(config.favoriteListSize).collect(Collectors.toList());
    //movieFragment.setMovies(favoriteMovies);

    handler.post(
        () -> {
          client.load();
        });
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.v(TAG, "onStop");
    handler.post(
        () -> {
          client.unload();
        });
  }

  /** Sends selected movie list and get recommendations. */
  private void recommend(final List<MovieItem> movies) {
    handler.post(
        () -> {
          // Run inference with TF Lite.
          Log.d(TAG, "Run inference with TFLite model."+movies.get(0).toString());
          List<RecommendationClient.Result> recommendations = client.recommend(movies);


          // Show result on screen
          showResult(recommendations);
        });
  }

  /** Shows result on the screen. */
  private void showResult(final List<RecommendationClient.Result> recommendations) {
    // Run on UI thread as we'll updating our app UI
    runOnUiThread(() -> recommendationFragment.setRecommendations(recommendations));
  }
/*
  @Override
  public void onItemSelectionChange(MovieItem item) {
    if (item.selected) {
      if (!selectedMovies.contains(item)) {
        selectedMovies.add(item);
      }
    } else {
      selectedMovies.remove(item);
    }

    if (!selectedMovies.isEmpty()) {
      // Log selected movies.
      StringBuilder sb = new StringBuilder();
      sb.append("Select movies in the following order:\n");
      for (MovieItem movie : selectedMovies) {
        sb.append(String.format("  movie: %s\n", movie));
      }
      Log.d(TAG, sb.toString());

      // Recommend based on selected movies.
      recommend(selectedMovies);
    } else {
      // Clear result list.
      showResult(new ArrayList<RecommendationClient.Result>());
    }
  }



  /* Handles click event of recommended movie. */
  @Override
  public void onClickRecommendedMovie(MovieItem item) {
    // Show message for the clicked movie.
    String message = String.format("Clicked recommended movie: %s.", item.title);
    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }


  public MovieItem findItem(String movie) {

    List<MovieItem> contains= new ArrayList<>();


    for (int i = 0; i < allMovies.size(); i++) {

      if (allMovies.get(i).title.toLowerCase().contains(movie.toLowerCase())) {

        contains.add(allMovies.get(i));

      }


    }
    for (int i=0; i<contains.size(); i++){
      Log.d("GETFILMO", contains.get(i).title);


    }
    for(int i= 0; i<contains.size();i++) {
      String[] tkn = contains.get(i).title.split(" ");
      String s="";
      for (int j= 0; j<tkn.length-1; j++) {


        s = s + tkn[j]+ " ";

        Log.d("SFILMO", s);
        if (s.trim().equalsIgnoreCase(movie.trim())) {
          return new MovieItem(contains.get(i).id, contains.get(i).title, contains.get(i).genres, contains.get(i).count);

        }
      }



    }
    return null;
  }


    public static File dataDir()
    {
        File sdcard = Environment.getExternalStorageDirectory();
        if( sdcard == null || !sdcard.isDirectory() ) {
            // TODO: warning popup
            Log.w(TAG, "Storage card not found " + sdcard);
            return null;
        }
        File datadir = new File(sdcard, "MyApplication");
        if( !confirmDir(datadir) ) {
            // TODO: warning popup
            Log.w(TAG, "Unable to create " + datadir);
            return null;
        }
        return datadir;
    }


    /**
     * Create dir if necessary, return true on success
     */
    public static final boolean confirmDir(File dir) {
        if( dir.isDirectory() ) return true;
        if( dir.exists() ) return false;
        return dir.mkdirs();
    }
}
