package application;

public class ABR {
	
	private final ABR parent;
	private ABR leftSon;
	private ABR rightSon;
	
	private final int depth;
	private final float values;
	private final float weight;
	private int index;
	
	public ABR(ABR parent, float values, float weight, int index) {
		this.parent = parent;
		this.depth = parent.depth + 1;
		this.values = values;
		this.weight = weight;
		this.index = index;
		
	}
	
	public ABR() {
		this.parent = this;
		this.depth = 0;
		this.values = 0;
		this.weight = 0;
	}
	
	public void setRightSon() {
		this.rightSon = new ABR(this, this.values, this.weight, -1);
	}
	
	public void setLeftSon(Objet obj, int index) {
		this.leftSon = new ABR(this, this.values + obj.getValue(), this.weight + obj.getWeight(), index);
	}

	public ABR getParent() {
		return parent;
	}

	public ABR getLeftSon() {
		return leftSon;
	}

	public ABR getRightSon() {
		return rightSon;
	}

	public int getIndex() {
		return index;
	}
	
	public float getValues() {
		return values;
	}

	public float getWeight() {
		return weight;
	}
	
	public boolean isRoot() {
		if (this.depth == 0)
			return true;
		else
			return false;
	}
	
	
}
