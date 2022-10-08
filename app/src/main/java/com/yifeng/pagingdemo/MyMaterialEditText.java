package com.yifeng.pagingdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class MyMaterialEditText extends androidx.appcompat.widget.AppCompatEditText {

    private final int TEXT_SIZE = ScreenUtils.sp2px(12);

    private final int TEXT_MARGIN = ScreenUtils.dip2px(8);

    private final int HORIZONTAL_OFFSET = ScreenUtils.dip2px(5);

    private final int VERTICAL_OFFSET = ScreenUtils.dip2px(18);

    private final Paint newPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyMaterialEditText(Context context) {
        super(context);
        init();
    }

    public MyMaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPadding(getPaddingLeft(), getPaddingTop() + TEXT_SIZE + TEXT_MARGIN, getPaddingRight(), getPaddingBottom());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(getHint().toString(), HORIZONTAL_OFFSET, VERTICAL_OFFSET, newPaint);
    }
}
