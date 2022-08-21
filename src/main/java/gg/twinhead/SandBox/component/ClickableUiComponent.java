package gg.twinhead.SandBox.component;

import gg.twinhead.SandBox.util.MouseHandler;

import java.awt.*;

public class ClickableUiComponent extends Component{


	MouseHandler mouseHandler;

	public ClickableUiComponent(int x, int y, int w, int h, MouseHandler mouseHandler){
		super(x, y, w, h);
		this.mouseHandler = mouseHandler;
	}


	@Override
	public void update(){
		if(mouseHandler.mouse1){
			if (getBounds().contains(mouseHandler.mousePos)){
				onClick();
			}
		}
	}


	public void onClick(){}


}
