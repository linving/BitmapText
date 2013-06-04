/**
 * 
 */
package com.linving.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageText extends Activity {
	ImageView img;

	private Bitmap imgMarker;
	private int width, height; // 图片的高度和宽带
	private Bitmap imgTemp; // 临时标记图
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img = (ImageView) findViewById(R.id.img);

		imgMarker = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		width = imgMarker.getWidth();
		height = imgMarker.getHeight();
		// img.setBackgroundDrawable(createDrawable("inhao"));
		img.setImageDrawable(createDrawable("你好"));
	}

	// 穿件带字母的标记图片
	private Drawable createDrawable(String letter) {
		imgTemp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(imgTemp);
		Paint paint = new Paint(); // 建立画笔
		paint.setDither(true);
		// paint.setTextSize(20);
		paint.setColor(Color.WHITE);
		paint.setFilterBitmap(true);
		Rect src = new Rect(0, 0, width, height);
		Rect dst = new Rect(0, 0, width, height);
		canvas.drawBitmap(imgMarker, src, dst, paint);
		Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);
		textPaint.setTextSize(20.0f);
		textPaint.setTypeface(Typeface.DEFAULT_BOLD); // 采用默认的宽度
		textPaint.setColor(Color.BLACK);
		canvas.drawText(letter, width / 2 -10, height / 2 + 10, textPaint);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		return (Drawable) new BitmapDrawable(getResources(), imgTemp);
	}

}
