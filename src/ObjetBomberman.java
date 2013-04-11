
public class ObjetBomberman {
	protected int position_x;
	protected int position_y;
	
	public ObjetBomberman(int x, int y){
		this.position_x = x;
		this.position_y = y;
	}
	
	public void setPositionX(int x){
		this.position_x = x;
	}
	
	public void setPositionY(int y){
		this.position_y = y;
	}
	
	public int getPositionX(){
		return this.position_x;
	}
	
	public int getPositionY(){
		return this.position_y;
	}
	public boolean equals(ObjetBomberman o){
		boolean r=false;
		if (this.position_x == o.position_x)
			if(this.position_y == o.position_y)
				r=true;
		return r;
	}
	
}
