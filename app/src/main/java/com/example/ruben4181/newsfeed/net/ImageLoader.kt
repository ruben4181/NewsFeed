package com.example.ruben4181.newsfeed.net

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.net.URLConnection

/**
 * Created by ruben4181 on 8/03/2019.
 */
class ImageLoader(val imgView : ImageView) : AsyncTask<String, Int, Bitmap>(){
    override fun doInBackground(vararg params: String): Bitmap {
        return DownloadImage(params[0])
    }

    override fun onPostExecute(result: Bitmap) {
        super.onPostExecute(result)
        imgView.setImageBitmap(result)
    }

    fun DownloadImage(url : String) : Bitmap{
        lateinit var bitmap : Bitmap
        try {
            val imgURL = URL(url)
            val conn: URLConnection = imgURL.openConnection()
            conn.connect()
            val inputStream = conn.getInputStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e : IOException){
            Log.e("ERROR DOWNLOADING IMAGE", e.message.toString())
        }
        return bitmap
    }
}