package com.space.state;

import java.awt.*;

public interface SuperStateMachine
{
    public abstract void update(double delta);
    public abstract void draw(Graphics2D g);
    public abstract void init(Canvas canvas);

}
