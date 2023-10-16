package libjam.gfx.renderer.overlay;

import libjam.gfx.ReferenceRenderingContext;
import libjam.math.Vector;
import libjam.physx.WorldObject;

import java.awt.Color;
import java.awt.Graphics;

public class VectorRenderer implements OverlayRenderer {


    @Override
    public WorldObject draw(
            final Graphics g,
            final WorldObject obj,
            final ReferenceRenderingContext referenceRenderingContext
    ) {

        ReferenceRenderingContext context = referenceRenderingContext;

        int x = context.toX(obj.getX());
        int y = context.toY(obj.getY());
        int w = context.toWidth(obj.getWidth());
        int h = context.toHeight(obj.getHeight());

        int xStart = x + w/2;
        int yStart = y + h/2;
        int vectorLength = 60;
        int labelOffset = 10;

        g.setColor(Color.WHITE);

        String ySpeed =  String.format("%.2f", obj.getYVector().getAt(1));
        String xSpeed =  String.format("%.2f", obj.getXVector().getAt(0));


        // y-Vector
        g.setColor(Color.BLUE);
        g.drawLine (
                xStart,
                yStart,
                xStart,
                yStart + vectorLength
        );

        g.setColor(Color.WHITE);
        g.drawString(
                ySpeed,
                xStart + labelOffset,
                yStart + vectorLength / 2
        );


        g.setColor(Color.WHITE);
        g.drawString(
                xSpeed,
                xStart  + vectorLength / 2,
                yStart - labelOffset
        );

        g.setColor(Color.BLUE);
        g.drawLine (
                xStart,
                yStart,
                xStart + vectorLength,
                yStart
        );


        g.setColor(Color.BLUE);
        g.drawLine (
                xStart,
                yStart,
                xStart + vectorLength,
                yStart
        );

        Vector movementVector = obj.getMovementVector();
        g.setColor(Color.GREEN);
        g.drawLine (
                xStart,
                yStart,
                (int) (xStart + movementVector.getAt(0)),
                (int) (yStart + movementVector.getAt(1))
        );

        return obj;
    }
}
