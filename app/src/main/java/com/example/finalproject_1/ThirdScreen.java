package com.example.finalproject_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThirdScreen extends AppCompatActivity {
    public String fileName;
    public int columns;
    public int rows;
    public ImageView imageView;

//    public Bitmap getImage() {
//        return Bitmap.createBitmap(fileName);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_second);
        Intent intent = getIntent();
        fileName = intent.getStringExtra("URL");
        imageView = findViewById(R.id.imageView);
        try {

            //Provide number of rows and column
            URL url = new URL(fileName);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //EditText imageSource = findViewById(R.id.imageSource);
        //imageSource.setInputType(InputType.TYPE_CLASS_TEXT);
//        Button enterURL = findViewById(R.id.enterURL);
//        enterURL.setOnClickListener(v -> {
//            startActivity(new Intent(this, ThirdScreen.class));
//            finish();
//        });
    }
    public void SplitImage(String setFileName, int setRows, int setColumns) {
        fileName = setFileName;
        columns = setColumns;
        rows = setRows;


        //https://gist.github.com/madan712/3672616

        try {

            //Provide number of rows and column
            URL url = new URL(fileName);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bmp);
            System.out.print(bmp);

//                File file = new File(fileName);
//                Image image = new Image(file.toURI().toString());
//                imageView = new ImageView(image);

            //BufferedImage originalImgage = ImageView;

            //total width and total height of an image
            int Width = bmp.getWidth();
            int Height = bmp.getHeight();

            System.out.println("Image Dimension: " + Width + "x" + Height);

            //width and height of each piece
            int eWidth = Width / columns;
            int eHeight = Height / rows;

            int x = 0;
            int y = 0;

            for (int i = 0; i < rows; i++) {
                y = 0;
                for (int j = 0; j < columns; j++) {
                    try {
                        System.out.println("creating piece: " + i + " " + j);

                        //BufferedImage SubImage = bmp.getSubImage(y, x, eWidth, eHeight);
                        //Bitmap SubImage = bmp.getSubImage(y, x, eWidth, eHeight);
                        Bitmap SubImage = Bitmap.createBitmap(bmp, y, x, eWidth, eHeight);
                        File outputFile = new File(fileName + i + j + ".jpg");
                        //ImageIO.write(SubImage, "jpg", outputFile);

                        BitmapFactory.decodeFile(fileName + i + j + "jpg");

                        y += eWidth;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                x += eHeight;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
