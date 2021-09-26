package application;

public class Objet {
	
	private String name;
	private float weight;
	private float value;
	private boolean isInTheBag;
	private float ratio;
	
	public Objet(String name, float weight, float value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isInTheBag = false;
		this.ratio = value/weight;
	}

	public String getName() {
		return name;
	}

	public float getWeight() {
		return weight;
	}

	public float getValue() {
		return value;
	}
	
	public float getRatio() {
		return ratio;
	}
	
}
