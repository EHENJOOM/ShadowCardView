package com.zhk.shadowcardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ShadowCardView extends FrameLayout {

    private static final int SHADOW_COLOR =R.color.shadow_color;
    private static final int CARD_COLOR =R.color.card_color;
    private static final int CORNERS_RADIUS=0;
    private static final int SHADOW_RADIUS=10;
    private static final int SHADOW_TOP_HEIGHT=5;
    private static final int SHADOW_LEFT_HEIGHT=5;
    private static final int SHADOW_RIGHT_HEIGHT=5;
    private static final int SHADOW_BOTTOM_HEIGHT=5;
    private static final int SHADOW_OFFSET_Y=0;
    private static final int SHADOW_OFFSET_X=SHADOW_TOP_HEIGHT/3;

    private int cornersRadius;
    private int shadowColor;
    private int cardColor;
    private int shadowRadius;
    private int shadowOffsetY;
    private int shadowOffsetX;
    private int shadowTopHeight;
    private int shadowLeftHeight;
    private int shadowRightHeight;
    private int shadowBottomHeight;

    public ShadowCardView(Context context){
        this(context,null);
    }

    public ShadowCardView(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }

    public ShadowCardView(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        initView(context, attrs);
    }

    public ShadowCardView setShadowColor(int shadowColor){
        this.shadowColor=shadowColor;
        return this;
    }

    public ShadowCardView setCardColor(int cardColor){
        this.cardColor=cardColor;
        return this;
    }

    public ShadowCardView setCornersRadius(int cornersRadius){
        this.cornersRadius=cornersRadius;
        return this;
    }

    public ShadowCardView setShadowRadius(int shadowRadius){
        this.shadowRadius=shadowRadius;
        return this;
    }

    public ShadowCardView setShadowTopHeight(int shadowTopHeight){
        this.shadowTopHeight=shadowTopHeight;
        return this;
    }

    public ShadowCardView setShadowLeftHeight(int shadowLeftHeight){
        this.shadowLeftHeight=shadowLeftHeight;
        return this;
    }

    public ShadowCardView setShadowRightHeight(int shadowRightHeight){
        this.shadowRightHeight=shadowRightHeight;
        return this;
    }

    public ShadowCardView setShadowBottomHeight(int shadowBottomHeight){
        this.shadowBottomHeight=shadowBottomHeight;
        return this;
    }

    public ShadowCardView setShadowOffsetY(int shadowOffsetY){
        this.shadowOffsetY=shadowOffsetY;
        return this;
    }

    public ShadowCardView setShadowOffsetX(int shadowOffsetX){
        this.shadowOffsetX=shadowOffsetX;
        return this;
    }

    private void initView(Context context,AttributeSet attrs){
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.ShadowCardView);
        cornersRadius=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_cornersRadius,CORNERS_RADIUS);
        shadowColor=typedArray.getColor(R.styleable.ShadowCardView_shadowColor,getResources().getColor(SHADOW_COLOR));
        cardColor=typedArray.getColor(R.styleable.ShadowCardView_cardColor,getResources().getColor(CARD_COLOR));
        shadowTopHeight=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_shadowTopHeight,dp2px(context,SHADOW_TOP_HEIGHT));
        shadowLeftHeight=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_shadowLeftHeight,dp2px(context,SHADOW_LEFT_HEIGHT));
        shadowRightHeight=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_shadowRightHeight,dp2px(context,SHADOW_RIGHT_HEIGHT));
        shadowBottomHeight=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_shadowBottomHeight,dp2px(context,SHADOW_BOTTOM_HEIGHT));
        shadowOffsetX=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_shadowOffsetX,dp2px(context,SHADOW_OFFSET_X));
        shadowOffsetY=typedArray.getDimensionPixelSize(R.styleable.ShadowCardView_shadowOffsetY,dp2px(context,SHADOW_OFFSET_Y));
        shadowRadius=typedArray.getInteger(R.styleable.ShadowCardView_shadowRadius,SHADOW_RADIUS);
        typedArray.recycle();
        setPadding(shadowLeftHeight,shadowTopHeight,shadowRightHeight,shadowBottomHeight);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
    }

    public static int dp2px(Context context,float dipValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dipValue*scale+0.5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(cardColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        float left=shadowLeftHeight;
        float top=shadowTopHeight;
        float right=getWidth()-shadowRightHeight;
        float bottom=getHeight()-shadowBottomHeight;

        paint.setShadowLayer(shadowRadius,shadowOffsetX,shadowOffsetY,shadowColor);
        RectF rectF=new RectF(left,top,right,bottom);
        canvas.drawRoundRect(rectF, cornersRadius, cornersRadius,paint);
        canvas.save();
        super.dispatchDraw(canvas);
    }
}
