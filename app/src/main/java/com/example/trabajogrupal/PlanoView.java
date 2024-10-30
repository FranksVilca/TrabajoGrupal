package com.example.trabajogrupal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet; // Asegúrate de tener esta importación

import java.util.ArrayList;
import java.util.List;

public class PlanoView extends View {
    private Paint paint;
    private List<Ambiente> ambientes;
    private OnAmbienteClickListener onAmbienteClickListener;

    public PlanoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        ambientes = new ArrayList<>();
    }

    public interface OnAmbienteClickListener {
        void onAmbienteClick(Ambiente ambiente);
    }

    public void setOnAmbienteClickListener(OnAmbienteClickListener listener) {
        this.onAmbienteClickListener = listener;
    }

    public void setAmbientes(List<Ambiente> ambientesList) {
        ambientes.clear();
        ambientes.addAll(ambientesList);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Ambiente ambiente : ambientes) {
            canvas.drawRect(ambiente.getX1(), ambiente.getY1(), ambiente.getX2(), ambiente.getY2(), paint);
            canvas.drawText(ambiente.getNombre(), ambiente.getX1() + 10, ambiente.getY1() + 30, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (Ambiente ambiente : ambientes) {
                if (event.getX() >= ambiente.getX1() && event.getX() <= ambiente.getX2() &&
                        event.getY() >= ambiente.getY1() && event.getY() <= ambiente.getY2()) {
                    if (onAmbienteClickListener != null) {
                        onAmbienteClickListener.onAmbienteClick(ambiente);
                    }
                    break;
                }
            }
        }
        return true;
    }
}
