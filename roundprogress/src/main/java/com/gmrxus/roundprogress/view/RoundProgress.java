package com.gmrxus.roundprogress.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gmrxus.roundprogress.R;

/**
 * Created by mac on 2017/4/17.
 */

public class RoundProgress extends View {

    private TypedArray mTa;
    private int backColor;
    private int roundColor;
    private int textColor;
    private float radius;
    private float roundWidth;
    private float textSize;

    private Paint backPaint;
    private RectF mRectF;
    private Paint roundPaint;
    private Paint textPaint;

    private int progress = 0;
    private int maxProgress = 100;
    private int mProgress;

    public RoundProgress(Context context) {
        this(context, null);
    }

    public RoundProgress(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTa = context.obtainStyledAttributes(attrs, R.styleable.round_progress, defStyleAttr, 0);
        backColor = mTa.getColor(R.styleable.round_progress_backColor, Color.GRAY);
        roundColor = mTa.getColor(R.styleable.round_progress_roundColor, getResources().getColor(R.color.colorAccent,
                context.getTheme()));
        radius = mTa.getDimension(R.styleable.round_progress_radius, 100f);
        roundWidth = mTa.getDimension(R.styleable.round_progress_roundWidth, 10f);
        textSize = mTa.getDimension(R.styleable.round_progress_textSize, 36f);
        textColor = mTa.getColor(R.styleable.round_progress_textColor, getResources().getColor(R.color.colorAccent,
                context
                        .getTheme()));
        init();


    }

    private void init() {

        backPaint = new Paint();
        backPaint.setColor(backColor);
        backPaint.setStyle(Paint.Style.STROKE);
        backPaint.setStrokeWidth(roundWidth);
        backPaint.setAntiAlias(true);

        mRectF = new RectF(roundWidth / 2, roundWidth / 2, radius * 2 + roundWidth / 2, radius * 2 + roundWidth / 2);

        roundPaint = new Paint();
        roundPaint.setColor(roundColor);
        roundPaint.setStyle(Paint.Style.STROKE);
        roundPaint.setStrokeWidth(roundWidth);
        backPaint.setAntiAlias(true);


        textPaint = new Paint();
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);
        backPaint.setAntiAlias(true);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (progress > mProgress) {
            mProgress++;
            invalidate();
        }
        canvas.drawCircle(radius + roundWidth / 2, radius + roundWidth / 2, radius, backPaint);

        canvas.drawArc(mRectF, -90, mProgress * 360 / maxProgress, false, roundPaint);

        canvas.drawText(mProgress * 100 / maxProgress + "%", radius + roundWidth / 2, radius + roundWidth * 2,
                textPaint);
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    public void setRoundColor(@ColorRes int color) {
        this.roundColor = color;
    }

    public void setTextColor(@ColorRes int color) {
        this.textColor = color;
    }
}
